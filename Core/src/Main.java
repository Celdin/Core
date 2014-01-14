import java.util.ArrayList;

import abs.Agent;
import impl.Environment;
import impl.SMA;


public class Main {

	public static void main(String[] args) {
		SMA sma = new SMA(new Environment(10, 10, -1, -1, 10),new ArrayList<Agent>());
		
	}

}
