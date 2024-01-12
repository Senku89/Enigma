package frontend;

import general.Init;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JeuDecryptGraphic extends MiniJeuGraphic{
	
	// Fenetre fenetreRef;
	// JLabel bgImage;
	// Bouton boutonQuitter;
	// JLabel iconeTimer;
	// ZoneTexte zoneTimer; 
	// Titre titre;
	// JTextArea zoneScore;
	JLabel tableau, chiffre;
	JTextField devine;
	Bouton boutonValider;
	ZoneTexte zoneChiffre;

	public JeuDecryptGraphic(Fenetre fenetre){
		super(fenetre);
		// System.out.println("mpg graphic");
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeudecrypt));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, new Integer(0));

		titre = new Titre("3. Déchiffrer le Message Secret", 70, 30, 700, 35);
		this.add(titre, new Integer(1));

		this.add(boutonQuitter, new Integer(1));

		this.add(zoneScore, new Integer(1));

		this.add(zoneTimer, new Integer(1));

		this.add(iconeTimer, new Integer(2));

		tableau = new JLabel(new ImageIcon(Init.tableaualphabetsymboles));
		tableau.setBounds(450, 120, 520, 320);
		this.add(tableau, new Integer(1));

		zoneChiffre = new ZoneTexte("", titre.getX(), tableau.getY()+100, 350, 60);
		this.add(zoneChiffre, new Integer(1));

		chiffre = new JLabel(new ImageIcon(Init.getCle(2)));
		chiffre.setBounds(zoneChiffre.getX()+5, zoneChiffre.getY(), 350, 60);
		this.add(chiffre, new Integer(2));

		devine = new JTextField();
		devine.setBounds(zoneChiffre.getX(), zoneChiffre.getY()+zoneChiffre.getHeight()+30, zoneChiffre.getWidth(), 40);
		this.add(devine, new Integer(1));

		boutonValider = new Bouton("Valider", (zoneChiffre.getWidth()/2)-60+zoneChiffre.getHeight(), devine.getY()+devine.getHeight()+30, 160, 50);
		boutonValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String reponse = devine.getText().toLowerCase();
				// Methode Valider avec comme paramètre la réponse
				System.out.println("Valider : "+reponse);
			}
		});
		this.add(boutonValider, new Integer(1));
	}	
}