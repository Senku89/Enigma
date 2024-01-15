package frontend;

import general.Init;
import general.MainController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class MenuPrincipalGraphic extends JLayeredPane{
	MainController mainController;
	Fenetre fenetre;
	Bouton boutonJouer, boutonQuitter;
	JLabel bgImage;
	JLabel title;
	JTextArea textIntro;

	public MenuPrincipalGraphic(MainController mainController, Fenetre fenetre){
		super();

		this.mainController = mainController;
		this.fenetre = fenetre;

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondmenuprincipal));
		bgImage.setBounds(0, 0, this.getWidth(), this.getHeight());

		this.add(bgImage, Integer.valueOf(0));

		title = new JLabel("Déchiffrez Enigma");
		title.setBounds(225, 60, 550, 100);
		title.setForeground(Color.white);
		title.setFont(new Font("Helvetica", Font.BOLD, 50));

		textIntro = new ZoneTexte(Init.texteIntro, 145, 240, 710, 175);
		textIntro.setFont(new Font("Helvetica", Font.PLAIN, 20));

		boutonJouer = new Bouton("Jouer", 250, 450, 150, 30);
		boutonJouer.addActionListener(e -> {
            // Methode lancer le jeu suivant
            mainController.startJeuQuiz();
        });

		boutonQuitter = new Bouton("Sortir", 600, 450, 150, 30);
		boutonQuitter.addActionListener(e -> {
            // Quitter le jeu
            fenetre.dispose();
        });

		this.add(title, Integer.valueOf(1));
		this.add(textIntro, Integer.valueOf(1));
		this.add(boutonJouer, Integer.valueOf(1));
		this.add(boutonQuitter, Integer.valueOf(1));
	}
}