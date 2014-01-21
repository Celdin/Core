package abs;

import java.util.ArrayList;

public abstract class SMAAbs {
	protected EnvironnementAbs environment;
	protected static ArrayList<? extends AgentAbs> agents;
	
	public SMAAbs(EnvironnementAbs environment, ArrayList<? extends AgentAbs> agents) {
		super();
		this.environment = environment;
		SMAAbs.agents = agents;
	}
	public static int size(){
		 return agents.size();
	}
	public abstract void addAgent();
	public abstract void run(int n) throws InterruptedException;
	public abstract void runOnce()throws InterruptedException;
}
