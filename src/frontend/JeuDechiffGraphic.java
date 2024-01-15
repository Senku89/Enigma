package frontend;

import backend.minijeu.JeuDechiffrement;
import general.Init;
import general.MainController;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JeuDechiffGraphic extends MiniJeuGraphic{

	JeuDechiffrement jeuDechiffrement = new JeuDechiffrement(Init.classeur1csv);

	JLabel tableau, chiffre;
	JTextField devine;
	Bouton boutonValider;
	ZoneTexte zoneChiffre;

	public JeuDechiffGraphic(MainController mainController, Fenetre fenetre){
		super(mainController, fenetre);

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		setupGraphic();
	}

	@Override
	public void setupGraphic(){

		super.setupGraphic();

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeudecrypt));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, Integer.valueOf(0));

		titre = new Titre("3. Déchiffrer le Message Secret", 70, 30, 700, 35);
		this.add(titre, Integer.valueOf(1));

		tableau = new JLabel(new ImageIcon(Init.tableaualphabetsymboles));
		tableau.setBounds(450, 120, 520, 320);
		this.add(tableau, Integer.valueOf(1));

		zoneChiffre = new ZoneTexte("", titre.getX(), tableau.getY()+100, 350, 60);
		this.add(zoneChiffre, Integer.valueOf(1));

		// Image clé
		chiffre = new JLabel(new ImageIcon(jeuDechiffrement.showImageCle()));
		chiffre.setBounds(zoneChiffre.getX()+5, zoneChiffre.getY(), 350, 60);
		this.add(chiffre, Integer.valueOf(2));

		devine = new JTextField();
		devine.setBounds(zoneChiffre.getX(), zoneChiffre.getY()+zoneChiffre.getHeight()+30, zoneChiffre.getWidth(), 40);
		this.add(devine, Integer.valueOf(1));

		boutonValider = new Bouton("Valider", (zoneChiffre.getWidth()/2)-60+zoneChiffre.getHeight(), devine.getY()+devine.getHeight()+30, 160, 50);
		boutonValider.addActionListener(e -> {
            String reponse = devine.getText().toLowerCase();
            // Methode Valider avec comme paramètre la réponse
            jeuDechiffrement.checkResultat(reponse);
            score = jeuDechiffrement.getScore();
            score = (int)(((double)score/6)*100);
            nextMessage();
        });
		this.add(boutonValider, Integer.valueOf(1));
	}

	public void nextMessage(){
		jeuDechiffrement.nextMessage();
		if(jeuDechiffrement.showImageCle().isEmpty()){
			mainController.startJeuFinal();
		} else {
			this.removeAll();
			setupGraphic();
			fenetre.repaintFenetre();
		}
	}

	public int getScore(){
		return jeuDechiffrement.getScore();
	}
}