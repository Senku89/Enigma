package frontend;

import general.Init;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class ResultatsFinauxGraphic extends JLayeredPane{
	
	Fenetre fenetre;
	JLabel bgImage;
	JTextArea intituleQuiz, intituleMdp, intituleDechiffrement, intituleFinal;
	JTextArea scoreQuiz, scoreMdp, scoreDechiffrement, resultatFinal;
	Bouton boutonMenu;
	Titre titre;
	ZoneTexte zoneCentrale;

	int intituleHeight = 22, scoreWidth = 55, scoreHeight = 15;
	int paddingHeight = 20, spacingHeight = 30;

	Color intituleForeground = Color.BLACK, intituleBackground = new Color(0, 0, 0, 0);
	Color scoreForeground = Color.BLACK, scoreBackground = Init.couleurfondzonetext;

	Font intituleFont = new Font("Helvetica", Font.BOLD, 20), scoreFont = new Font("Helvetica", Font.BOLD, 15);

	public ResultatsFinauxGraphic(Fenetre fenetre){
		super();
		// System.out.println("rfg");

		this.fenetre = fenetre;

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondmenuprincipal));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());
		this.add(bgImage, new Integer(0));

		titre = new Titre("5. Résultats Finaux");
		this.add(titre, new Integer(1));

		zoneCentrale = new ZoneTexte("", 200, 100, 600, 350);
		this.add(zoneCentrale, new Integer(1));

		int intituleQuizWidth = 80;
		intituleQuiz = new JTextArea("1. Quiz");
		intituleQuiz.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleQuizWidth/2, zoneCentrale.getY()+paddingHeight, intituleQuizWidth, intituleHeight);
		intituleQuiz.setForeground(intituleForeground);
		intituleQuiz.setBackground(intituleBackground);
		intituleQuiz.setFont(intituleFont);
		this.add(intituleQuiz, new Integer(2));

		scoreQuiz = new JTextArea(" 0/100");
		scoreQuiz.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-scoreWidth/2, intituleQuiz.getY()+intituleQuiz.getHeight()+paddingHeight, scoreWidth, scoreHeight);
		scoreQuiz.setForeground(scoreForeground);
		scoreQuiz.setBackground(scoreBackground);
		scoreQuiz.setFont(scoreFont);
		this.add(scoreQuiz, new Integer(2));

		int intituleMdpWidth = 200;
		intituleMdp = new JTextArea("2. Mots de passe");
		intituleMdp.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleMdpWidth/2, scoreQuiz.getY()+scoreQuiz.getHeight()+paddingHeight, intituleMdpWidth, intituleHeight);
		intituleMdp.setForeground(intituleForeground);
		intituleMdp.setBackground(intituleBackground);
		intituleMdp.setFont(intituleFont);
		this.add(intituleMdp, new Integer(2));

		scoreMdp = new JTextArea(" 0/100");
		scoreMdp.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-scoreWidth/2, intituleMdp.getY()+intituleMdp.getHeight()+paddingHeight, scoreWidth, scoreHeight);
		scoreMdp.setForeground(scoreForeground);
		scoreMdp.setBackground(scoreBackground);
		scoreMdp.setFont(scoreFont);
		this.add(scoreMdp, new Integer(2));

		int intituleDechiffrementWidth = 200;
		intituleDechiffrement = new JTextArea("3. Dechiffrement");
		intituleDechiffrement.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleDechiffrementWidth/2, scoreMdp.getY()+scoreMdp.getHeight()+paddingHeight, intituleDechiffrementWidth, intituleHeight);
		intituleDechiffrement.setForeground(intituleForeground);
		intituleDechiffrement.setBackground(intituleBackground);
		intituleDechiffrement.setFont(intituleFont);
		this.add(intituleDechiffrement, new Integer(2));

		scoreDechiffrement = new JTextArea(" 0/100");
		scoreDechiffrement.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-scoreWidth/2, intituleDechiffrement.getY()+intituleDechiffrement.getHeight()+paddingHeight, scoreWidth, scoreHeight);
		scoreDechiffrement.setForeground(scoreForeground);
		scoreDechiffrement.setBackground(scoreBackground);
		scoreDechiffrement.setFont(scoreFont);
		this.add(scoreDechiffrement, new Integer(2));
	
		int intituleFinalWidth = 100;
		intituleFinal = new JTextArea("4. Final");
		intituleFinal.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleFinalWidth/2, scoreDechiffrement.getY()+scoreDechiffrement.getHeight()+paddingHeight, intituleFinalWidth, intituleHeight);
		intituleFinal.setForeground(intituleForeground);
		intituleFinal.setBackground(intituleBackground);
		intituleFinal.setFont(intituleFont);
		this.add(intituleFinal, new Integer(2));

		resultatFinal = new JTextArea(" Trouvé");
		resultatFinal.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-30, intituleFinal.getY()+intituleFinal.getHeight()+paddingHeight, 60, scoreHeight);
		resultatFinal.setForeground(scoreForeground);
		resultatFinal.setBackground(scoreBackground);
		resultatFinal.setFont(scoreFont);
		this.add(resultatFinal, new Integer(2));

		int boutonMenuWidth = 300;
		boutonMenu = new Bouton("Menu Principal", zoneCentrale.getX()+zoneCentrale.getWidth()/2-boutonMenuWidth/2, zoneCentrale.getY()+zoneCentrale.getHeight()+spacingHeight, boutonMenuWidth, 40);
		boutonMenu.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.add(boutonMenu, new Integer(1));
	}
}