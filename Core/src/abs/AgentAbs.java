package abs;



public abstract class AgentAbs {
	public String name;
	
	protected Integer pos_x;
	protected Integer pos_y;
	
	public AgentAbs(String nom,int x,int y){
		this.name = nom;
		pos_x=x;
		pos_y=y;
	}

	/**
	 * Donne la parole à cette agent pour qu'il fasse qq chose
	 * @param env l'enviroenement
	 * @return l'environement après que l'agent ai fait qq chose
	 */
	public abstract EnvironnementAbs run(EnvironnementAbs env);
}
