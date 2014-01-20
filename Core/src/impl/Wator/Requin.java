package impl.Wator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Requin extends AgentSwatorAbs{

	int aPasMangerDepuis;

	public Requin(String nom, int x, int y) {
		super(nom,Type.REQUIN, x, y);
		aPasMangerDepuis = -1;
	}
	
	

	@Override
	public EnvironmentWator run(EnvironmentWator univert) {
		List <AgentSwatorAbs> voisins = univert.voisins(pos_x, pos_y);
		boolean depalcementPossible = voisins.contains(null);
		List <AgentSwatorAbs> peutManger = new ArrayList<AgentSwatorAbs>();
		for(AgentSwatorAbs agent : voisins){
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
			univert.grille[x][y] = new Requin(String.valueOf(SMAWator.size()), x, y);
			cycleReproduction=-1;
		}else
			univert = move(univert);
		return univert;
	}
}
