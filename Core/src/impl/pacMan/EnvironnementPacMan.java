package impl.pacMan;

import impl.eploration.Mur;

import java.awt.Point;
import java.util.Stack;

import abs.EnvironnementAbs;

public class EnvironnementPacMan extends EnvironnementAbs {
	
	public Integer dijkstra[][];
	public int nbAgent;
	public boolean pacMan;

	public EnvironnementPacMan(int nbAgent,int taille_envi, int taille_case, int taille_vus,
			int d) {
		super(taille_envi, taille_case, taille_vus, d);
		this.nbAgent = nbAgent;
		dijkstra = new Integer[taille_envi][taille_envi];
		for(int j=0;j<taille_envi;j++){
			for(int i=0;i<taille_envi;i++){
				dijkstra[i][j]=-1;
			}
		}
		pacMan = true;
	}

	public Stack<Point> uneEpaisseur(int x,int y,int p) {
		Stack<Point> toDo = new Stack<Point>();
		for(int j=-1;j<=1;j++){
			for(int i=-1;i<=1;i++){
				if(x+i < taille_envi &&
						x+i>=0 &&
						y+j < taille_envi&&
						y+j>=0 &&
						!(grille[x+i][y+j] instanceof Mur || grille[x+i][y+j] instanceof Gost) &&
						(dijkstra[x+i][y+j]==-1 ||
						dijkstra[x+i][y+j] > dijkstra[x][y]+1)){
					dijkstra[x+i][y+j]=p;
					toDo.add(new Point(x+i, y+j));
				}	
			}
		}
		return toDo;
	}
	
	public void goDijkstra(int x,int y) {
		int profondeur = 0;
		Stack<Point> toDo = new Stack<Point>();
		toDo.add(new Point(x, y));
		for(int j=0;j<taille_envi;j++){
			for(int i=0;i<taille_envi;i++){
				dijkstra[i][j]=-1;
			}
		}
		dijkstra[x][y]=profondeur;
		while(!toDo.isEmpty()){
			profondeur++;
			Point p = toDo.pop();
			toDo.addAll(uneEpaisseur(p.x, p.y, dijkstra[p.x][p.y]+1));
		}
			
	}
}
