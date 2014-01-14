package impl;

import abs.Agent;
import abs.Environement;

public class Univert implements Environement{
	public Agent grille[][];
	Univert(int x,int y){
		grille = new Agent[x][y];
	}
}
