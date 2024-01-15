package frontend;

import javax.swing.*;

import java.util.ArrayList;

public class Fenetre extends JFrame{

	// Panel actif sur la fenêtre
	JLayeredPane panel;
	
	// image de fond 
	JLabel bgImage;

	public Fenetre(){
		super("CryptoGame");
		try{
			this.setLocation(340, 240);
			this.setSize(1000, 600);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			this.setVisible(true);

			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public JLayeredPane getPanel(){
		return this.panel;
	}

	public void setPanel(JLayeredPane panel){
		this.panel = panel;
		this.add(panel);
		this.setContentPane(panel);
		this.repaintFenetre();
	}

	public void repaintFenetre(){		
		this.repaint(0, 0, 1000, 600);
	}
}