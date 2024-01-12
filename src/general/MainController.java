package general;

import backend.minijeu.*;
import frontend.*;
import general.Init;
import util.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainController{
		private static List<Minijeu> listeMinijeux = new ArrayList<>();
		Logger logger = Logger.getLogger(getClass().getName());
		private static Score score;

		Fenetre f;
		MenuPrincipalGraphic mpg;
		JeuQuizGraphic jqg;
		JeuMdpGraphic jmg;
		JeuDecryptGraphic jdg;
		JeuFinalGraphic jfg;
		ResultatsFinauxGraphic rfg;

		// Constructeur
		public MainController() {
			try {
				listeMinijeux.add(new JeuQuiz(Init.questionsreponsescsv));
				listeMinijeux.add(new JeuPassword(Init.mdpcsv));
				listeMinijeux.add(new JeuDechiffrement(Init.classeur1csv));
				listeMinijeux.add(new JeuFinal(Init.jeufinalcsv));
			}catch(Exception e){
				logger.severe("Error sur l'initialisation des Mini-jeux : " + e.getMessage());
			}
			score = new Score();

			f = new Fenetre();

			mpg = new MenuPrincipalGraphic(this, f);

			jqg = new JeuQuizGraphic(this, f);
			jmg = new JeuMdpGraphic(this, f);
			jdg = new JeuDecryptGraphic(this, f);
			jfg = new JeuFinalGraphic(this, f);

			rfg = new ResultatsFinauxGraphic(this, f);
		}

		// Lancer le Menu Principal
		public void startMenuPrincipal(){
			f.setPanelActif(jmg);
		}

		
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
			f.setPanelActif(jmg);
		}
}