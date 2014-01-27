package impl.part;

import java.awt.Color;
import java.util.Random;

import abs.AgentAbs;

public abstract class AgentParticule extends AgentAbs {
	
	public int mov_x,mov_y;
	public Color color;
	
	public AgentParticule(String nom,int x,int y){
		super(nom,x,y);
		Random rand = new Random();
		this.color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
	}

}
