package impl;

import java.util.ArrayList;
import java.util.Random;

import abs.Agent;

public class Poisson extends Agent{

	public Poisson(String name,int x, int y) {
		super(name,Type.POISSON,x, y);
	}

	@Override
	public Environment run(Environment univert) {
		Random random = new Random();
		ArrayList<Agent> voisins = univert.voisins(pos_x, pos_y);
		boolean depalcementPossible = voisins.contains(null);
		cycleReproduction++;
		if(!vivant)
			return univert;
		for(Agent agent : voisins){
			if(agent == null);
			else if(agent.getType() == Type.REQUIN && depalcementPossible){
				return move(univert);
			}
		}
		if (depalcementPossible){
			univert = move(univert);
		}
		if (cycleReproduction >= univert.tempsReproductionPoisson && depalcementPossible){
			int x = pos_x,y = pos_y;
			univert = move(univert);
			univert.grille[x][y] = new Poisson(String.valueOf(SMA.agents.size()), x, y);
			cycleReproduction=-1;
		}
		return univert;
	}
}
