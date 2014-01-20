package Vue.Swator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import abs.GrilleAbs;
import impl.Wator.AgentSwatorAbs;
import impl.Wator.EnvironmentWator;
import impl.Wator.AgentSwatorAbs.Type;

public class Grille extends GrilleAbs {
	
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
				agent[x][y].setBackground(Color.BLUE);;
				  
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
			   
				   //img.setBounds(0, 0, image.getIconHeight(), image.getIconWidth());
			   
			}
		}
		
	}

}
