package impl;

import abs.Agent;

public class Univert{
	
	public Agent grille[][];
	public Boolean torique = false;

	Univert(int x,int y){
		grille = new Agent[x][y];
	}
	Univert(int x,int y,Boolean torique){
		grille = new Agent[x][y];
		this.torique=torique;
	}
}
