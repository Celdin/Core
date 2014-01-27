package impl.segregation;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import Vue.Segregation.Grille;
import abs.AgentAbs;
import abs.SMAAbs;

public class SMASegregation extends SMAAbs {

	private Grille vue;
	public SMASegregation(EnvironmentSegregation environment,List<AgentAbs> agents) {
		super(environment, agents);

		vue = new Grille(environment);
	}

	@Override
	public void addAgent() {
		Random rand = new Random();
		for(Integer i = 0;i<((EnvironmentSegregation)environment).nb_agent;i++){
			int x,y;
			do{
				x = rand.nextInt(environment.taille_envi);
				y = rand.nextInt(environment.taille_envi);
				}while(environment.grille[x][y] != null);
			AgentHurbain agent = new Bonhomme(i.toString(), ((EnvironmentSegregation)environment).seuil_confort, x, y);
			environment.grille[x][y]=agent;
			agents.add(agent);
		}
	}

	public void run() throws InterruptedException {
		int n = 0;
		while(n==agents.size()){
			for(AgentAbs agent : agents){
				if(((Bonhomme) agent).estContent((EnvironmentSegregation) environment));
					n++;
			}
			runOnce();
			Thread.sleep(environment.wait_time);
		}

	}

	@Override
	public void run(int n) throws InterruptedException {
		while(n!=agents.size()){
			n = 0;
			for(AgentAbs agent : agents){
				if(((Bonhomme) agent).estContent((EnvironmentSegregation) environment))
					n++;
			}
			runOnce();
			Thread.sleep(environment.wait_time);
		}
		
	}

	@Override
	public void runOnce() throws InterruptedException {
		Collections.shuffle(agents);
		
		for(AgentAbs agent : agents){
			//allez les mec faites qq chose!
			environment = ((AgentHurbain)agent).run((EnvironmentSegregation) environment);
		}
		vue.grille();
		
	}

}
