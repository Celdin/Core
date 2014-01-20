package Vue.Swator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Created on Nov 23, 2005
 *
 */

/**
 * @author HackTrack
 *
 */
public class ImageOverLabel extends JFrame {

	public ImageOverLabel() {
		super("Démo d'image sur Label");
		initialize();
	}

	private void initialize() {
		Container c = getContentPane();
		JLabel label = new JLabel();
		label.setBackground(Color.BLUE);
		ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage("img\\requin019.gif"));
		label.setPreferredSize(new Dimension(10, 10));
		label.setIcon(image);
		c.add(label);
	}

	public static void main(String[] args) {
		ImageOverLabel demo = new ImageOverLabel();
		demo.pack();
		demo.setVisible(true);
	}
}

