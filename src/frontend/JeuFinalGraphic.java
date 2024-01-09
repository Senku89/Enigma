package frontend;

import general.Init;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextField;

public class JeuFinalGraphic extends MiniJeuGraphic{
	
	ZoneTexte zoneCentrale;
	JTextArea textIndices, textIndice1, textIndice2, textIndice3;
	JTextArea zoneIndices, zoneIndice1, zoneIndice2, zoneIndice3;
	JTextField zoneMotFinal;
	Bouton boutonValider;

	int spacingHeight = 20, hauteurZoneCentrale = 320;
	int paddingWidth = 30, paddingHeight = 15, beetweenIntituleAndIndice = 10, indiceHeight = 25;

	Color foregroundIntituleIndice = Color.BLACK, backgroundIntituleIndice = new Color(0, 0, 0, 0);
	Color foregroundIndiceTrouve = Color.BLACK, backgroundIndiceTrouve = new Color(225, 225, 240, 255);
	Color foregroundIndicePasTrouve = Color.WHITE, backgroundIndicePasTrouve = new Color(50, 50, 50, 255);
	Font fontIntituleIndice = new Font("Helvetica", Font.BOLD, 20), fontIndice = new Font("Helvetica", Font.BOLD, 15);

	public JeuFinalGraphic(Fenetre fenetre){
		super(fenetre);
		// System.out.println("mpg graphic");
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeuquiz));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, new Integer(0));

		titre = new Titre("4. Découvre le Mot Final", 70, 30, 410, 35);
		this.add(titre, new Integer(1));

		this.add(boutonQuitter, new Integer(1));

		this.add(zoneTimer, new Integer(1));

		this.add(iconeTimer, new Integer(2));

		zoneCentrale = new ZoneTexte("", titre.getX(), titre.getY()+titre.getHeight()+spacingHeight, zoneTimer.getX()+zoneTimer.getWidth()-titre.getX(), hauteurZoneCentrale);
		this.add(zoneCentrale, new Integer(1));

		textIndices = new JTextArea("Indices");
		textIndices.setBounds(zoneCentrale.getX()+zoneCentrale.getWidth()/2-40, zoneCentrale.getY()+10, 80, 20);
		textIndices.setForeground(foregroundIntituleIndice);
		textIndices.setBackground(backgroundIntituleIndice);
		textIndices.setFont(fontIntituleIndice);
		this.add(textIndices, new Integer(2));

		zoneIndices = new JTextArea("zone indices");
		zoneIndices.setBounds(zoneCentrale.getX()+paddingWidth, textIndices.getY()+textIndices.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		zoneIndices.setForeground(foregroundIndiceTrouve);
		zoneIndices.setBackground(backgroundIndiceTrouve);
		zoneIndices.setFont(fontIndice);
		this.add(zoneIndices, new Integer(2));

		textIndice1 = new JTextArea("Indice Quiz");
		textIndice1.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndices.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice1.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndices.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice1.setForeground(foregroundIntituleIndice);
		textIndice1.setBackground(backgroundIntituleIndice);
		textIndice1.setFont(fontIntituleIndice);
		this.add(textIndice1, new Integer(2));

		zoneIndice1 = new JTextArea("zone indices");
		zoneIndice1.setBounds(zoneCentrale.getX()+paddingWidth, textIndice1.getY()+textIndice1.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		zoneIndice1.setForeground(foregroundIndiceTrouve);
		zoneIndice1.setBackground(backgroundIndiceTrouve);
		zoneIndice1.setFont(fontIndice);
		this.add(zoneIndice1, new Integer(2));

		textIndice2 = new JTextArea("Indice Mots de Passe");
		textIndice2.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndice1.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice2.setForeground(foregroundIntituleIndice);
		textIndice2.setBackground(backgroundIntituleIndice);
		textIndice2.setFont(fontIntituleIndice);
		this.add(textIndice2, new Integer(2));

		zoneIndice2 = new JTextArea("zone indices");
		zoneIndice2.setBounds(zoneCentrale.getX()+paddingWidth, textIndice2.getY()+textIndice1.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		zoneIndice2.setForeground(foregroundIndiceTrouve);
		zoneIndice2.setBackground(backgroundIndiceTrouve);
		zoneIndice2.setFont(fontIndice);
		this.add(zoneIndice2, new Integer(2));

		textIndice3 = new JTextArea("Indice Déchiffrements");
		textIndice3.setBounds(zoneCentrale.getX()+paddingWidth, zoneIndice2.getY()+zoneIndices.getHeight()+paddingHeight, 400, 25);
		textIndice3.setForeground(foregroundIntituleIndice);
		textIndice3.setBackground(backgroundIntituleIndice);
		textIndice3.setFont(fontIntituleIndice);
		this.add(textIndice3, new Integer(2));

		zoneIndice3 = new JTextArea("Indice non trouvé");
		zoneIndice3.setBounds(zoneCentrale.getX()+paddingWidth, textIndice3.getY()+textIndice1.getHeight()+beetweenIntituleAndIndice, zoneCentrale.getWidth()-paddingWidth*2, indiceHeight);
		zoneIndice3.setForeground(foregroundIndicePasTrouve);
		zoneIndice3.setBackground(backgroundIndicePasTrouve);
		zoneIndice3.setFont(fontIndice);
		this.add(zoneIndice3, new Integer(2));

		zoneMotFinal = new JTextField();
		zoneMotFinal.setBounds(zoneCentrale.getX()+100, zoneCentrale.getY()+zoneCentrale.getHeight()+spacingHeight, zoneCentrale.getWidth()-200, 50);
		zoneMotFinal.setForeground(Color.BLACK);
		zoneMotFinal.setBackground(Color.WHITE);
		zoneMotFinal.setFont(fontIndice);
		this.add(zoneMotFinal, new Integer(1));

		boutonValider = new Bouton("Valider", zoneCentrale.getX()+zoneCentrale.getWidth()/2-boutonQuitter.getWidth()/2, boutonQuitter.getY(), boutonQuitter.getWidth(), boutonQuitter.getHeight());
		boutonValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String reponse = zoneMotFinal.getText().toLowerCase();
				// Methode Valider avec comme paramètre la réponse
				System.out.println("Valider : "+reponse);
			}
		});
		this.add(boutonValider, new Integer(1));

	}	
}