package Vue;

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

import abs.Agent.Type;
import impl.Environment;

public class Grille extends JFrame {
	Environment env;
	JLabel[][] agent;
	JPanel pan;
	public Grille (Environment env){
		this.env = env;
		pan = new JPanel();
		pan.setLayout(new GridLayout (env.taille_envi,env.taille_envi));
		this.setPreferredSize(new Dimension(env.taille_case*env.taille_envi, env.taille_case*env.taille_envi));
		this.setLocationRelativeTo(null);
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 

		this.setLocation(100, 100);
		agent = new JLabel [env.taille_envi][env.taille_envi];
		for(int i= 0 ; i < env.taille_envi;i++){
			for(int j= 0 ; j < env.taille_envi;j++){
				agent[i][j]= new JLabel();
				agent[i][j].setPreferredSize(new Dimension(env.taille_case,env.taille_case));
				   agent[i][j].setBorder(blackline);
				   agent[i][j].setVisible(true);
				   
				   pan.add(agent[i][j]);
			}

		}
		pan.setBorder(blackline);
		this.add(pan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public void grille(){
		ImageIcon requin = new ImageIcon(Toolkit.getDefaultToolkit().getImage("img\\requin019.gif"));
		ImageIcon poisson = new ImageIcon(Toolkit.getDefaultToolkit().getImage("img\\poisson.jpg"));
		
		for(int y = 0; y<env.taille_envi;y++){
			for(int x = 0; x<env.taille_envi;x++){
				agent[x][y].setBackground(Color.BLUE);;
				  
			   if(env.grille[x][y]!=null){
				   if(env.grille[x][y].getType() == abs.Agent.Type.POISSON){
					   agent[x][y].setIcon(poisson);
					   
				   }
				   if(env.grille[x][y].getType() == abs.Agent.Type.REQUIN){
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
