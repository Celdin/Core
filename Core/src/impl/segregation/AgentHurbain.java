package impl.segregation;
import java.util.Random;

import abs.AgentAbs;

public abstract class AgentHurbain extends AgentAbs {
	public Boolean type;
	protected int confort;
	
	public AgentHurbain(String nom,int confort,int x,int y){
		super(nom,x,y);
		Random rand = new Random();
		this.type = rand.nextBoolean();
		this.confort = confort;
	}

	protected EnvironnementSegregation move(EnvironnementSegregation univert) {
		Random rand = new Random();
		int x,y;
		do{
			x=rand.nextInt(univert.taille_envi);
			y=rand.nextInt(univert.taille_envi);
		}while(univert.grille[x][y]!=null);
		univert.grille[pos_x][pos_y]=null;
		pos_x=x;
		pos_y=y;
		univert.grille[pos_x][pos_y]=this;
		return univert;
	}
	
}
