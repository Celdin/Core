package abs;


public abstract class AgentAbs {
	public String name;
	
	protected Integer pos_x;
	protected Integer pos_y;
	
	public AgentAbs(String nom,int x,int y){
		this.name = nom;
		pos_x=x;
		pos_y=y;
	}
	
	
}
