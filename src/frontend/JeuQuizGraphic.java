package frontend;

import backend.minijeu.JeuQuiz;

import general.Init;
import general.MainController;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JeuQuizGraphic extends MiniJeuGraphic{
	private JeuQuiz jeuQuiz = new JeuQuiz(Init.questionsreponsescsv);
	private int index; // A modifier apres pour charger chaque question
	private ZoneTexte zoneNum;
	private ZoneTexte zoneCentrale;
	private ZoneTexte zoneQuestion;
	private Bouton repA, repB, repC, repD;

	int paddingWidth = 30, paddingHeight = 22, repHeight = 40;
	int boutonFontSize = 13;

	public JeuQuizGraphic(MainController mainController, Fenetre fenetre){
		super(mainController, fenetre);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.index = 0;

		setupGraphic();
	}

	@Override
	public void setupGraphic(){
		super.setupGraphic();

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeuquiz));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());
		this.add(bgImage, Integer.valueOf(0));

		titre = new Titre("1. Quiz", 70, 30, 120, 35);
		this.add(titre, Integer.valueOf(1));

		// Charger les questions
		List<String> list = new ArrayList<>();
		list.addAll(jeuQuiz.affichageQuestion(index));

		int zoneNumWidth = 45;
		if(index == 9){
			zoneNumWidth = 55;
		}

		zoneNum = new ZoneTexte(" "+(index+1)+"/10", 70, 190, zoneNumWidth, 20);
		zoneNum.setFont(new Font("Helvetica", Font.BOLD, 15));
		this.add(zoneNum, Integer.valueOf(1));

		// Énonce
		zoneQuestion = new ZoneTexte( list.get(0), titre.getX(), titre.getY()+titre.getHeight()+espacement, zoneTimer.getX()+zoneTimer.getWidth()-titre.getX(), zoneNum.getY()-paddingHeight-titre.getY()-titre.getHeight());
		zoneQuestion.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.add(zoneQuestion, Integer.valueOf(1));

		zoneCentrale = new ZoneTexte("", 195, 220, 620, 270);
		this.add(zoneCentrale, Integer.valueOf(1));

		// Reponses
		repA = new Bouton( list.get(1), zoneCentrale.getX()+paddingWidth, zoneCentrale.getY()+paddingHeight, zoneCentrale.getWidth()-2*30, repHeight, boutonFontSize);
		repB = new Bouton( list.get(2), repA.getX(), repA.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight, boutonFontSize);
		repC = new Bouton( list.get(3), repA.getX(), repB.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight, boutonFontSize);
		repD = new Bouton( list.get(4), repA.getX(), repC.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight, boutonFontSize);
	
		repA.addActionListener(e -> nextQuestion(repA.getText()));

		repB.addActionListener(e -> nextQuestion(repB.getText()));

		repC.addActionListener(e -> nextQuestion(repC.getText()));

		repD.addActionListener(e -> nextQuestion(repD.getText()));

		this.add(repA, Integer.valueOf(2));
		this.add(repB, Integer.valueOf(2));
		this.add(repC, Integer.valueOf(2));
		this.add(repD, Integer.valueOf(2));
	}

	public void nextQuestion(String reponse){
		jeuQuiz.gererReponse(reponse, index);
		score = jeuQuiz.getScore();
		index++;
		if(index < 10){
			reset();
			fenetre.repaintFenetre();
		} else {
			// Debut prochain jeu
			mainController.startJeuMDP();
		}
	}

	public void reset(){
		this.removeAll();

		this.setupGraphic();
	}

	public int getScore(){
		return jeuQuiz.getScore();
	}
}