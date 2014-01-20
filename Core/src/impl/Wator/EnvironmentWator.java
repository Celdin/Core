package impl.Wator;

import java.util.ArrayList;

import abs.EnvironnementAbs;

public class EnvironmentWator extends EnvironnementAbs{

	public int nb_agent_poisson;
	public int nb_agent_requin;
	public int taille_vus;
	public int maxTempsRequinSansManger;
	public int tempsReproductionRequin;
	public int tempsReproductionPoisson;
	

	public EnvironmentWator(int nb_agent_poisson,int tempsReproductionPoisson, int nb_agent_requin,int tempsReproductionRequin,int maxTempsRequinSansManger,
			int taille_envi, int taille_case, int taille_vus, int wait_time) {
		super(taille_envi,taille_case,taille_vus,wait_time);
		this.nb_agent_poisson = nb_agent_poisson;
		this.tempsReproductionPoisson = tempsReproductionPoisson;
		this.nb_agent_requin = nb_agent_requin;
		this.maxTempsRequinSansManger = maxTempsRequinSansManger;
		this.tempsReproductionRequin = tempsReproductionRequin;
		
	}
	
	public EnvironmentWator(int nb_agent_poisson, int tempsReproductionPoisson,
			int nb_agent_requin, int tempsReproductionRequin,
			int maxTempsRequinSansManger, int taille_envi, int taille_case,
			int taille_vus, int wait_time, Boolean torique) {
		super(taille_envi,taille_case,taille_vus,wait_time, torique);
		this.nb_agent_poisson = nb_agent_poisson;
		this.tempsReproductionPoisson = tempsReproductionPoisson;
		this.nb_agent_requin = nb_agent_requin;
		this.tempsReproductionRequin = tempsReproductionRequin;
		this.maxTempsRequinSansManger = maxTempsRequinSansManger;
		
	}

	public ArrayList<AgentSwatorAbs> voisins(int x,int y){
		ArrayList<AgentSwatorAbs> agents = new ArrayList<AgentSwatorAbs>();
		if(torique){
			//premiére ligne
			agents.add((AgentSwatorAbs) grille[(x+taille_envi-1)%taille_envi][(y+1)%taille_envi]);
			agents.add((AgentSwatorAbs) grille[x][(y+1)%taille_envi]);
			agents.add((AgentSwatorAbs) grille[(x+1)%taille_envi][(y+1)%taille_envi]);
			
			//seconde ligne
			agents.add((AgentSwatorAbs) grille[(x+taille_envi-1)%taille_envi][y]);
			agents.add((AgentSwatorAbs) grille[(x+1)%taille_envi][y]);
			
			//troisiéme ligne
			agents.add((AgentSwatorAbs) grille[(x+taille_envi-1)%taille_envi][(y+taille_envi-1)%taille_envi]);
			agents.add((AgentSwatorAbs) grille[x][(y+taille_envi-1)%taille_envi]);
			agents.add((AgentSwatorAbs) grille[(x+1)%taille_envi][(y+taille_envi-1)%taille_envi]);
		}else{
			//premiére ligne
			if(x!=0 && y != taille_envi-1)
			agents.add((AgentSwatorAbs) grille[x-1][y+1]);
			
			if(y != taille_envi-1)
			agents.add((AgentSwatorAbs) grille[x][y+1]);
			
			if(x!= taille_envi-1 && y != taille_envi-1)
			agents.add((AgentSwatorAbs) grille[x+1][y+1]);
			
			//seconde ligne
			if(x!=0)
			agents.add((AgentSwatorAbs) grille[x-1][y]);
			
			if(x!= taille_envi-1)
			agents.add((AgentSwatorAbs) grille[x+1][y]);
			
			//troisiéme ligne
			if(x!=0 && y != 0)
			agents.add((AgentSwatorAbs) grille[x-1][y-1]);
			
			if(y != 0)
			agents.add((AgentSwatorAbs) grille[x][y-1]);
			
			if( x!= taille_envi-1 && y != 0)
			agents.add((AgentSwatorAbs) grille[x+1][y-1]);
		}
		
		return agents;
	}
}
