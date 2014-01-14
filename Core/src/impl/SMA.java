package impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import abs.Agent;


public class SMA {

	private Environment environment;
	public ArrayList<Agent> agents;
	
	public SMA(Environment environment, ArrayList<Agent> agents) {
		super();
		this.environment = environment;
		this.agents = agents;
	}
	
	public void addAgent(){
		Random rand = new Random();
		int x;
		int y;
		for(int i = 0;i < environment.nb_agent;i++){
			do{
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
			}while(environment.grille[x][y] != null);
			Agent_Impl agent = new Agent_Impl(x, y);
			environment.grille[x][y] = agent;
			agents.add(agent);
		}
	}
	
	public void runOnce(){
		Collections.shuffle(agents);
		
		for(Agent agent : agents){
			environment = agent.run(environment);
		}
	}
	
	public void run (int n) throws InterruptedException{
		for(int i = 0; i<n;i++){
			runOnce();
			wait(environment.wait_time);
		}
	}
}
