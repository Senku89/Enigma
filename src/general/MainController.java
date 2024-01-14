package general;

import backend.minijeu.*;

import frontend.*;

import general.Init;

import util.Score;
import util.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static util.Score.listeScore;

public class MainController{
		Logger logger = Logger.getLogger(getClass().getName());
		private static Score score;

		private Timer timer;
		private final int tempsDeJeu = 10;

		private Fenetre f;
		private MenuPrincipalGraphic mpg;
		private JeuQuizGraphic jqg;
		private JeuMdpGraphic jmg;
		private JeuDecryptGraphic jdg;
		private JeuFinalGraphic jfg;
		private ResultatsFinauxGraphic rfg;

		// Constructeur
		public MainController() {

			score = new Score();
			timer = new Timer(this, tempsDeJeu);

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
			timer.startTimer();
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
<<<<<<< HEAD
			rfg = new ResultatsFinauxGraphic(this, f, listeScore.get(0).getScore(), listeScore.get(1).getScore(), listeScore.get(2).getScore(), jfg.jeuFinal.getMotTrouve());
=======
			timer.stopTimer();
			rfg = new ResultatsFinauxGraphic(this, f, jqg.getScore(), jmg.getScore(), jdg.getScore(), jfg.isMotTrouve());
>>>>>>> Modifications ergonomiques timer grapĥique
			f.setPanel(rfg);
		}
		
		//Retour Menu Principal
		public void retourMenuPrincipal(){
			timer.stopTimer();
			timer = new Timer(this, tempsDeJeu);
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

		public String getTime(){
			int timeSeconds = timer.getTimeSeconds();

			String minutesStr, secondesStr;
			int minutes = timeSeconds/60;
			int secondes = timeSeconds%60;
			
			minutesStr = ""+minutes;
			if(minutes < 10){
				minutesStr = "0"+minutesStr;
			}

			secondesStr = ""+secondes;
			if(secondes < 10){
				secondesStr = "0"+secondesStr;
			}

			return minutesStr+":"+secondesStr;
		}

		public void timerIsUpdated(int timeSeconds){
			String minutesStr, secondesStr;
			int minutes = timeSeconds/60;
			int secondes = timeSeconds%60;
			
			minutesStr = ""+minutes;
			/*if(minutes < 10){
				minutesStr = "0"+minutesStr;
			}*/

			secondesStr = ""+secondes;
			if(secondes < 10){
				secondesStr = "0"+secondesStr;
			}

			System.out.println(minutesStr+":"+secondesStr);
		}

		public void outOfTime(){
			retourMenuPrincipal();
		}
}