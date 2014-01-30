package impl.eploration;

import java.awt.Point;

import abs.AgentAbs;
import abs.EnvironnementAbs;

public class Explorateur extends AgentAbs {

	public Explorateur(String nom, int x, int y) {
		super(nom, x, y);
	}

	@Override
	public EnvironnementAbs run(EnvironnementAbs env) {
		EnvironnementExplo univer = (EnvironnementExplo)env;
		Integer[][] dijstra = univer.cheminDijstra();
		Point pMin = new Point(pos_x, pos_y);
		int min = Integer.MAX_VALUE;
		for (int j = -1; j < 2; j++) {
			for (int i = -1; i < 2; i++) {
				if (pos_x + i >= 0 && pos_x + i < univer.taille_envi && pos_y + j >= 0
						&& pos_y + j < univer.taille_envi) {
					if (!(i == 0 && j == 0)) {
						if(!(univer.grille[pos_x + i][pos_y + j] instanceof Mur) && dijstra[pos_x + i][pos_y + j]<min){
							min = dijstra[pos_x + i][pos_y + j];
							pMin = new Point(pos_x + i, pos_y + j);
						}
					}
				}
			}
		}
		env.grille[pos_x][pos_y] = null;
		pos_x=pMin.x;
		pos_y=pMin.y;
		for (int j = -1; j < 2; j++) {
			for (int i = -1; i < 2; i++) {
				if (pos_x + i >= 0 && pos_x + i < univer.taille_envi && pos_y + j >= 0
						&& pos_y + j < univer.taille_envi && !(env.grille[pos_x + i][pos_y + j] instanceof Mur)) {
					env.grille[pos_x + i][pos_y + j] = new Carte("", pos_x + i, pos_y+j);
				}
			}
		}
		env.grille[pos_x][pos_y] = this;
		return env;
	}

}
