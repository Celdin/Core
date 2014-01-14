package abs;

import impl.Univert;

public abstract class Agent {
	private int pos_x = -1;
	private int pos_y = -1;
	
	public Agent(int x,int y){
		pos_x=x;
		pos_y=y;
	}
	
	public abstract void run(Univert univert);
}
