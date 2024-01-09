package frontend;

import general.Init;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class MiniJeuGraphic extends JLayeredPane{
	
	protected Fenetre fenetre;
	protected JLabel bgImage;
	protected JLabel iconeTimer;
	protected ZoneTexte zoneTimer; 
	protected Titre titre;
	protected Bouton boutonQuitter;
	protected ZoneTexte zoneScore;

	int espacement = 10;

	public MiniJeuGraphic(Fenetre fenetre){
		this.fenetre = fenetre;

		boutonQuitter = new Bouton("Quitter", 813, 500, 150, 40);
		boutonQuitter.setFont(new Font("Helvetica", Font.BOLD, 20));
		boutonQuitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Methode retour menu principal
				System.out.println("Quitter");
			}
		});

		zoneScore = new ZoneTexte(" 0 / 100 points", 70, 500, 120, 20);
		zoneScore.setFont(new Font("Helvetica", Font.BOLD, 15));

		zoneTimer = new ZoneTexte("     0:00", 820, 30, 130, 35);
		zoneTimer.setFont(new Font("Helvetica", Font.BOLD, 30));

		iconeTimer = new JLabel(new ImageIcon(Init.iconetimer));
		iconeTimer.setBounds(825, 30, 35, 35);

		// System.out.println(timerIcone);
	}
}