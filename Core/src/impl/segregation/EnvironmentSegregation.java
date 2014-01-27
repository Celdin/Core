package impl.segregation;

import java.util.ArrayList;

import abs.EnvironnementAbs;

public class EnvironmentSegregation extends EnvironnementAbs {

	protected int nb_agent;
	protected int seuil_confort;
	public EnvironmentSegregation(int nb_agent,int seuil_confort,int taille_envi, int taille_case,
			int taille_vus, int d) {
		super(taille_envi, taille_case, taille_vus, d);
		this.nb_agent=nb_agent;
		this.seuil_confort = seuil_confort;
	}

	public EnvironmentSegregation(int nb_agent,int seuil_confort,int taille_envi, int taille_case,
			int taille_vus, int wait_time, Boolean torique) {
		super(taille_envi, taille_case, taille_vus, wait_time, torique);
		this.nb_agent=nb_agent;
		this.seuil_confort = seuil_confort;
	}
	
	public ArrayList<AgentHurbain> voisins(int x,int y){
		ArrayList<AgentHurbain> agents = new ArrayList<AgentHurbain>();
		//premiére ligne
		if(x!=0 && y != taille_envi-1)
		agents.add((AgentHurbain) grille[x-1][y+1]);
		
		if(y != taille_envi-1)
		agents.add((AgentHurbain) grille[x][y+1]);
		
		if(x!= taille_envi-1 && y != taille_envi-1)
		agents.add((AgentHurbain) grille[x+1][y+1]);
		
		//seconde ligne
		if(x!=0)
		agents.add((AgentHurbain) grille[x-1][y]);
		
		if(x!= taille_envi-1)
		agents.add((AgentHurbain) grille[x+1][y]);
		
		//troisiéme ligne
		if(x!=0 && y != 0)
		agents.add((AgentHurbain) grille[x-1][y-1]);
		
		if(y != 0)
		agents.add((AgentHurbain) grille[x][y-1]);
		
		if( x!= taille_envi-1 && y != 0)
		agents.add((AgentHurbain) grille[x+1][y-1]);
		return agents;
	}
}
