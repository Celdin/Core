package impl.Wator;

import java.awt.Point;
import java.util.Random;

import abs.AgentAbs;

public abstract class AgentSwatorAbs extends AgentAbs {

	public enum Type {REQUIN,POISSON,VIDE};
	protected Type type;
	protected int cycleReproduction;
	public boolean vivant = true;
	
	public AgentSwatorAbs(String nom,Type type, int x,int y){
		super(nom,x,y);
		this.name = nom;
		this.type = type;
		pos_x=x;
		pos_y=y;
		cycleReproduction = -1;
	}
	public Type getType(){
		return type;
	}
	
	public Point getPoint(){
		return new Point(pos_x, pos_y);
	}
	
	
	@Override
	public String toString() {
		return name + ":["+pos_x+","+pos_y+"]";
	}

	protected boolean placeLibre(EnvironmentWator environment){
		for (int y = 0; y < environment.taille_envi; y++) {
			for (int x = 0; x < environment.taille_envi; x++) {
				if(environment.grille[x][y] == null)
					return true;
			}
			
		}
		return false;
	}
	
	protected EnvironmentWator move(EnvironmentWator univert) {
		Random rand = new Random();
		int choix;
		while (true && univert.voisins(pos_x, pos_y).contains(null)){
			choix = rand.nextInt(8);
			if(univert.torique){
				switch (choix) {
				case 0:
					if(univert.grille[(pos_x+univert.taille_envi-1)%univert.taille_envi][(pos_y+1)%univert.taille_envi] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_x = (pos_x+univert.taille_envi-1)%univert.taille_envi;
						pos_y = (pos_y+1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 1:
					if(univert.grille[pos_x][(pos_y+1)%univert.taille_envi] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_y = (pos_y+1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 2:
					if(univert.grille[(pos_x+1)%univert.taille_envi][(pos_y+1)%univert.taille_envi] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_x = (pos_x+1)%univert.taille_envi;
						pos_y = (pos_y+1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 3:
					if(univert.grille[(pos_x+univert.taille_envi-1)%univert.taille_envi][pos_y] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_x = (pos_x+univert.taille_envi-1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 4:
					if(univert.grille[(pos_x+1)%univert.taille_envi][pos_y] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_x = (pos_x+1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 5:
					if(univert.grille[(pos_x+univert.taille_envi-1)%univert.taille_envi][(pos_y+univert.taille_envi-1)%univert.taille_envi] == null){
						
						univert.grille[pos_x][pos_y] = null;
						pos_x = (pos_x+univert.taille_envi-1)%univert.taille_envi;
						pos_y = (pos_y+univert.taille_envi-1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 6:
					if(univert.grille[pos_x][(pos_y+univert.taille_envi-1)%univert.taille_envi] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_y = (pos_y+univert.taille_envi-1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;
				case 7:
					if(univert.grille[(pos_x+1)%univert.taille_envi][(pos_y+univert.taille_envi-1)%univert.taille_envi] == null){
						univert.grille[pos_x][pos_y] = null;
						pos_x = (pos_x+1)%univert.taille_envi;
						pos_y = (pos_y+univert.taille_envi-1)%univert.taille_envi;
						univert.grille[pos_x][pos_y] = this;
						
						return univert;
					}
					break;

				default:
					break;
				}
			}else{
				switch (choix) {
				case 0:
					if(pos_x!=0 && pos_y != univert.taille_envi-1)
						if(univert.grille[pos_x-1][pos_y+1] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_x = pos_x-1;
							pos_y = pos_y+1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 1:
					if(pos_y != univert.taille_envi-1)
						if(univert.grille[pos_x][pos_y+1] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_y = pos_y+1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 2:
					if(pos_x!= univert.taille_envi-1 && pos_y != univert.taille_envi-1)
						if(univert.grille[pos_x+1][pos_y+1] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_x = pos_x+1;
							pos_y = pos_y+1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 3:
					if(pos_x!=0)
						if(univert.grille[pos_x-1][pos_y] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_x = pos_x-1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 4:
					if(pos_x!= univert.taille_envi-1)
						if(univert.grille[pos_x+1][pos_y] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_x = pos_x+1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 5:
					if(pos_x!=0 && pos_y != 0)
						if(univert.grille[pos_x-1][pos_y-1] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_x = pos_x-1;
							pos_y = pos_y-1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 6:
					if(pos_y != 0)
						if(univert.grille[pos_x][pos_y-1] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_y = pos_y-1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;
				case 7:
					if( pos_x!= univert.taille_envi-1 && pos_y != 0)
						if(univert.grille[pos_x+1][pos_y-1] == null){
							univert.grille[pos_x][pos_y] = null;
							pos_x = pos_x+1;
							pos_y = pos_y-1;
							univert.grille[pos_x][pos_y] = this;
							
							return univert;
						}
					break;

				default:
					break;
				}
			}
		}
		return univert;
	}
	public void estManger() {
		vivant  = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		AgentSwatorAbs agent = (AgentSwatorAbs)obj;
		
		return this.name.equals(agent.name);
		
	}
	
	public abstract EnvironmentWator run(EnvironmentWator univert);
}
