package impl.part;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import abs.AgentAbs;
import abs.EnvironnementAbs;
import abs.SMAAbs;
import impl.part.*;


public class SMAParticule extends SMAAbs{

	
	public SMAParticule(EnvironmentParticule environment, ArrayList<AgentParticule> agents) {
		super(environment,agents);
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
			((ArrayList<AgentParticule>)agents).add(agent);
		}
	}
	
	public void runOnce(){
		Collections.shuffle(agents);
		
		for(AgentParticule agent : ((ArrayList<AgentParticule>)agents)){
			//allez les mec faites qq chose!
			environment = ((AgentParticule) agent).run((EnvironmentParticule) environment);
		}
		//ici on afiche car sans IG on vois rien...
		for (int y = 0; y < environment.taille_envi; y++) {
			System.out.print("|");
			for (int x = 0; x < environment.taille_envi; x++) {
				if(environment.grille[x][y]!=null){
					System.out.print(environment.grille[x][y].name + "|");
				}else
					System.out.print(" |");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void run (int n) throws InterruptedException{
		for(int i = 0; i<n;i++){
			runOnce();
			Thread.sleep(environment.wait_time);
		}
	}
}
