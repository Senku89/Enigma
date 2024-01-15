package general;

import java.awt.Color;

public class Init{

	// Ici on introduit les score minimum pour avoir l'indice
	public static int minQuiz = 50; // Add in Init
	public static int minMDP = 50; // Add in Init
	public static int minDechiff = 50; // Add in Init

	public static String resourcepath = "resources/";

	public static String imagefondmenuprincipal = resourcepath+"images/menu.png";
	public static String imagefondjeuquiz = resourcepath+"images/question.png";
	public static String imagefondjeumdp = resourcepath+"images/mdp.png";
	public static String imagefondjeudecrypt = resourcepath+"images/decryp.png";
	public static String iconetimer = resourcepath+"images/stopwatch.png";
	public static String tableaualphabetsymboles = resourcepath+"images/tableau.png";

	public static String classeur1csv = resourcepath+"classeur1.csv";
	public static String jeufinalcsv = resourcepath+"jeufinal.csv";
	public static String mdpcsv = resourcepath+"MDP.csv";
	public static String questionsreponsescsv = resourcepath+"Q-R-crypto.csv";

	public static Color couleurfondbouton = new Color(60, 60, 60);
	public static Color couleurtextbouton = new Color(250, 250, 250);
	public static Color couleurfondzonetext = new Color(225, 225, 240, 242);

	public static String texteIntro = "Vous allez passer par 3 mini-jeux qui vous permettront de gagner des indices qui vous aideront au moment de décoder Enigma :\n" +
			"1. Un quiz comportant 10 questions sur la cryptographie\n" +
			"2. Classifier les mots de passe en trois niveaux\n" +
			"3. Déchiffrer les messages secrets\n" +
			"Enigma : Trouvez le mot mystère en fonction des indices que vous avez récoltés\nBonne chance et bon déchiffrage !\n";

	public static String getCle(int num){
		return resourcepath+"images/cle"+num+".png";
	}

}