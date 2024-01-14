package general;

import backend.minijeu.*;
import frontend.*;
import general.Init;
import util.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static util.Score.listeScore;

public class MainController{
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
			
			score = new Score();

			f = new Fenetre();

			mpg = new MenuPrincipalGraphic(this, f);
			jqg = new JeuQuizGraphic(this, f);
			jmg = new JeuMdpGraphic(this, f);
			jdg = new JeuDecryptGraphic(this, f);
			jfg = new JeuFinalGraphic(this, f);
		}

		// Lancer le Menu Principal
		public void startMenuPrincipal(){
			f.setPanel(mpg);
		}

		public void startJeuQuiz(){
			f.setPanel(jqg);
		}

		public void startJeuMDP(){
			f.setPanel(jmg);
		}

		public void startJeuDecrypt(){
			f.setPanel(jdg);
		}

		public void startJeuFinal(){
			f.setPanel(jfg);
		}

		public void startResultatFinaux(){
			rfg = new ResultatsFinauxGraphic(this, f, jqg.getScore(), jmg.getScore(), jdg.getScore(), jfg.isMotTrouve());
			f.setPanel(rfg);
		}
		
		//Retour Menu Principal
		public void retourMenuPrincipal(){
			f.setPanel(mpg);
			reset();
		}
		
		public void reset() {
			this.jqg = new JeuQuizGraphic(this, f);
			this.jmg = new JeuMdpGraphic(this, f);
			this.jdg = new JeuDecryptGraphic(this, f);
			this.jfg = new JeuFinalGraphic(this, f);
			// Creer un nouvel Score
			Score newScore = new Score();
			// Remplacer le score actuel avec un nouvel score
			score = newScore;
			// Supprimer tous les elements score
			listeScore.clear();

		}

		public static void timerIsUpdated(int timeSeconds){
			System.out.println("TIMER IS BEING UPDATED");
		}
}