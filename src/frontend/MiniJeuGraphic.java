package frontend;

import general.Init;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class MiniJeuGraphic extends JLayeredPane{
	
	Fenetre fenetreRef;
	JLabel bgImage;
	JLabel iconeTimer;
	ZoneTexte zoneTimer; 
	Titre titre;
	Bouton boutonQuitter;
	ZoneTexte zoneScore;

	int espacement = 10;

	public MiniJeuGraphic(Fenetre fenetre){
		this.fenetreRef = fenetre;

		boutonQuitter = new Bouton("Quitter", 813, 500, 150, 40);
		boutonQuitter.setFont(new Font("Helvetica", Font.BOLD, 20));

		zoneScore = new ZoneTexte(" 0 / 100 points", 70, 500, 120, 20);
		zoneScore.setFont(new Font("Helvetica", Font.BOLD, 15));

		zoneTimer = new ZoneTexte("     0:00", 820, 30, 130, 35);
		zoneTimer.setFont(new Font("Helvetica", Font.BOLD, 30));

		iconeTimer = new JLabel(new ImageIcon(Init.iconetimer));
		iconeTimer.setBounds(825, 30, 35, 35);

		// System.out.println(timerIcone);
	}
}