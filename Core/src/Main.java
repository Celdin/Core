import java.io.IOException;
import java.util.ArrayList;

import abs.Agent;
import impl.Environment;
import impl.SMA;


public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		SMA sma = new SMA(new Environment(200,2,5,10,3, 31, 10, 2, 10,true),new ArrayList<Agent>());
		sma.addAgent();
		sma.run(9999);
	}

}
