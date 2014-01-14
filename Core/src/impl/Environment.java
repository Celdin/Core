package impl;

import java.util.ArrayList;

import abs.Agent;

public class Environment{
	
	public int nb_agent;
	public int taille_envi;
	public int taille_case;
	public int taille_vus;
	public int wait_time;
	public Agent grille[][];
	public Boolean torique = false;

	public Environment(int nb_agent, int taille_envi, int taille_case,
			int taille_vus, int d) {
		super();
		this.nb_agent = nb_agent;
		this.taille_envi = taille_envi;
		this.taille_case = taille_case;
		this.taille_vus = taille_vus;
		this.wait_time = d;
		this.grille = new Agent[taille_envi][taille_envi];
	}

	public Environment(int nb_agent, int taille_envi, int taille_case,
			int taille_vus, int wait_time, Boolean torique) {
		super();
		this.nb_agent = nb_agent;
		this.taille_envi = taille_envi;
		this.taille_case = taille_case;
		this.taille_vus = taille_vus;
		this.wait_time = wait_time;
		this.grille = new Agent[taille_envi][taille_envi];
		this.torique = torique;
	}
	
	public ArrayList<Agent> voisins(int x,int y){
		ArrayList<Agent> agents = new ArrayList<Agent>();
		if(torique){
			//premiére ligne
			if(grille[x-1%taille_envi][y+1%taille_envi]!=null)
			agents.add(grille[x-1%taille_envi][y+1%taille_envi]);
			
			if(grille[x%taille_envi][y+1%taille_envi]!=null)
			agents.add(grille[x%taille_envi][y+1%taille_envi]);
			
			if(grille[x+1%taille_envi][y+1%taille_envi]!=null)
			agents.add(grille[x+1%taille_envi][y+1%taille_envi]);
			
			//seconde ligne
			if(grille[x-1%taille_envi][y%taille_envi]!=null)
			agents.add(grille[x-1%taille_envi][y%taille_envi]);
			
			if(grille[x+1%taille_envi][y%taille_envi]!=null)
			agents.add(grille[x+1%taille_envi][y%taille_envi]);
			
			//troisiéme ligne
			if(grille[x-1%taille_envi][y-1%taille_envi]!=null)
			agents.add(grille[x-1%taille_envi][y-1%taille_envi]);
			
			if(grille[x%taille_envi][y-1%taille_envi]!=null)
			agents.add(grille[x%taille_envi][y-1%taille_envi]);
			
			if(grille[x+1%taille_envi][y-1%taille_envi]!=null)
			agents.add(grille[x+1%taille_envi][y-1%taille_envi]);
		}else{
			//premiére ligne
			if(x!=0 && y != taille_envi && grille[x-1][y+1]!=null)
			agents.add(grille[x-1][y+1]);
			
			if(y != taille_envi && grille[x][y+1]!=null)
			agents.add(grille[x][y+1]);
			
			if(x!= taille_envi-1 && y != taille_envi && grille[x+1][y+1]!=null)
			agents.add(grille[x+1][y+1]);
			
			//seconde ligne
			if(x!=0 && grille[x-1][y]!=null)
			agents.add(grille[x-1][y]);
			
			if(x!= taille_envi-1 && grille[x+1][y]!=null)
			agents.add(grille[x+1][y]);
			
			//troisiéme ligne
			if(x!=0 && y != 0 && grille[x-1][y-1]!=null)
			agents.add(grille[x-1][y-1]);
			
			if(y != 0 && grille[x][y-1]!=null)
			agents.add(grille[x][y-1]);
			
			if( x!= taille_envi-1 && y != 0 && grille[x+1][y-1]!=null)
			agents.add(grille[x+1][y-1]);
		}
		
		return agents;
	}
}
