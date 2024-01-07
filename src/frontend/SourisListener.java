package frontend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JLayeredPane;

public class SourisListener extends MouseAdapter{

	JeuMdpGraphic panel;
	boolean mdpChoisi;

	public SourisListener(JeuMdpGraphic panel){
		this.panel = panel;
		this.mdpChoisi = false;
	}

	@Override
	public void mousePressed(MouseEvent e){
		mdpChoisi = panel.choisirMdp(e);
	}

	@Override
	public void mouseReleased(MouseEvent e){
		if(mdpChoisi){
			panel.deplacerMdp(e);
			mdpChoisi = false;
		}
	}



}