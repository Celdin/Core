package impl;

import java.util.ArrayList;

import abs.Agent;

public class Environment{

	public int nb_agent_poisson;
	public int nb_agent_requin;
	public int taille_envi;
	public int taille_case;
	public int taille_vus;
	public int wait_time;
	public Agent grille[][];
	public Boolean torique = false;
	public int maxTempsRequinSansManger;
	public int tempsReproductionRequin;
	public int tempsReproductionPoisson;
	

	public Environment(int nb_agent_poisson,int tempsReproductionPoisson, int nb_agent_requin,int tempsReproductionRequin,int maxTempsRequinSansManger,
			int taille_envi, int taille_case, int taille_vus, int wait_time) {
		super();
		this.nb_agent_poisson = nb_agent_poisson;
		this.tempsReproductionPoisson = tempsReproductionPoisson;
		this.nb_agent_requin = nb_agent_requin;
		this.maxTempsRequinSansManger = maxTempsRequinSansManger;
		this.tempsReproductionRequin = tempsReproductionRequin;
		this.taille_envi = taille_envi;
		this.taille_case = taille_case;
		this.taille_vus = taille_vus;
		this.wait_time = wait_time;
		this.grille = new Agent[taille_envi][taille_envi];
	}
	
	public Environment(int nb_agent_poisson, int tempsReproductionPoisson,
			int nb_agent_requin, int tempsReproductionRequin,
			int maxTempsRequinSansManger, int taille_envi, int taille_case,
			int taille_vus, int wait_time, Boolean torique) {
		super();
		this.nb_agent_poisson = nb_agent_poisson;
		this.tempsReproductionPoisson = tempsReproductionPoisson;
		this.nb_agent_requin = nb_agent_requin;
		this.tempsReproductionRequin = tempsReproductionRequin;
		this.maxTempsRequinSansManger = maxTempsRequinSansManger;
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
			agents.add(grille[(x+taille_envi-1)%taille_envi][(y+1)%taille_envi]);
			agents.add(grille[x][(y+1)%taille_envi]);
			agents.add(grille[(x+1)%taille_envi][(y+1)%taille_envi]);
			
			//seconde ligne
			agents.add(grille[(x+taille_envi-1)%taille_envi][y]);
			agents.add(grille[(x+1)%taille_envi][y]);
			
			//troisiéme ligne
			agents.add(grille[(x+taille_envi-1)%taille_envi][(y+taille_envi-1)%taille_envi]);
			agents.add(grille[x][(y+taille_envi-1)%taille_envi]);
			agents.add(grille[(x+1)%taille_envi][(y+taille_envi-1)%taille_envi]);
		}else{
			//premiére ligne
			if(x!=0 && y != taille_envi-1)
			agents.add(grille[x-1][y+1]);
			
			if(y != taille_envi-1)
			agents.add(grille[x][y+1]);
			
			if(x!= taille_envi-1 && y != taille_envi-1)
			agents.add(grille[x+1][y+1]);
			
			//seconde ligne
			if(x!=0)
			agents.add(grille[x-1][y]);
			
			if(x!= taille_envi-1)
			agents.add(grille[x+1][y]);
			
			//troisiéme ligne
			if(x!=0 && y != 0)
			agents.add(grille[x-1][y-1]);
			
			if(y != 0)
			agents.add(grille[x][y-1]);
			
			if( x!= taille_envi-1 && y != 0)
			agents.add(grille[x+1][y-1]);
		}
		
		return agents;
	}
}
