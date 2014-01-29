package impl.pacMan;

import java.util.Random;

import abs.AgentAbs;
import abs.EnvironnementAbs;

public class PacMan extends AgentAbs {

	public PacMan(String nom, int x, int y) {
		super(nom, x, y);
	}

	@Override
	public EnvironnementAbs run(EnvironnementAbs env) {
		Random rand =new Random();
		int i,j;
		do{
			i = rand.nextInt(3) -1;
			j = rand.nextInt(3) -1;
		}while((pos_x+i < 0 || pos_x+i >=env.taille_envi) || (pos_y+j<0 || pos_y+j >= env.taille_envi) || env.grille[pos_x+i][pos_y+j] != null || (i==0 && j==0));
		env.grille[pos_x][pos_y] = null;
		pos_x += i;
		pos_y += j;
		env.grille[pos_x][pos_y] = this;
		return env;
	}

}
