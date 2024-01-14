package frontend;

import backend.minijeu.JeuQuiz;

import general.Init;
import general.MainController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	int boutonFontSize = 18;

	public JeuQuizGraphic(MainController mainController, Fenetre fenetre){
		super(mainController, fenetre);
		// System.out.println("mpg graphic");
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.index = 0;

		setupGraphic();
	}

	public void setupGraphic(){
		super.setupGraphic();

		System.out.println("index = "+index);

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeuquiz));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());
		this.add(bgImage, new Integer(0));

		titre = new Titre("1. Quiz", 70, 30, 120, 35);
		this.add(titre, new Integer(1));

		this.add(boutonQuitter, new Integer(1));
		this.add(zoneScore, new Integer(1));
		this.add(zoneTimer, new Integer(1));
		this.add(iconeTimer, new Integer(2));

		// Charger les questions
		List list = new ArrayList<String>();
		list.addAll(jeuQuiz.affichageQuestion(index));

		int zoneNumWidth = 45;
		if(index == 9){
			zoneNumWidth = 55;
		}

		zoneNum = new ZoneTexte(" "+(index+1)+"/10", 70, 190, zoneNumWidth, 20);
		zoneNum.setFont(new Font("Helvetica", Font.BOLD, 15));
		this.add(zoneNum, new Integer(1));

		// Énonce
		zoneQuestion = new ZoneTexte((String) list.get(0), titre.getX(), titre.getY()+titre.getHeight()+espacement, zoneTimer.getX()+zoneTimer.getWidth()-titre.getX(), zoneNum.getY()-paddingHeight-titre.getY()-titre.getHeight());
		zoneQuestion.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.add(zoneQuestion, new Integer(1));

		zoneCentrale = new ZoneTexte("", 195, 220, 620, 270);
		this.add(zoneCentrale, new Integer(1));

		// Reponses
		repA = new Bouton((String) list.get(1), zoneCentrale.getX()+paddingWidth, zoneCentrale.getY()+paddingHeight, zoneCentrale.getWidth()-2*30, repHeight, boutonFontSize);
		repB = new Bouton((String) list.get(2), repA.getX(), repA.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight, boutonFontSize);
		repC = new Bouton((String) list.get(3), repA.getX(), repB.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight, boutonFontSize);
		repD = new Bouton((String) list.get(4), repA.getX(), repC.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight, boutonFontSize);
	
		repA.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				nextQuestion(repA.getText());
			}
		});

		repB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				nextQuestion(repB.getText());
			}
		});

		repC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				nextQuestion(repC.getText());
			}
		});

		repD.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				nextQuestion(repD.getText());
			}
		});

		this.add(repA, new Integer(2));
		this.add(repB, new Integer(2));
		this.add(repC, new Integer(2));
		this.add(repD, new Integer(2));
	}

	public void nextQuestion(String reponse){
		jeuQuiz.gererReponse(reponse, index);
		index++;
		if(index < 10){
			reset();
			fenetre.repaintFenetre();
		} else {
			System.out.println("Fin jeu Quiz");
			// ##### Passage jeu password
		}
	}

	public void reset(){
		this.removeAll();
		/*repA = null; repB = null; repC = null; repD = null;
		zoneNum = null; zoneQuestion = null; zoneCentrale = null;*/
		this.setupGraphic();
		/*fenetre.repaintFenetre();*/
	}

	public int getScore(){
		return jeuQuiz.getScore();
	}
}