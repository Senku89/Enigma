package general;

import backend.minijeu.*;
import frontend.*;
import util.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainController{
		private static List<Minijeu> listeMinijeux = new ArrayList<>();
		Logger logger = Logger.getLogger(getClass().getName());
		private static Score score;
		Fenetre f = new Fenetre();
		MenuPrincipalGraphic mpg = new MenuPrincipalGraphic(f);
		JeuQuizGraphic jqg = new JeuQuizGraphic(f);
		JeuMdpGraphic jmg = new JeuMdpGraphic(f);
		JeuDecryptGraphic jdg = new JeuDecryptGraphic(f);
		JeuFinalGraphic jfg = new JeuFinalGraphic(f);
		ResultatsFinauxGraphic rfg = new ResultatsFinauxGraphic(f);


		// Constructeur
		public MainController() {

		}

		// Lancer le Menu Principal
		public void startMenuPrincipal(){
			f.setPanelActif(jdg);
		}

		/*
		//Retour Menu Principal
		public void retourMenuPrincipal(){
			f.setPanelActif(mpg);
			resetAndCreateNewScore();
		}
		public static void resetAndCreateNewScore() {
			// Creer un nouvel Score
			Score newScore = new Score();
			// Remplacer le score actuel avec un nouvel score
			score = newScore;
		}

		public void nextJeu(int i){
			listeMinijeux.get(i);
			f.setPanelActif(jqg);
		}
		 */
}