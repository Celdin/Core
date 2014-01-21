package Vue.Wator;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import abs.GrilleAbs;
import impl.Wator.AgentSwatorAbs;
import impl.Wator.EnvironmentWator;

public class Grille extends GrilleAbs {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8729021838428799085L;

	public Grille (EnvironmentWator env){
		super( env);
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 

		for(int i= 0 ; i < env.taille_envi;i++){
			for(int j= 0 ; j < env.taille_envi;j++){
			
				   agent[i][j].setBorder(blackline);
				  
			}

		}
		pan.setBorder(blackline);
		
	}
	
	public void grille(){
		ImageIcon requin = new ImageIcon(Toolkit.getDefaultToolkit().getImage("img\\requin019.gif"));
		ImageIcon poisson = new ImageIcon(Toolkit.getDefaultToolkit().getImage("img\\poisson.jpg"));
		
		for(int y = 0; y<env.taille_envi;y++){
			for(int x = 0; x<env.taille_envi;x++){
				agent[x][y].setBackground(Color.BLUE);
				  
			   if(env.grille[x][y]!=null){
				   if(((AgentSwatorAbs) env.grille[x][y]).getType() == impl.Wator.AgentSwatorAbs.Type.POISSON){
					   agent[x][y].setIcon(poisson);
					   
				   }
				   if(((AgentSwatorAbs) env.grille[x][y]).getType() == impl.Wator.AgentSwatorAbs.Type.REQUIN){
					   agent[x][y].setIcon(requin);
				   }
			   }
			   else{
				   agent[x][y].setIcon(null);
			   }
			}
		}
	}
}
