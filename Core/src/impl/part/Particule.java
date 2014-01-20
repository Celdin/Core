package impl.part;

public class Particule extends AgentParticule{

	/**
	 * @param name nom
	 * @param x position en x
	 * @param y position en y
	 * @param m_x force de poussée en x
	 * @param m_y force de poussée en y
	 */
	public Particule(String name,int x, int y,int m_x,int m_y) {
		super(name,x, y);
		mov_x=m_x;
		mov_y=m_y;
	}

	/* (non-Javadoc)
	 * @see abs.Agent#run(impl.Environment)
	 */
	@Override
	public EnvironmentParticule run(EnvironmentParticule univert) {
		//la seule chose que sait faire une particule: Bouger !
		return move(univert);
	}
	
	/**
	 * l'agent à decidé de bouger
	 * @param univert l'environement
	 * @return l'environement après qu'il ai bougé
	 */
	public EnvironmentParticule move(EnvironmentParticule univert){
		//si la grille n'est pas torique on tape les bords !
		if(!univert.torique){
			if(pos_x + mov_x >= univert.taille_envi || pos_x + mov_x < 0)
				mov_x = -mov_x;
			if(pos_y + mov_y >= univert.taille_envi || pos_y + mov_y <0)
				mov_y = -mov_y;
		}
		//percussionnage ! (oui Thomas je sais...)
		AgentParticule colision = (AgentParticule) univert.grille[(pos_x + mov_x + univert.taille_envi)%univert.taille_envi][(pos_y + mov_y + univert.taille_envi)%univert.taille_envi];
		if(colision != null){
			//en cas de colision on echange nos force (c'est pas realiste mais c'est deja pas mal)
			int a_m_x = mov_x;
			int a_m_y = mov_y;
			mov_x = colision.mov_x;
			mov_y = colision.mov_y;
			colision.mov_x = a_m_x;
			colision.mov_y = a_m_y;
		}
		
		//OMG ca bouge !
		univert.grille[pos_x][pos_y] = null;
		pos_x = (pos_x + mov_x + univert.taille_envi)%univert.taille_envi;
		pos_y = (pos_y + mov_y + univert.taille_envi)%univert.taille_envi;
		univert.grille[pos_x][pos_y] = this;
		return  univert;
	}

	@Override
	public String toString() {
		return name + ":["+pos_x+","+pos_y+"]";
	}
}
