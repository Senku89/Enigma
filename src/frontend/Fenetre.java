package frontend;

import javax.swing.*;

import java.util.ArrayList;

public class Fenetre extends JFrame{

	// menu principal
	JLayeredPane panelActif;
	
	// image de fond 
	JLabel bgImage;

	public Fenetre(){
		super("CryptoGame");
		try{
			// System.out.println("fenetre");
			this.setLocation(340, 240);
			this.setSize(1000, 600);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			/*this.putMenuPrincipal(menuprincipal);*/

			this.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setPanelActif(JLayeredPane panel){

		panelActif = panel;

		this.repaintFenetre();
	}

	public void repaintFenetre(){
		this.add(panelActif);
		this.setContentPane(panelActif);
		this.repaint(0, 0, 0, 1000, 600);
		// System.out.println("repaintFenetre");
	}
}