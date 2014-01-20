package impl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Vue.Grille;
import abs.Agent;
import abs.Agent.Type;


public class SMA {

	private Environment environment;
	public static ArrayList<Agent> agents;
	private Grille vue;
	public SMA(Environment environment, ArrayList<Agent> agents) {
		super();
		this.environment = environment;
		SMA.agents = agents;
		vue = new Grille(environment); 

	}
	
	public void addAgent(){
		Random rand = new Random();
		int x;
		int y;
		for(Integer i = 0;i < environment.nb_agent_poisson;i++){
			do{
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
			}while(environment.grille[x][y] != null);
			Poisson agent = new Poisson(i.toString(),x, y);
			environment.grille[x][y] = agent;
			agents.add(environment.grille[x][y]);
		}
		for(Integer i = 0;i < environment.nb_agent_requin;i++){
			do{
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
			}while(environment.grille[x][y] != null);
			Requin agent = new Requin(String.valueOf(agents.size()),x, y);
			environment.grille[x][y] = agent;
			agents.add(environment.grille[x][y]);
		}
	}
	
	public void runOnce() throws InterruptedException{
		Collections.shuffle(agents);

		for(Agent agent : agents){
			environment = agent.run(environment);

		}
		vue.grille();

		Thread.sleep(environment.wait_time);
		agents = new ArrayList<Agent>();
		for (int y = 0; y < environment.taille_envi; y++) {
			for (int x = 0; x < environment.taille_envi; x++) {
				if(environment.grille[x][y]!=null){
					agents.add(environment.grille[x][y]);
				}
			}
		}
	}
	
	public void run (int n) throws InterruptedException, IOException{
		File f = new File("Stats.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write("Requin;Poisson\n");
		for(int i = 0; i<n;i++){
			runOnce();
			int requin=0;
			int poisson=0;
			for(Agent agent : agents){
				if(agent.getType() == Type.REQUIN)
					requin++;
				else
					poisson++;
			}
			bw.write(requin + ";" + poisson + "\n");
			System.out.println("Requin: " + requin + " Poisson: " + poisson );
			System.out.println();
			Thread.sleep(environment.wait_time);
		}
		bw.close();
	}
}
