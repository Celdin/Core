package impl.pacMan;

import java.awt.Point;

import abs.AgentAbs;
import abs.EnvironnementAbs;

public class Gost extends AgentAbs {

	public Gost(String nom, int x, int y) {
		super(nom, x, y);
	}

	@Override
	public EnvironnementAbs run(EnvironnementAbs env) {
		EnvironnementPacMan univ = (EnvironnementPacMan) env;
		int min = Integer.MAX_VALUE;
		Point pMin = new Point(pos_x, pos_y);
		for (int j = -1; j <= 1; j++)
			for (int i = -1; i <= 1; i++){
				if (pos_y + j >= 0 && pos_y + j < univ.taille_envi
						&& pos_x + i >= 0 && pos_x + i < univ.taille_envi && !(i == 0 && j ==0)){
					if(univ.dijkstra[pos_x + i][pos_y + j] == 0)
						univ.pacMan = false;
					if (univ.dijkstra[pos_x + i][pos_y + j] != -1
							&& univ.dijkstra[pos_x + i][pos_y + j] < min
							&& env.grille[pos_x + i][pos_y + j] == null) {
						min = univ.dijkstra[pos_x + i][pos_y + j];
						pMin = new Point(pos_x + i, pos_y + j);
					}
				}
			}
		env.grille[pos_x][pos_y] = null;
		pos_x = pMin.x;
		pos_y = pMin.y;
		env.grille[pos_x][pos_y] = this;
		return env;
	}

}
