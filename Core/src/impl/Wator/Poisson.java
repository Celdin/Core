package impl.Wator;

import java.util.ArrayList;

public class Poisson extends AgentSwatorAbs{

	public Poisson(String name,int x, int y) {
		super(name,Type.POISSON,x, y);
	}

	@Override
	public EnvironmentWator run(EnvironmentWator univert) {
		ArrayList<AgentSwatorAbs> voisins = univert.voisins(pos_x, pos_y);
		boolean depalcementPossible = voisins.contains(null);
		cycleReproduction++;
		if(!vivant)
			return univert;
		for(AgentSwatorAbs agent : voisins){
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
			univert.grille[x][y] = new Poisson(String.valueOf(SMAWator.size()), x, y);
			cycleReproduction=-1;
		}
		return univert;
	}

	
}
