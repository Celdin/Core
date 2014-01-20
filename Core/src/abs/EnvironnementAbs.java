package abs;



public abstract class EnvironnementAbs {
	public int taille_envi;
	public int taille_case;
	public int taille_vus;
	public int wait_time;
	public AgentAbs grille[][];
	public Boolean torique = false;

	/**
	 * @param nb_agent nombre d'agents
	 * @param taille_envi la taille de l'environement
	 * @param taille_case la taille d'une case
	 * @param taille_vus la taille de la fenetre
	 * @param d temps d'attente entre deux cycle
	 */
	public EnvironnementAbs( int taille_envi, int taille_case,
			int taille_vus, int d) {
		super();
		this.taille_envi = taille_envi;
		this.taille_case = taille_case;
		this.taille_vus = taille_vus;
		this.wait_time = d;
		this.grille = new AgentAbs[taille_envi][taille_envi];
	}

	/**
	 * @param nb_agent nombre d'agents
	 * @param taille_envi la taille de l'environement
	 * @param taille_case la taille d'une case
	 * @param taille_vus la taille de la fenetre
	 * @param wait_time temps d'attente entre deux cycle
	 * @param torique si l'evironement est torique ou non
	 */
	public EnvironnementAbs( int taille_envi, int taille_case,
			int taille_vus, int wait_time, Boolean torique) {
		super();
		this.taille_envi = taille_envi;
		this.taille_case = taille_case;
		this.taille_vus = taille_vus;
		this.wait_time = wait_time;
		this.torique = torique;
		this.grille = new AgentAbs[taille_envi][taille_envi];
	}
}
