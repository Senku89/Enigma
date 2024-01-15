package frontend;

import general.Init;
import general.MainController;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class ResultatsFinauxGraphic extends JLayeredPane{
	MainController mainController;
	Fenetre fenetre;
	JLabel bgImage;
	JTextArea intituleQuiz, intituleMdp, intituleDechiffrement, intituleFinal;
	JTextArea scoreQuiz, scoreMdp, scoreDechiffrement, resultatFinal;
	Bouton boutonMenu;
	Titre titre;
	ZoneTexte zoneCentrale;

	int intituleHeight = 22, scoreWidth = 100, scoreHeight = 15;
	int paddingHeight = 20, spacingHeight = 30;

	Color intituleForeground = Color.BLACK, intituleBackground = new Color(0, 0, 0, 0);
	Color scoreForeground = Color.BLACK, scoreBackground = Init.couleurfondzonetext;

	Font intituleFont = new Font("Helvetica", Font.BOLD, 20), scoreFont = new Font("Helvetica", Font.BOLD, 15);

	public ResultatsFinauxGraphic(MainController mainController, Fenetre fenetre, int scorequiz, int scoremdp, int scoredecrypt, boolean motFinalFound){
		super();

		this.mainController = mainController;
		this.fenetre = fenetre;

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondmenuprincipal));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());
		this.add(bgImage, Integer.valueOf(0));

		titre = new Titre("5. Résultats Finaux");
		this.add(titre, Integer.valueOf(1));

		zoneCentrale = new ZoneTexte("", 200, 100, 600, 350);
		this.add(zoneCentrale, Integer.valueOf(1));

		
		int scoreQuizWidth;

		if(scorequiz == 100){
			scoreQuizWidth = 65;
		} else {
			if(scorequiz > 9){
				scoreQuizWidth = 55;
			} else {
				scoreQuizWidth = 45;
			}
		}

		int intituleQuizWidth = 80;
		intituleQuiz = new JTextArea("1. Quiz");
		intituleQuiz.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleQuizWidth/2, zoneCentrale.getY()+paddingHeight, intituleQuizWidth, intituleHeight);
		intituleQuiz.setForeground(intituleForeground);
		intituleQuiz.setBackground(intituleBackground);
		intituleQuiz.setFont(intituleFont);
		intituleQuiz.setEditable(false);
		this.add(intituleQuiz, Integer.valueOf(2));

		scoreQuiz = new JTextArea(scorequiz+"/100");
		scoreQuiz.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-scoreQuizWidth/2, intituleQuiz.getY()+intituleQuiz.getHeight()+paddingHeight, scoreQuizWidth, scoreHeight);
		scoreQuiz.setForeground(scoreForeground);
		scoreQuiz.setBackground(scoreBackground);
		scoreQuiz.setFont(scoreFont);
		scoreQuiz.setEditable(false);
		this.add(scoreQuiz, Integer.valueOf(2));

		int intituleMdpWidth = 200;
		int scoreMdpWidth;
		if(scoremdp == 100){
			scoreMdpWidth = 65;
		} else {
			if(scoremdp > 9){
				scoreMdpWidth = 55;
			} else {
				scoreMdpWidth = 45;
			}
		}

		intituleMdp = new JTextArea("2. Mots de passe");
		intituleMdp.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleMdpWidth/2, scoreQuiz.getY()+scoreQuiz.getHeight()+paddingHeight, intituleMdpWidth, intituleHeight);
		intituleMdp.setForeground(intituleForeground);
		intituleMdp.setBackground(intituleBackground);
		intituleMdp.setFont(intituleFont);
		intituleMdp.setEditable(false);
		this.add(intituleMdp, Integer.valueOf(2));

		scoreMdp = new JTextArea(scoremdp+"/100");
		scoreMdp.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-scoreMdpWidth/2, intituleMdp.getY()+intituleMdp.getHeight()+paddingHeight, scoreMdpWidth, scoreHeight);
		scoreMdp.setForeground(scoreForeground);
		scoreMdp.setBackground(scoreBackground);
		scoreMdp.setFont(scoreFont);
		scoreMdp.setEditable(false);
		this.add(scoreMdp, Integer.valueOf(2));

		int intituleDechiffrementWidth = 200;
		int scoreDecryptWidth;
		if(scoredecrypt == 100){
			scoreDecryptWidth = 65;
		} else {
			if(scoredecrypt > 9){
				scoreDecryptWidth = 55;
			} else {
				scoreDecryptWidth = 45;
			}
		}
		intituleDechiffrement = new JTextArea("3. Dechiffrement");
		intituleDechiffrement.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleDechiffrementWidth/2, scoreMdp.getY()+scoreMdp.getHeight()+paddingHeight, intituleDechiffrementWidth, intituleHeight);
		intituleDechiffrement.setForeground(intituleForeground);
		intituleDechiffrement.setBackground(intituleBackground);
		intituleDechiffrement.setFont(intituleFont);
		intituleDechiffrement.setEditable(false);
		this.add(intituleDechiffrement, Integer.valueOf(2));

		scoreDechiffrement = new JTextArea(scoredecrypt+"/100");
		scoreDechiffrement.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-scoreDecryptWidth/2, intituleDechiffrement.getY()+intituleDechiffrement.getHeight()+paddingHeight, scoreDecryptWidth, scoreHeight);
		scoreDechiffrement.setForeground(scoreForeground);
		scoreDechiffrement.setBackground(scoreBackground);
		scoreDechiffrement.setFont(scoreFont);
		scoreDechiffrement.setEditable(false);
		this.add(scoreDechiffrement, Integer.valueOf(2));
	
		int intituleFinalWidth = 100;
		intituleFinal = new JTextArea("4. Final");
		intituleFinal.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-intituleFinalWidth/2, scoreDechiffrement.getY()+scoreDechiffrement.getHeight()+paddingHeight, intituleFinalWidth, intituleHeight);
		intituleFinal.setForeground(intituleForeground);
		intituleFinal.setBackground(intituleBackground);
		intituleFinal.setFont(intituleFont);
		intituleFinal.setEditable(false);
		this.add(intituleFinal, Integer.valueOf(2));

		String titreIntituleFinal = "";
		int resultatFinalWidth;

		if(motFinalFound){
			titreIntituleFinal = "Trouvé";
			resultatFinalWidth = 55;
		} else {
			titreIntituleFinal = "Pas trouvé";
			resultatFinalWidth = 90;
		}

		resultatFinal = new JTextArea(titreIntituleFinal);
		resultatFinal.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-resultatFinalWidth/2, intituleFinal.getY()+intituleFinal.getHeight()+paddingHeight, resultatFinalWidth, scoreHeight);
		resultatFinal.setForeground(scoreForeground);
		resultatFinal.setBackground(scoreBackground);
		resultatFinal.setFont(scoreFont);
		resultatFinal.setEditable(false);
		this.add(resultatFinal, Integer.valueOf(2));

		int boutonMenuWidth = 300;
		boutonMenu = new Bouton("Menu Principal", zoneCentrale.getX()+zoneCentrale.getWidth()/2-boutonMenuWidth/2, zoneCentrale.getY()+zoneCentrale.getHeight()+spacingHeight, boutonMenuWidth, 40);
		boutonMenu.setFont(new Font("Helvetica", Font.BOLD, 20));

		boutonMenu.addActionListener(e -> mainController.retourMenuPrincipal());

		this.add(boutonMenu, Integer.valueOf(1));
	}
}