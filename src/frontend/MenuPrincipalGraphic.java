package frontend;

import general.Init;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class MenuPrincipalGraphic extends JLayeredPane{
	
	Fenetre fenetreRef;
	Bouton boutonJouer, boutonQuitter;
	JLabel bgImage;
	JLabel title;
	JTextArea textIntro;

	public MenuPrincipalGraphic(Fenetre fenetre){
		super();
		// System.out.println("mpg graphic");

		this.fenetreRef = fenetre;

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetreRef.getWidth(), fenetreRef.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondmenuprincipal));
		bgImage.setBounds(0, 0, this.getWidth(), this.getHeight());

		this.add(bgImage, new Integer(0));

		title = new JLabel("Déchiffrez Enigma");
		title.setBounds(225, 60, 550, 100);
		title.setForeground(Color.white);
		title.setFont(new Font("Helvetica", Font.BOLD, 50));

		textIntro = new ZoneTexte(Init.texteIntro, 145, 240, 710, 175);
		textIntro.setFont(new Font("Helvetica", Font.PLAIN, 20));

		boutonJouer = new Bouton("Jouer", 250, 450, 150, 30);
		boutonQuitter = new Bouton("Sortir", 600, 450, 150, 30);

		this.add(title, new Integer(1));
		this.add(textIntro, new Integer(1));
		this.add(boutonJouer, new Integer(1));
		this.add(boutonQuitter, new Integer(1));
	}
}