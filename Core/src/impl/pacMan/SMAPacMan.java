package impl.pacMan;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Vue.PacMan.Grille;
import abs.AgentAbs;
import abs.SMAAbs;

public class SMAPacMan extends SMAAbs {

	Point pacMan;
	private Grille vue;

	public SMAPacMan(EnvironnementPacMan environment, List<AgentAbs> agents) {
		super(environment, agents);
		vue = new Grille(environment);
	}

	@Override
	public void addAgent() {
		Random rand = new Random();
		int x;
		int y;
		x = environment.taille_envi/3;
		for (y = 0;y< environment.taille_envi/3+1;y++){
			environment.grille[x][y] = new Mur("Mure", x, y);
			environment.grille[y][(environment.taille_envi - 1) - x] = new Mur("Mure", y, (environment.taille_envi - 1) - x);
			environment.grille[(environment.taille_envi - 1) - x][(environment.taille_envi - 1) - y] = new Mur("Mure", (environment.taille_envi - 1) - x, (environment.taille_envi - 1) - y);
			environment.grille[(environment.taille_envi - 1) - y][x] = new Mur("Mure", (environment.taille_envi - 1) - y, x);
			
		}
		do {
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
		} while (environment.grille[x][y] != null);
		pacMan = new Point(x, y);
		environment.grille[x][y] = new PacMan("PacMan", x, y);
		agents.add(environment.grille[x][y]);
		for (int i = 0; i < ((EnvironnementPacMan) environment).nbAgent; i++) {
			do {
				x = rand.nextInt(environment.taille_envi);
				y = rand.nextInt(environment.taille_envi);
			} while (environment.grille[x][y] != null);
			environment.grille[x][y] = new Gost("Gost" + i, x, y);
			agents.add(environment.grille[x][y]);
		}
			
		((EnvironnementPacMan) environment).goDijkstra(pacMan.x, pacMan.y);
	}

	@Override
	public void run(int n) throws InterruptedException {
		while (((EnvironnementPacMan) environment).pacMan) {
			runOnce();
		}
	}

	@Override
	public void runOnce() throws InterruptedException {
		Collections.shuffle(agents);
		vue.grille();
		for (AgentAbs agent : agents) {
			agent.run(environment);
			if (agent.name.equals("PacMan")){
				pacMan = new Point(agent.pos_x, agent.pos_y);
			((EnvironnementPacMan) environment).goDijkstra(pacMan.x, pacMan.y);
			}
		}
		Thread.sleep(environment.wait_time);
	}

}
