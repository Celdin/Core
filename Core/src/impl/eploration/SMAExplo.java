package impl.eploration;

import java.util.List;
import java.util.Random;

import Vue.Exploration.Grille;
import abs.AgentAbs;
import abs.EnvironnementAbs;
import abs.SMAAbs;

public class SMAExplo extends SMAAbs {

	Grille vue = new Grille(environment);
	public SMAExplo(EnvironnementExplo environment, List<AgentAbs> agents) {
		super(environment, agents);
	}
	
	private void lab(EnvironnementAbs environnement){

		int x;
		int y;
		
		x = environnement.taille_envi/2;
		for(y  = environnement.taille_envi/8; y < environment.taille_envi-(environnement.taille_envi/8) + 1; y++){

			environment.grille[x][y] = new Mur("Mure", x, y);
			environment.grille[y][x] = new Mur("Mure", y, x);
		}
		
		x = environment.taille_envi/3;
		for (y = 0;y< environment.taille_envi/3+1;y++){
			environment.grille[x][y] = new Mur("Mure", x, y);
			environment.grille[y][(environment.taille_envi - 1) - x] = new Mur("Mure", y, (environment.taille_envi - 1) - x);
			environment.grille[(environment.taille_envi - 1) - x][(environment.taille_envi - 1) - y] = new Mur("Mure", (environment.taille_envi - 1) - x, (environment.taille_envi - 1) - y);
			environment.grille[(environment.taille_envi - 1) - y][x] = new Mur("Mure", (environment.taille_envi - 1) - y, x);
			
		}
	}

	@Override
	public void addAgent() {
		Random rand = new Random();
		int x,y;
		lab(environment);
		do {
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
		} while (environment.grille[x][y] != null);
		for (int j = -1; j < 2; j++) {
			for (int i = -1; i < 2; i++) {
				if (x + i >= 0 && x + i < environment.taille_envi && y + j >= 0
						&& y + j < environment.taille_envi && !(environment.grille[x + i][y + j] instanceof Mur)) {
					environment.grille[x + i][y + j] = new Carte("", x + i, y+j);
				}
			}
		}
		environment.grille[x][y] = new Explorateur("Icare", x, y);
		agents.add(environment.grille[x][y]);

	}

	private boolean containNull(EnvironnementAbs environment){
		for(int i = 0;i< environment.taille_envi;i++){
			for(int j = 0; j< environment.taille_envi;j++){
				if(environment.grille[i][j] == null)
					return true;
			}
		}
		return false;
	}
	@Override
	public void run(int n) throws InterruptedException {
		while(containNull(environment)){
			runOnce();
		}
	}

	@Override
	public void runOnce() throws InterruptedException {
		agents.get(0).run(environment);
		vue.grille();
		Thread.sleep(environment.wait_time);
	}

}
