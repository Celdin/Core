package abs;

import impl.Wator.AgentSwatorAbs;
import impl.Wator.EnvironmentWator;

import java.util.ArrayList;

public abstract class SMAAbs {
	protected EnvironnementAbs environment;
	protected static ArrayList<? extends AgentAbs> agents;
	
	public SMAAbs(EnvironnementAbs environment, ArrayList<? extends AgentAbs> agents) {
		super();
		this.environment = environment;
		this.agents = agents;
	}
	public static int size(){
		 return agents.size();
	}
	public abstract void addAgent();
	public abstract void runOnce()throws InterruptedException;
}
