package frontend;

import backend.minijeu.JeuPassword;

import general.Init;
import general.MainController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.ArrayList;

public class JeuMdpGraphic extends MiniJeuGraphic{
	
	private JeuPassword jeuPassword;

	private ZoneTexte zoneMdpFaible, zoneMdpMoyen, zoneMdpFort, zoneTousMdp;
	private ZoneTexte zoneLibelleFaible, zoneLibelleMoyen, zoneLibelleFort, zoneLibelleTousMdp;
	private Bouton boutonValider;
	private ArrayList<JButton> motsDePasseListe;
	private JButton mdpSelectionne;
	private ArrayList<ZoneTexte> zones;
	private int[] zonesHeights;
	private ArrayList<ArrayList<JButton>> tableauResultat;

	private int zoneHeight = 350, spacingWidthSmall = 10, spacingWidthLarge = 50, spacingHeight = 50; 
	private int smallZoneWidth = 150, largeZoneWidth = 370;
	private int libelleTitreHeight = 35, mdpWidth = 140, mdpHeight = 20;
	private int spacingHeightMdp = 20, spacingWidthMdp = 50, marginZoneMdps = 20;
	private int marginZones = 5, paddingZonesHeight = 10; 

	public JeuMdpGraphic(MainController mainController, Fenetre fenetre){
		super(mainController, fenetre);

		jeuPassword = new JeuPassword(Init.mdpcsv);
		// System.out.println("mpg graphic");
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());
		// this.addMouseListener(new SourisListener(this));

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeumdp));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, new Integer(0));

		titre = new Titre("2. Tri des Mots de Passe", 70, 30, 420, 35);
		this.add(titre, new Integer(1));

		this.add(boutonQuitter, new Integer(1));

		this.add(zoneScore, new Integer(1));

		this.add(zoneTimer, new Integer(1));

		this.add(iconeTimer, new Integer(2));

		zoneMdpFaible = new ZoneTexte("", titre.getX(), titre.getY()+titre.getHeight()+spacingHeight, smallZoneWidth, zoneHeight);
		this.add(zoneMdpFaible, new Integer(1));

		zoneLibelleFaible = new ZoneTexte("       Faible", zoneMdpFaible.getX(), zoneMdpFaible.getY(), smallZoneWidth, libelleTitreHeight);
		zoneLibelleFaible.setForeground(Color.WHITE);
		zoneLibelleFaible.setBackground(new Color(255, 130, 130));
		zoneLibelleFaible.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleFaible, new Integer(2));

		zoneMdpMoyen = new ZoneTexte("", zoneMdpFaible.getX()+zoneMdpFaible.getWidth()+spacingWidthSmall, zoneMdpFaible.getY(), smallZoneWidth, zoneHeight);
		this.add(zoneMdpMoyen, new Integer(1));

		zoneLibelleMoyen = new ZoneTexte("       Moyen", zoneMdpMoyen.getX(), zoneMdpMoyen.getY(), smallZoneWidth, libelleTitreHeight);
		zoneLibelleMoyen.setForeground(Color.WHITE);
		zoneLibelleMoyen.setBackground(new Color(250, 205, 100));
		zoneLibelleMoyen.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleMoyen, new Integer(2));

		zoneMdpFort = new ZoneTexte("", zoneMdpMoyen.getX()+zoneMdpMoyen.getWidth()+spacingWidthSmall, zoneMdpMoyen.getY(), smallZoneWidth, zoneHeight);
		this.add(zoneMdpFort, new Integer(1));

		zoneLibelleFort = new ZoneTexte("         Fort", zoneMdpFort.getX(), zoneMdpFort.getY(), smallZoneWidth, libelleTitreHeight);
		zoneLibelleFort.setForeground(Color.WHITE);
		zoneLibelleFort.setBackground(new Color(100, 200, 100));
		zoneLibelleFort.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleFort, new Integer(2));

		zoneTousMdp = new ZoneTexte("", zoneMdpFort.getX()+zoneMdpFort.getWidth()+spacingWidthLarge, zoneMdpFort.getY(), largeZoneWidth, zoneHeight); 
		this.add(zoneTousMdp, new Integer(1));

		zoneLibelleTousMdp = new ZoneTexte("                    Mots de passe", zoneTousMdp.getX(), zoneTousMdp.getY(), largeZoneWidth, libelleTitreHeight);
		zoneLibelleTousMdp.setForeground(Color.WHITE);
		zoneLibelleTousMdp.setBackground(Color.BLACK);
		zoneLibelleTousMdp.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleTousMdp, new Integer(2));

		boutonValider = new Bouton("Valider", zoneMdpMoyen.getX()-5, zoneScore.getY(), zoneMdpMoyen.getWidth()+10, 40);
		boutonValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

				ArrayList<ArrayList<String>> reponses = new ArrayList<>();

				int indice = 0;

				for(ArrayList<JButton> liste : tableauResultat){
					reponses.add(new ArrayList<>());

					for(JButton mdp : liste){
						reponses.get(indice).add(mdp.getText());
					}

					indice++;
				}

				jeuPassword.getResultat(reponses);

				// ##### methode jeuSuivant
			}
		});
		this.add(boutonValider, new Integer(1));

		motsDePasseListe = new ArrayList<>();

		int xTmp = zoneTousMdp.getX()+marginZoneMdps;
		int yTmp = zoneTousMdp.getY()+libelleTitreHeight+spacingHeightMdp;

		int nbMdps = 12;
		int cpt = 0;

		for(String mdp : jeuPassword.getPasswords()){
			
			JButton nouveauMdp = new JButton(mdp);
			nouveauMdp.setBounds(xTmp, yTmp, mdpWidth, mdpHeight);
			nouveauMdp.setForeground(Color.BLACK);
			nouveauMdp.setBackground(Color.WHITE);
			nouveauMdp.setFont(new Font("Helvetica", Font.PLAIN, 15));
			nouveauMdp.addMouseListener(new SourisListener(this, nouveauMdp));

			yTmp += mdpHeight + spacingHeightMdp;

			motsDePasseListe.add(nouveauMdp);

			cpt++;

			if(cpt == 7){
				xTmp += mdpWidth+spacingWidthMdp;
				yTmp = zoneTousMdp.getY()+libelleTitreHeight+spacingHeightMdp;
				cpt = 0;
			}

			this.add(nouveauMdp, new Integer(2));
		}

		zones = new ArrayList<>();
		zones.add(zoneMdpFaible);
		zones.add(zoneMdpMoyen);
		zones.add(zoneMdpFort);

		zonesHeights = new int[3];
		for(int i = 0; i < 3; i++){
			zonesHeights[i] = zones.get(i).getY() + libelleTitreHeight + paddingZonesHeight;
		}

		tableauResultat = new ArrayList<>();
		for(int i =0; i < 3; i++){
			tableauResultat.add(new ArrayList<>());
		}
	}

	public void selectionMdp(JButton mdp){
		this.mdpSelectionne = mdp;
	}

	private int selectionZone(int x, int y){
		int zoneTexteX, zoneTexteY, zoneTexteX2, zoneTexteY2;
		int cpt = 0;
		for(ZoneTexte zone : zones){
			zoneTexteX = zone.getX();
			zoneTexteY = zone.getY();
			zoneTexteX2 = zone.getX()+zone.getWidth();
			zoneTexteY2 = zone.getY()+zone.getHeight();
			if(x >= zoneTexteX && y >= zoneTexteY && x <= zoneTexteX2 && y <= zoneTexteY2){
				return cpt;
			}
			cpt++;
		}
		return -1;
	}

	private void rearrangement(){
		for(int i = 0; i < 3; i++){
			if(tableauResultat.get(i).contains(mdpSelectionne)){
				int indice = tableauResultat.get(i).indexOf(mdpSelectionne);
				tableauResultat.get(i).remove(mdpSelectionne);
				for(int j = indice; j < tableauResultat.get(i).size(); j++){
					JButton mdp = tableauResultat.get(i).get(j);
					mdp.setBounds(mdp.getX(), mdp.getY()-(mdp.getHeight()+paddingZonesHeight), mdp.getWidth(), mdp.getHeight());
				}
				return;
			}
		}
	}

	private int getLastHeight(int indice){
		ArrayList<JButton> listeZone = tableauResultat.get(indice);
		if(listeZone.isEmpty()){
			return zones.get(indice).getY() + libelleTitreHeight + paddingZonesHeight;
		} else {
			return listeZone.get(listeZone.size()-1).getY() + mdpSelectionne.getHeight() + paddingZonesHeight;
		}
	}

	public void deplacerMdp(int x, int y){
		int newX = mdpSelectionne.getX()+x;
		int newY = mdpSelectionne.getY()+y;

		int indiceZone = selectionZone(newX, newY);
		
		if(indiceZone >= 0){
			ZoneTexte zoneSelectionnee = zones.get(indiceZone);

			rearrangement();
			mdpSelectionne.setBounds(zoneSelectionnee.getX()+marginZones, getLastHeight(indiceZone), mdpSelectionne.getWidth(), mdpSelectionne.getHeight());
			tableauResultat.get(indiceZone).add(mdpSelectionne);
			fenetre.repaintFenetre();
		}
	
		mdpSelectionne = null;
	}

	public int getScore(){
		jeuPassword.getScore();
	}
}
