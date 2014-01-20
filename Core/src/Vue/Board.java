package Vue;

import impl.Environment;
import abs.Agent.Type;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Board extends JPanel {
	Environment env;
	public Board (Environment env){
		this.env = env;
	}
	  public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  System.out.println("je demarre!!!!");
		  	this.removeAll();
		  	this.setLayout(new GridLayout (env.taille_envi,env.taille_envi));
			Border blackline = BorderFactory.createLineBorder(Color.black,1); 
			for(int i = 0; i<env.taille_envi*env.taille_envi;i++){
				   //ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Thomas\\git\\Core\\Core\\img\\requin019.gif"));
				   JLabel img = new JLabel();
				   System.out.println("Largeur: "+ i/env.taille_envi + " Longueur :" + i%env.taille_envi);
				   if(env.grille[i/env.taille_envi][i%env.taille_envi]!= null){
					   if(env.grille[i/env.taille_envi][i%env.taille_envi].getType() == Type.POISSON){
						   img.setText("P");
					   }
					   if(env.grille[i/env.taille_envi][i%env.taille_envi].getType() == Type.REQUIN){
						   img.setText("R");
					   }
				   }
					   //img.setBounds(0, 0, image.getIconHeight(), image.getIconWidth());
	               img.setPreferredSize(new Dimension(env.taille_case,env.taille_case));
				   img.setBorder(blackline);
				   img.setVisible(true);
				   this.add(img);
				}
			this.setBorder(blackline);
	  }
}
