
import impl.Wator.AgentSwatorAbs;
import impl.Wator.EnvironmentWator;
import impl.Wator.SMAWator;
import impl.part.AgentParticule;
import impl.part.EnvironmentParticule;
import impl.part.SMAParticule;
import impl.segregation.AgentHurbain;
import impl.segregation.EnvironmentSegregation;
import impl.segregation.SMASegregation;

import java.util.ArrayList;
import java.util.Scanner;

import abs.EnvironnementAbs;
import abs.SMAAbs;




public class Main {

	public static void main(String[] args) throws InterruptedException { 
		Scanner scan = new Scanner(System.in);
		String[] line = args;
		while(line.length <= 0 || !(line[0].equals("WaTor") && line.length >= 10) && !(line[0].equals("Particule") && line.length >= 6) && !(line[0].equals("Segregation") && line.length >= 7)){
		System.out.println("Usage :");
		System.out.println("WaTor <nb_agent_poisson> "
				+ "<tempsReproductionPoisson> "
				+ "<nb_agent_requin> "
				+ "<tempsReproductionRequin> "
				+ "<maxTempsRequinSansManger> "
				+ "<taille grille(nb case)> "
				+ "<taille_case(pixel)> "
				+ "<taille_vus(pixel)> "
				+ "<wait_time> "
				+ "[torique(true or false)]");
		System.out.println("Particule <nb_agent> "
				+ "<taille_grille(nb case)> "
				+ "<taille_case(pixel)> "
				+ "<taille_vus(pixel)> "
				+ "<wait_time> "
				+ "[torique(true or false)]");
		System.out.println("Segregation <nb_agent> "
				+ "<taux_satisfaction>"
				+ "<taille_grille(nb case)> "
				+ "<taille_case(pixel)> "
				+ "<taille_vus(pixel)> "
				+ "<wait_time> "
				+ "[torique(true or false)]");
		line = scan.nextLine().split(" ");
		}
		scan.close();
		SMAAbs sma = null;
		if(line[0].equals("Particule")){
			if(line.length == 6)
			sma = new SMAParticule(new EnvironmentParticule(Integer.parseInt(line[1]),Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5])),new ArrayList<AgentParticule>());
			else
			sma = new SMAParticule(new EnvironmentParticule(Integer.parseInt(line[1]),Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]),Boolean.parseBoolean(line[6])),new ArrayList<AgentParticule>());
		}else if(line[0].equals("WaTor")){
			if(line.length == 10)
			sma = new SMAWator(new EnvironmentWator(Integer.parseInt(line[1]),Integer.parseInt(line[2]),Integer.parseInt(line[3]),Integer.parseInt(line[4]),Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), Integer.parseInt(line[8]), Integer.parseInt(line[9])),new ArrayList<AgentSwatorAbs>());
			else
			sma = new SMAWator(new EnvironmentWator(Integer.parseInt(line[1]),Integer.parseInt(line[2]),Integer.parseInt(line[3]),Integer.parseInt(line[4]),Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), Integer.parseInt(line[8]), Integer.parseInt(line[9]),Boolean.parseBoolean(line[10])),new ArrayList<AgentSwatorAbs>());
		}else
			sma = new SMASegregation( ((EnvironnementAbs)new EnvironmentSegregation(600,80, 31, 20, 200, 10)), new ArrayList<AgentHurbain>());
		sma.addAgent();
		System.out.println("Start");
		sma.run(2000);
		System.out.println("Done");
	}

}
