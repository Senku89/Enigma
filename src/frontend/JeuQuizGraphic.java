package frontend;

import backend.minijeu.JeuQuiz;
import general.Init;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JeuQuizGraphic extends MiniJeuGraphic{
	JeuQuiz jeuQuiz = new JeuQuiz(Init.questionsreponsescsv);
	int index=0; // A modifier apres pour charger chaque question
	ZoneTexte zoneNum;
	ZoneTexte zoneCentrale;
	ZoneTexte zoneQuestion;
	Bouton repA, repB, repC, repD;

	int paddingWidth = 30, paddingHeight = 22, repHeight = 40;

	public JeuQuizGraphic(Fenetre fenetre){
		super(fenetre);
		// System.out.println("mpg graphic");
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeuquiz));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, new Integer(0));

		titre = new Titre("1. Quiz", 70, 30, 120, 35);
		this.add(titre, new Integer(1));

		this.add(boutonQuitter, new Integer(1));
		this.add(zoneScore, new Integer(1));
		this.add(zoneTimer, new Integer(1));
		this.add(iconeTimer, new Integer(2));

		zoneNum = new ZoneTexte(" 1/10", 70, 190, 45, 20);
		zoneNum.setFont(new Font("Helvetica", Font.BOLD, 15));
		this.add(zoneNum, new Integer(1));

		// Charger les questions
		List list = new ArrayList<String>();
		list.addAll(jeuQuiz.affichageQuestion(index));

		// Énonce
		zoneQuestion = new ZoneTexte((String) list.get(0), titre.getX(), titre.getY()+titre.getHeight()+espacement, zoneTimer.getX()+zoneTimer.getWidth()-titre.getX(), zoneNum.getY()-paddingHeight-titre.getY()-titre.getHeight());
		zoneQuestion.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.add(zoneQuestion, new Integer(1));

		zoneCentrale = new ZoneTexte("", 195, 220, 620, 270);
		this.add(zoneCentrale, new Integer(1));

		// Reponses
		repA = new Bouton((String) list.get(1), zoneCentrale.getX()+paddingWidth, zoneCentrale.getY()+paddingHeight, zoneCentrale.getWidth()-2*30, repHeight);
		repB = new Bouton((String) list.get(2), repA.getX(), repA.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight);
		repC = new Bouton((String) list.get(3), repA.getX(), repB.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight);
		repD = new Bouton((String) list.get(4), repA.getX(), repC.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight);
	
		repA.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Methode choix réponse A
				index=jeuQuiz.gererReponse(repA.getText(), index);
				// Sauter question Suivant
				System.out.println("A");
			}
		});

		repB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Methode choix réponse B
				index=jeuQuiz.gererReponse(repB.getText(), index);
				// Sauter question Suivant
				System.out.println("B");
			}
		});

		repC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Methode choix réponse C
				index=jeuQuiz.gererReponse(repC.getText(), index);
				// Sauter question Suivant
				System.out.println("C");
			}
		});

		repD.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Methode choix réponse D
				index=jeuQuiz.gererReponse(repD.getText(), index);
				// Sauter question Suivant
				System.out.println("D");
			}
		});

		this.add(repA, new Integer(2));
		this.add(repB, new Integer(2));
		this.add(repC, new Integer(2));
		this.add(repD, new Integer(2));
	}	
}