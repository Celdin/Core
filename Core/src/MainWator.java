import java.io.IOException;
import java.util.ArrayList;

import impl.Wator.AgentSwatorAbs;
import impl.Wator.EnvironmentWator;
import impl.Wator.SMAWator;


public class MainWator {

	public static void main(String[] args) throws InterruptedException, IOException {
		SMAWator sma = new SMAWator(new EnvironmentWator(200,2,5,10,3, 31, 30, 15, 10,true),new ArrayList<AgentSwatorAbs>());
		sma.addAgent();
		sma.run(9999);
	}

}
