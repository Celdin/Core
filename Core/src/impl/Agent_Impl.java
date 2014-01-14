package impl;

import abs.Agent;

public class Agent_Impl extends Agent{

	public Agent_Impl(int x, int y) {
		super(x, y);
	}

	@Override
	public Environment run(Environment univert) {
		System.out.println("Bonjour !");
		return univert;
	}
	
}
