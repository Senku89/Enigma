package frontend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;

public class SourisListener extends MouseAdapter{

	private JeuMdpGraphic panel;
	private JButton mdp;
	
	// Constructeur du listener sur le panel
	public SourisListener(JeuMdpGraphic panel){
		this.panel = panel;
		this.mdp = null;
	}

	// Constructeur du listener sur les mots de passe
	public SourisListener(JeuMdpGraphic panel, JButton mdp){
		this.panel = panel;
		this.mdp = mdp;
	}

	@Override
	public void mousePressed(MouseEvent e){
		if(mdp != null){
			panel.selectionMdp(mdp);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e){
			panel.deplacerMdp(e.getX(), e.getY());
	}
}