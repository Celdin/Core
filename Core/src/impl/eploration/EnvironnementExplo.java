package impl.eploration;

import java.awt.Point;
import java.util.Stack;

import abs.EnvironnementAbs;

public class EnvironnementExplo extends EnvironnementAbs {

	public EnvironnementExplo(int taille_envi, int taille_case, int taille_vus,
			int d) {
		super(taille_envi, taille_case, taille_vus, d);
	}

	public Stack<Point> uneEpaisseur(int x, int y, int p, Integer dijkstra[][]) {
		Stack<Point> toDo = new Stack<Point>();
		for (int j = -1; j <= 1; j++) {
			for (int i = -1; i <= 1; i++) {
				if (x + i < taille_envi
						&& x + i >= 0
						&& y + j < taille_envi
						&& y + j >= 0
						&& !(grille[x + i][y + j] instanceof Mur)
						&& (dijkstra[x + i][y + j] == -1 || dijkstra[x + i][y
								+ j] > dijkstra[x][y] + 1)
						&& (i == 0 || j == 0)) {
					dijkstra[x + i][y + j] = p;
					toDo.add(new Point(x + i, y + j));
				}
			}
		}
		return toDo;
	}

	private boolean voisinContainCarte(int x, int y) {
		for (int j = -1; j < 2; j++) {
			for (int i = -1; i < 2; i++) {
				if (x + i >= 0 && x + i < taille_envi && y + j >= 0
						&& y + j < taille_envi) {
					if (!(i == 0 && j == 0)) {
						if (grille[x][y] == null && grille[x+i][y+j] instanceof Carte)
							return true;
					}
				}
			}
		}
		return false;
	}

	private Integer[][] goDijkstra(int x, int y) {
		int profondeur = 0;
		Integer dijkstra[][] = new Integer[taille_envi][taille_envi];
		Stack<Point> toDo = new Stack<Point>();
		toDo.add(new Point(x, y));
		for (int j = 0; j < taille_envi; j++) {
			for (int i = 0; i < taille_envi; i++) {
				dijkstra[i][j] = -1;
			}
		}
		dijkstra[x][y] = profondeur;
		while (!toDo.isEmpty()) {
			profondeur++;
			Point p = toDo.pop();
			toDo.addAll(uneEpaisseur(p.x, p.y, dijkstra[p.x][p.y] + 1, dijkstra));
		}
		return dijkstra;
	}

	public Integer[][] cheminDijstra() {
		Integer dijkstra[][] = null;
		Point pMin = new Point();
		int min = Integer.MAX_VALUE;
		for(int j = 0; j < taille_envi;j++){
			for(int i = 0; i < taille_envi; i++){
				if(grille[i][j] instanceof Explorateur){
					dijkstra= goDijkstra(i, j);
				}
			}
		}
		
		for(int j = 0; j < taille_envi;j++){
			for(int i = 0; i < taille_envi; i++){
				if(grille[i][j] == null && voisinContainCarte(i, j)){
					if(dijkstra[i][j]<min){
						min = dijkstra[i][j];
						pMin = new Point(i, j);
					}
				}
			}
		}
		
		return goDijkstra(pMin.x,pMin.y);
	}
}
