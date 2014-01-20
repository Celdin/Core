
import impl.part.AgentParticule;
import impl.part.EnvironmentParticule;
import impl.part.SMAParticule;

import java.util.ArrayList;




public class Main {

	public static void main(String[] args) throws InterruptedException {
		SMAParticule sma = new SMAParticule(new EnvironmentParticule(3, 5, -1, -1, 500),new ArrayList<AgentParticule>());
		sma.addAgent();
		sma.run(2000);
	}

}
