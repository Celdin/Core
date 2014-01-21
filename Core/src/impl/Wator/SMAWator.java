package impl.Wator;
import impl.Wator.AgentSwatorAbs.Type;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import abs.SMAAbs;
import Vue.Swator.Grille;


public class SMAWator  extends SMAAbs{

	
	private Grille vue;
	public SMAWator(EnvironmentWator env, ArrayList<AgentSwatorAbs> agents) {
		super(env, agents);
		
		vue = new Grille(env); 

	}
	
	public void addAgent(){
		Random rand = new Random();
		int x;
		int y;
		for(Integer i = 0;i < ((EnvironmentWator)environment).nb_agent_poisson;i++){
			do{
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
			}while(((EnvironmentWator)environment).grille[x][y] != null);
			Poisson agent = new Poisson(i.toString(),x, y);
			environment.grille[x][y] = agent;
			((ArrayList<AgentSwatorAbs>) agents).add((AgentSwatorAbs) environment.grille[x][y]);
		}
		for(Integer i = 0;i < ((EnvironmentWator)environment).nb_agent_requin;i++){
			do{
			x = rand.nextInt(environment.taille_envi);
			y = rand.nextInt(environment.taille_envi);
			}while(environment.grille[x][y] != null);
			Requin agent = new Requin(String.valueOf(agents.size()),x, y);
			environment.grille[x][y] = agent;
			((ArrayList<AgentSwatorAbs>) agents).add((AgentSwatorAbs) environment.grille[x][y]);
		}
	}
	
	public void runOnce() throws InterruptedException{
		Collections.shuffle(agents);

		for(AgentSwatorAbs agent : ((ArrayList<AgentSwatorAbs>) agents)){
			environment = (EnvironmentWator) agent.run((EnvironmentWator) environment);

		}
		vue.grille();

		Thread.sleep(environment.wait_time);
		agents = new ArrayList<AgentSwatorAbs>();
		for (int y = 0; y < environment.taille_envi; y++) {
			for (int x = 0; x < environment.taille_envi; x++) {
				if(environment.grille[x][y]!=null){
					((ArrayList<AgentSwatorAbs>) agents).add((AgentSwatorAbs) environment.grille[x][y]);
				}
			}
		}
	}
	
	public void run (int n) throws InterruptedException{
		File f = new File("Stats.csv");
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write("Requin;Poisson\n");
			for(int i = 0; i<n;i++){
				runOnce();
				int requin=0;
				int poisson=0;
				for(AgentSwatorAbs agent : ((ArrayList<AgentSwatorAbs>) agents)){
					if(agent.getType() == Type.REQUIN)
						requin++;
					else
						poisson++;
				}
				bw.write(requin + ";" + poisson + "\n");
				Thread.sleep(environment.wait_time);
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
