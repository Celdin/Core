package abs;

import impl.Wator.EnvironmentWator;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GrilleAbs extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8313521493650105158L;
	protected EnvironnementAbs env;
	protected JLabel[][] agent;
	protected JPanel pan;
	public GrilleAbs (EnvironnementAbs env){
		this.env = env;
		pan = new JPanel();
		pan.setLayout(new GridLayout (env.taille_envi,env.taille_envi));
		this.setPreferredSize(new Dimension(env.taille_case*env.taille_envi, env.taille_case*env.taille_envi));
		this.setLocationRelativeTo(null);

		this.setLocation(100, 100);
		agent = new JLabel [env.taille_envi][env.taille_envi];
		for(int i= 0 ; i < env.taille_envi;i++){
			for(int j= 0 ; j < env.taille_envi;j++){
				agent[i][j]= new JLabel();
				agent[i][j].setPreferredSize(new Dimension(env.taille_case,env.taille_case));
				   agent[i][j].setVisible(true);
				   
				   pan.add(agent[i][j]);
			}

		}
		this.add(pan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public abstract void grille();
	

}