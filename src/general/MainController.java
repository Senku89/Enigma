package general;

import backend.minijeu.*;

import frontend.*;

import general.Init;

import util.Score;
import util.Timer;

import java.awt.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainController{
		Logger logger = Logger.getLogger(getClass().getName());
		private static Score score;
		private Timer timer;
		private final int tempsDeJeu = 600;

		private Fenetre f;
		private MenuPrincipalGraphic mpg;
		private JeuQuizGraphic jqg;
		private JeuMdpGraphic jmg;
		private JeuDecryptGraphic jdg;
		private JeuFinalGraphic jfg;
		private ResultatsFinauxGraphic rfg;

		private MiniJeuGraphic jeuActif;

		// Constructeur
		public MainController() {

			score = new Score();
			timer = new Timer(this, tempsDeJeu);

			f = new Fenetre();

			mpg = new MenuPrincipalGraphic(this, f);
		}

		// Lancer le Menu Principal
		public void startMenuPrincipal(){
			f.setPanel(mpg);
		}

		public void startJeuQuiz(){
			timer.startTimer();
			jqg = new JeuQuizGraphic(this, f);
			f.setPanel(jqg);
			jeuActif = (MiniJeuGraphic)f.getPanel();
		}

		public void startJeuMDP(){
			jmg = new JeuMdpGraphic(this, f);
			f.setPanel(jmg);
			jeuActif = (MiniJeuGraphic)f.getPanel();
		}

		public void startJeuDecrypt(){
			jdg = new JeuDecryptGraphic(this, f);
			f.setPanel(jdg);
			jeuActif = (MiniJeuGraphic)f.getPanel();
		}

		public void startJeuFinal(){
			jfg = new JeuFinalGraphic(this, f);
			f.setPanel(jfg);
			jeuActif = (MiniJeuGraphic)f.getPanel();
		}

		public void startResultatFinaux(){
			timer.stopTimer();
			rfg = new ResultatsFinauxGraphic(this, f, jqg.getScore(), jmg.getScore(), jdg.getScore(), jfg.isMotTrouve());
			f.setPanel(rfg);
			jeuActif = null;
		}
		
		//Retour Menu Principal
		public void retourMenuPrincipal(){
			
			f.setPanel(mpg);
			reset();
		}
		
		public void reset() {
			jeuActif = null;
			timer.stopTimer();
			timer = new Timer(this, tempsDeJeu);

			// Creer un nouvel Score
			Score newScore = new Score();
			// Remplacer le score actuel avec un nouvel score
			score = newScore;
		}

		public String getTime(){
			int timeSeconds = timer.getTimeSeconds();

			String minutesStr, secondesStr;
			int minutes = timeSeconds/60;
			int secondes = timeSeconds%60;
			
			minutesStr = ""+minutes;

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

			secondesStr = ""+secondes;
			if(secondes < 10){
				secondesStr = "0"+secondesStr;
			}

			jeuActif.updateTimer(minutesStr+":"+secondesStr);

			Component timerGraphic = jeuActif.getTimer();

			f.repaint(timerGraphic.getX(), timerGraphic.getY(), timerGraphic.getWidth(), timerGraphic.getHeight());
		}

		public void outOfTime(){
			retourMenuPrincipal();
		}
}