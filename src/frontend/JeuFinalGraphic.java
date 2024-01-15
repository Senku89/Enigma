package frontend;

import backend.minijeu.JeuFinal;
import general.Init;
import general.MainController;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JeuFinalGraphic extends MiniJeuGraphic{
	public JeuFinal jeuFinal = new JeuFinal(Init.jeufinalcsv);

	ZoneTexte zoneCentrale;
	JTextArea textIndices, textIndice1, textIndice2, textIndice3;
	JTextArea zoneIndices, zoneIndice1, zoneIndice2, zoneIndice3;
	JTextField zoneMotFinal;
	Bouton boutonValider;

	String indiceNonTrouve = "Indice non Trouvé";

	int spacingHeight = 20, hauteurZoneCentrale = 320;
	int paddingWidth = 30, paddingHeight = 15, beetweenIntituleAndIndice = 10, indiceHeight = 25;

	Color foregroundIntituleIndice = Color.BLACK, backgroundIntituleIndice = new Color(0, 0, 0, 0);

	// Si trouve ecrire cette valeur
	Color foregroundIndiceTrouve = Color.BLACK, backgroundIndiceTrouve = new Color(225, 225, 240, 255);
	// Si non trouve utiliser cette valeur
	Color foregroundIndicePasTrouve = Color.WHITE, backgroundIndicePasTrouve = new Color(50, 50, 50, 255);
	Font fontIntituleIndice = new Font("Helvetica", Font.BOLD, 20), fontIndice = new Font("Helvetica", Font.BOLD, 15);

	public JeuFinalGraphic(MainController mainController, Fenetre fenetre){
		super(mainController, fenetre);

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		super.setupGraphic();

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeuquiz));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, Integer.valueOf(0));

		titre = new Titre("4. Découvre le Mot Final", 70, 30, 410, 35);
		
		this.add(titre, Integer.valueOf(1));

		zoneCentrale = new ZoneTexte("", titre.getX(), titre.getY()+titre.getHeight()+spacingHeight,zoneTimer.getX()+zoneTimer.getWidth()-titre.getX(), hauteurZoneCentrale);
		this.add(zoneCentrale, Integer.valueOf(1));

		textIndices = new JTextArea("Indices");
		textIndices.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-40, zoneCentrale.getY()+10, 80, 20);
		textIndices.setForeground(foregroundIntituleIndice);
		textIndices.setBackground(backgroundIntituleIndice);
		textIndices.setFont(fontIntituleIndice);
		textIndices.setEditable(false);
		this.add(textIndices, Integer.valueOf(2));

		zoneIndices = new JTextArea(jeuFinal.getCurrentIndice().getTxt0());
		zoneIndices.setBounds(zoneCentrale.getX()+paddingWidth, textIndices.getY()+textIndices.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		zoneIndices.setForeground(foregroundIndiceTrouve);
		zoneIndices.setBackground(backgroundIndiceTrouve);
		zoneIndices.setFont(fontIndice);
		zoneIndices.setEditable(false);
		this.add(zoneIndices, Integer.valueOf(2));

		textIndice1 = new JTextArea("Indice Quiz");
		textIndice1.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndices.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice1.setForeground(foregroundIntituleIndice);
		textIndice1.setBackground(backgroundIntituleIndice);
		textIndice1.setFont(fontIntituleIndice);
		textIndice1.setEditable(false);
		this.add(textIndice1, Integer.valueOf(2));

		zoneIndice1 = new JTextArea(jeuFinal.getCurrentIndice().getTxt1());
		zoneIndice1.setBounds(zoneCentrale.getX()+paddingWidth, textIndice1.getY()+textIndice1.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		if(jeuFinal.ifIndiceTrouve(0, Init.minQuiz)){
			zoneIndice1.setForeground(foregroundIndiceTrouve);
			zoneIndice1.setBackground(backgroundIndiceTrouve);
		}else{
			zoneIndice1.setText(indiceNonTrouve);
			zoneIndice1.setForeground(foregroundIndicePasTrouve);
			zoneIndice1.setBackground(backgroundIndicePasTrouve);
		}
		zoneIndice1.setFont(fontIndice);
		zoneIndice1.setEditable(false);
		this.add(zoneIndice1, Integer.valueOf(2));

		textIndice2 = new JTextArea("Indice Mots de Passe");
		textIndice2.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndice1.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice2.setForeground(foregroundIntituleIndice);
		textIndice2.setBackground(backgroundIntituleIndice);
		textIndice2.setFont(fontIntituleIndice);
		textIndice2.setEditable(false);
		this.add(textIndice2, Integer.valueOf(2));

		zoneIndice2 = new JTextArea(jeuFinal.getCurrentIndice().getTxt2());
		zoneIndice2.setBounds(zoneCentrale.getX()+paddingWidth, textIndice2.getY()+textIndice1.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		if(jeuFinal.ifIndiceTrouve(1, Init.minMDP)){
			zoneIndice2.setForeground(foregroundIndiceTrouve);
			zoneIndice2.setBackground(backgroundIndiceTrouve);
		}else{
			zoneIndice2.setText(indiceNonTrouve);
			zoneIndice2.setForeground(foregroundIndicePasTrouve);
			zoneIndice2.setBackground(backgroundIndicePasTrouve);
		}
		zoneIndice2.setFont(fontIndice);
		zoneIndice2.setEditable(false);
		this.add(zoneIndice2, Integer.valueOf(2));

		textIndice3 = new JTextArea("Indice Déchiffrements");
		textIndice3.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndice2.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice3.setForeground(foregroundIntituleIndice);
		textIndice3.setBackground(backgroundIntituleIndice);
		textIndice3.setFont(fontIntituleIndice);
		textIndice3.setEditable(false);
		this.add(textIndice3, Integer.valueOf(2));

		zoneIndice3 = new JTextArea(jeuFinal.getCurrentIndice().getTxt3());
		zoneIndice3.setBounds(zoneCentrale.getX()+paddingWidth, textIndice3.getY()+textIndice1.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		if(jeuFinal.ifIndiceTrouve(2, Init.minDechiff)){
			zoneIndice3.setForeground(foregroundIndiceTrouve);
			zoneIndice3.setBackground(backgroundIndiceTrouve);
		}else{
			zoneIndice3.setText(indiceNonTrouve);
			zoneIndice3.setForeground(foregroundIndicePasTrouve);
			zoneIndice3.setBackground(backgroundIndicePasTrouve);
		}
		zoneIndice3.setFont(fontIndice);
		zoneIndice3.setEditable(false);
		this.add(zoneIndice3, Integer.valueOf(2));

		zoneMotFinal = new JTextField();
		zoneMotFinal.setBounds(zoneCentrale.getX()+100, zoneCentrale.getY()+zoneCentrale.getHeight()+spacingHeight, zoneCentrale.getWidth()-200, 50);
		zoneMotFinal.setForeground(Color.BLACK);
		zoneMotFinal.setBackground(Color.WHITE);
		zoneMotFinal.setFont(fontIndice);
		zoneMotFinal.setEditable(false);
		this.add(zoneMotFinal, Integer.valueOf(1));

		boutonValider = new Bouton("Valider", zoneCentrale.getX()+zoneCentrale.getWidth()/2-boutonQuitter.getWidth()/2, boutonQuitter.getY(), boutonQuitter.getWidth(), boutonQuitter.getHeight());
		boutonValider.addActionListener(e -> {
            String reponse = zoneMotFinal.getText().toLowerCase();
            // Methode Valider avec comme paramètre la réponse
            jeuFinal.validerMotFinal(reponse);
            mainController.startResultatFinaux();
        });
		this.add(boutonValider, Integer.valueOf(1));

	}
}