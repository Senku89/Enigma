package general;

import java.awt.Color;

public class Init{
	
	public static String imagefondmenuprincipal = "images/menu.png";
	public static String imagefondjeuquiz = "images/question.png";
	public static String imagefondjeumdp = "images/mdp.png";
	public static String imagefondjeudecrypt = "images/decryp.png";
	public static String iconetimer = "images/stopwatch.png";
	public static String tableaualphabetsymboles = "images/tableau.png";

	public static Color couleurfondbouton = new Color(60, 60, 60);
	public static Color couleurtextbouton = new Color(250, 250, 250);

	public static Color couleurfondzonetext = new Color(225, 225, 240, 242);

	public static String texteIntro = "Welcome Everyone";

	public static String getCle(int num){
		return "images/cle"+num+".png";
	}
}