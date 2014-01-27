package impl.part;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Vue.Particule.Grille;
import abs.AgentAbs;
import abs.SMAAbs;


public class SMAParticule extends SMAAbs{


	private Grille vue;
	public SMAParticule(EnvironmentParticule environment, List<AgentAbs> agents) {
		super(environment,agents);
		
		vue = new Grille(environment);
	}
	
	public void addAgent(){
		Random rand = new Random();
		int x;
		int y;
		for(Integer i = 0;i < ((EnvironmentParticule)environment).nb_agent;i++){
			//on les place dans un coin au hazard (attention boucle infini si + d'Agent que de case)
			do{
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
			}while(environment.grille[x][y] != null);
			//on leur donne une force de mouvement au hazard (elles peuvents avoirs (0,0) ce qui fait qu'elle bouge pas)
			int mx = rand.nextInt(2);
			int my = rand.nextInt(2);
			//et une direction a cette force au hazard
			if(rand.nextBoolean())
				mx = -mx;
			if(rand.nextBoolean())
				my = -my;
			
			AgentParticule agent = new Particule(i.toString(),x, y,mx,my);
			environment.grille[x][y] = agent;
			agents.add(agent);
		}
	}
	
	public void runOnce(){
		Collections.shuffle(agents);
		
		for(AgentAbs agent : agents){
			//allez les mec faites qq chose!
			environment = agent.run(environment);
		}
		
		vue.grille();
	}
	
	public void run (int n) throws InterruptedException{
		for(int i = 0; i<n;i++){
			runOnce();
			Thread.sleep(environment.wait_time);
		}
	}
}
