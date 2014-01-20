package impl.part;

import abs.EnvironnementAbs;
import impl.part.*;

public class EnvironmentParticule extends EnvironnementAbs{
	
	public int nb_agent;
	

	/**
	 * @param nb_agent nombre d'agents
	 * @param taille_envi la taille de l'environement
	 * @param taille_case la taille d'une case
	 * @param taille_vus la taille de la fenetre
	 * @param d temps d'attente entre deux cycle
	 */
	public EnvironmentParticule(int nb_agent, int taille_envi, int taille_case,
			int taille_vus, int d) {
		super(taille_envi, taille_case,taille_vus,d);
		this.nb_agent = nb_agent;
		this.grille= new AgentParticule [taille_envi][taille_envi];
		
	}

	/**
	 * @param nb_agent nombre d'agents
	 * @param taille_envi la taille de l'environement
	 * @param taille_case la taille d'une case
	 * @param taille_vus la taille de la fenetre
	 * @param d temps d'attente entre deux cycle
	 * @param torique si l'evironement est torique ou non
	 */
	public EnvironmentParticule(int nb_agent, int taille_envi, int taille_case,
			int taille_vus, int wait_time, Boolean torique) {
		super(taille_envi, taille_case,taille_vus,wait_time,torique);
		
	}
}
