package impl.Wator;

import java.util.ArrayList;

import abs.EnvironnementAbs;

public class Poisson extends AgentSwatorAbs{

	public Poisson(String name,int x, int y) {
		super(name,Type.POISSON,x, y);
	}

	@Override
	public EnvironnementAbs run(EnvironnementAbs env) {
		EnvironmentWator univert = (EnvironmentWator)env;
		ArrayList<AgentSwatorAbs> voisins = univert.voisins(pos_x, pos_y);
		boolean depalcementPossible = voisins.contains(null);
		cycleReproduction++;
		int x = pos_x,y = pos_y;
		if (depalcementPossible){
			univert = move(univert);
		}
		if (cycleReproduction >= univert.tempsReproductionPoisson && depalcementPossible){
			univert.grille[x][y] = new Poisson(String.valueOf(SMAWator.size()), x, y);
			cycleReproduction=-1;
		}
		return univert;
	}

	
}
