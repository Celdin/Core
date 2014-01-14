package impl;

import abs.Agent;

public class Univert{
	
	public int max_x;
	public int max_y;
	public Agent grille[][];
	public Boolean torique = false;

	Univert(int x,int y){
		max_x = x;
		max_y = y;
		grille = new Agent[x][y];
	}
	Univert(int x,int y,Boolean torique){
		grille = new Agent[x][y];
		this.torique=torique;
	}
}
