package impl.segregation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Vue.Segregation.Grille;
import abs.AgentAbs;
import abs.SMAAbs;

public class SMASegregation extends SMAAbs {

	private Grille vue;
	public SMASegregation(EnvironnementSegregation environment,List<AgentAbs> agents) {
		super(environment, agents);

		vue = new Grille(environment);
	}

	@Override
	public void addAgent() {
		Random rand = new Random();
		for(Integer i = 0;i<((EnvironnementSegregation)environment).nb_agent;i++){
			int x,y;
			do{
				x = rand.nextInt(environment.taille_envi);
				y = rand.nextInt(environment.taille_envi);
				}while(environment.grille[x][y] != null);
			AgentHurbain agent = new Bonhomme(i.toString(), ((EnvironnementSegregation)environment).seuil_confort, x, y);
			environment.grille[x][y]=agent;
			agents.add(agent);
		}
	}

	public void run() throws InterruptedException {
		int n = 0;
		while(n==agents.size()){
			for(AgentAbs agent : agents){
				if(((Bonhomme) agent).estContent((EnvironnementSegregation) environment));
					n++;
			}
			runOnce();
			Thread.sleep(environment.wait_time);
		}

	}

	@Override
	public void run(int n) throws InterruptedException {
		n=0;
		float tauxsegreg = 0;
		int i =0;
		File f = new File("Stats.csv");
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write("temps;Pourcentage d'agent content;taux de segregation\n");
			while(n!=agents.size()){
				n = 0;
				for(AgentAbs agent : agents){
					if(((Bonhomme) agent).estContent((EnvironnementSegregation) environment))
						n++;
					List<AgentHurbain> b = ((EnvironnementSegregation)environment).voisins(agent.pos_x, agent.pos_y);
					int v=0;
					for(AgentHurbain a : b){
						if(a != null && a.type == ((AgentHurbain)agent).type)
							v++;
					}
					tauxsegreg += (float)v/(float)b.size()*100;
				}
				tauxsegreg /= (float)agents.size();
				bw.write((String)(i+ ";"+ (float)n/(float)agents.size()*100 + ";"  + tauxsegreg + "\n").replace('.', ','));
				runOnce();
				Thread.sleep(environment.wait_time);
				i++;
			}
			bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void runOnce() throws InterruptedException {
		Collections.shuffle(agents);
		
		for(AgentAbs agent : agents){
			//allez les mec faites qq chose!
			environment = ((AgentHurbain)agent).run((EnvironnementSegregation) environment);
		}
		vue.grille();
		
	}

}
