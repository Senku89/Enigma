package frontend;

import general.Init;
import general.MainController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class MiniJeuGraphic extends JLayeredPane{
	protected MainController mainController;
	protected Fenetre fenetre;
	protected JLabel bgImage;
	protected JLabel iconeTimer;
	protected ZoneTexte zoneTimer;
	protected JTextArea timer;
	protected Titre titre;
	protected Bouton boutonQuitter;
	protected ZoneTexte zoneScore;
	protected int score = 0;

	int espacement = 10;

	public MiniJeuGraphic(MainController mainController, Fenetre fenetre){
		this.mainController = mainController;
		this.fenetre = fenetre;
	}

	public void setupGraphic(){
		boutonQuitter = new Bouton("Quitter", 813, 500, 150, 40);
		boutonQuitter.setFont(new Font("Helvetica", Font.BOLD, 20));
		boutonQuitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainController.retourMenuPrincipal();
			}
		});
		this.add(boutonQuitter, new Integer(1));

		int scoreWidth = 130;
		if(score == 0){
			scoreWidth = 120;
		}

		zoneScore = new ZoneTexte(" "+score+" / 100 points", 70, 500, scoreWidth, 20);
		zoneScore.setFont(new Font("Helvetica", Font.BOLD, 15));
		this.add(zoneScore, new Integer(1));

		zoneTimer = new ZoneTexte("", 820, 30, 130, 35);
		this.add(zoneTimer, new Integer(1));

		timer = new JTextArea(mainController.getTime());
		timer.setBounds(zoneTimer.getX()+40, zoneTimer.getY()+2, zoneTimer.getWidth()-40, zoneTimer.getHeight()-4);
		timer.setForeground(Color.BLACK);
		timer.setBackground(new Color(0, 0, 0, 0));
		timer.setFont(new Font("Helvetica", Font.BOLD, 28));
		this.add(timer, new Integer(2));

		iconeTimer = new JLabel(new ImageIcon(Init.iconetimer));
		iconeTimer.setBounds(821, 30, 35, 35);
		this.add(iconeTimer, new Integer(2));
	}

	public JTextArea getTimer(){
		return this.timer;
	}

	public void updateTimer(String time){
		this.remove(timer);

		timer = new JTextArea(time);
		timer.setBounds(zoneTimer.getX()+40, zoneTimer.getY()+2, zoneTimer.getWidth()-40, zoneTimer.getHeight()-4);
		timer.setForeground(Color.BLACK);
		timer.setBackground(new Color(0, 0, 0, 0));
		timer.setFont(new Font("Helvetica", Font.BOLD, 28));
		this.add(timer, new Integer(2));
	}
}