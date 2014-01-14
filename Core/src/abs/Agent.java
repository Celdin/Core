package abs;

import impl.Environment;

public abstract class Agent {
	private int pos_x;
	private int pos_y;
	
	public Agent(int x,int y){
		pos_x=x;
		pos_y=y;
	}
	
	public abstract Environment run(Environment univert);
}
