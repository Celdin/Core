package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import abs.Agent;

public class Requin extends Agent{

	int aPasMangerDepuis;

	public Requin(String nom, int x, int y) {
		super(nom,Type.REQUIN, x, y);
		aPasMangerDepuis = -1;
	}
	
	

	@Override
	public Environment run(Environment univert) {
		Random random = new Random();
		List <Agent> voisins = univert.voisins(pos_x, pos_y);
		boolean depalcementPossible = voisins.contains(null);
		List <Agent> peutManger = new ArrayList<Agent>();
		for(Agent agent : voisins){
			if(agent != null){
				if(agent.getType() == Type.POISSON){
					peutManger.add(agent);
					
				}
			}
		}
		cycleReproduction++;
		aPasMangerDepuis++;
		if(aPasMangerDepuis>=univert.maxTempsRequinSansManger){
			univert.grille[pos_x][pos_y] = null;
			return univert;
		}
		if(!peutManger.isEmpty()){
			Collections.shuffle(peutManger);
			aPasMangerDepuis = 0;
			
			univert.grille[pos_x][pos_y] =null;
			pos_x=peutManger.get(0).getPoint().x;
			pos_y=peutManger.get(0).getPoint().y;
			univert.grille[pos_x][pos_y] = this;
		}
		if(cycleReproduction>=univert.tempsReproductionRequin && depalcementPossible){
			int x = pos_x,y = pos_y;
			univert = move(univert);
			univert.grille[x][y] = new Requin(String.valueOf(SMA.agents.size()), x, y);
			cycleReproduction=-1;
		}else
			univert = move(univert);
		return univert;
	}
}
