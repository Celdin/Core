package Vue.Segregation;

import impl.segregation.Bonhomme;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import abs.EnvironnementAbs;
import abs.GrilleAbs;

public class Grille extends GrilleAbs {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8729021838428799085L;

	public Grille (EnvironnementAbs env){
		super(env);
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 

		for(int i= 0 ; i < env.taille_envi;i++){
			for(int j= 0 ; j < env.taille_envi;j++){
			
				   agent[i][j].setBorder(blackline);
				  
			}

		}
		pan.setBorder(blackline);
		
	}
	
	public void grille(){
		
		
		
		for(int y = 0; y<env.taille_envi;y++){
			for(int x = 0; x<env.taille_envi;x++){
				  
			   if(env.grille[x][y]!=null){
				   Graphics g = agent[x][y].getGraphics();
				   if(((Bonhomme)env.grille[x][y]).type)
					   g.setColor(Color.RED);
				   else
					   g.setColor(Color.GREEN);
				   g.fillOval(0, 0, agent[x][y].getHeight(), agent[x][y].getWidth());
				   agent[x][y].paint(g);
				   
			   }
			   else{
				   Graphics g = agent[x][y].getGraphics();
				   g.setColor(Color.WHITE);
				   g.fillRect(0, 0, agent[x][y].getHeight(), agent[x][y].getWidth());
				   agent[x][y].paint(g);
			   }
			}
		}
	}
}
