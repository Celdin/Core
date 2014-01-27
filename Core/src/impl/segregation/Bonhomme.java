package impl.segregation;

import java.util.ArrayList;

import abs.EnvironnementAbs;

public class Bonhomme extends AgentHurbain{

	public Bonhomme(String nom,int confort, int x, int y) {
		super(nom,confort, x, y);
	}

	public Boolean estContent(EnvironmentSegregation univert){
		int etrange = 0;
		ArrayList<AgentHurbain> bonhomes = univert.voisins(pos_x, pos_y);
		for (AgentHurbain bonhomme : bonhomes)
			if(bonhomme != null && bonhomme.type!=type)
				etrange++;
		return !(((float)etrange/(float)bonhomes.size())*100 > 100-confort);
	}
	
	@Override
	public EnvironnementAbs run(EnvironnementAbs env) {
		EnvironmentSegregation univert = (EnvironmentSegregation) env;
		if(!estContent(univert ))
			return move(univert);
		return univert;
	}
}
