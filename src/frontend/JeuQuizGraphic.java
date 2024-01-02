package frontend;

import general.Init;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JeuQuizGraphic extends MiniJeuGraphic{
	
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

		zoneQuestion = new ZoneTexte("Question : ", titre.getX(), titre.getY()+titre.getHeight()+espacement, zoneTimer.getX()+zoneTimer.getWidth()-titre.getX(), zoneNum.getY()-paddingHeight-titre.getY()-titre.getHeight());
		zoneQuestion.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.add(zoneQuestion, new Integer(1));

		zoneCentrale = new ZoneTexte("", 195, 220, 620, 270);
		this.add(zoneCentrale, new Integer(1));

		repA = new Bouton("A)", zoneCentrale.getX()+paddingWidth, zoneCentrale.getY()+paddingHeight, zoneCentrale.getWidth()-2*30, repHeight);
		repB = new Bouton("B)", repA.getX(), repA.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight);	
		repC = new Bouton("C)", repA.getX(), repB.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight);	
		repD = new Bouton("D)", repA.getX(), repC.getY()+repHeight+paddingHeight, repA.getWidth(), repHeight);
	
		this.add(repA, new Integer(2));
		this.add(repB, new Integer(2));
		this.add(repC, new Integer(2));
		this.add(repD, new Integer(2));
	}	
}