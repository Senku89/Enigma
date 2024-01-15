package frontend;

import backend.minijeu.JeuPassword;

import general.Init;
import general.MainController;

import java.awt.Color;
import java.awt.Font;

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
	private int libelleTitreHeight = 35, mdpWidth = 140, mdpHeight = 20, fontMdp = 10;
	private int spacingHeightMdp = 20, spacingWidthMdp = 50, marginZoneMdps = 20;
	private int marginZones = 5, paddingZonesHeight = 10; 

	public JeuMdpGraphic(MainController mainController, Fenetre fenetre){
		super(mainController, fenetre);

		jeuPassword = new JeuPassword(Init.mdpcsv);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		setupGraphic();
	}

	@Override
	public void setupGraphic(){
		super.setupGraphic();

		this.remove(zoneScore);

		bgImage = new JLabel(new ImageIcon(Init.imagefondjeumdp));
		bgImage.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.add(bgImage, Integer.valueOf(0));

		titre = new Titre("2. Tri des Mots de Passe", 70, 30, 420, 35);
		this.add(titre, Integer.valueOf(1));

		zoneMdpFaible = new ZoneTexte("", titre.getX(), titre.getY()+titre.getHeight()+spacingHeight, smallZoneWidth, zoneHeight);
		this.add(zoneMdpFaible, Integer.valueOf(1));

		zoneLibelleFaible = new ZoneTexte("       Faible", zoneMdpFaible.getX(), zoneMdpFaible.getY(), smallZoneWidth, libelleTitreHeight);
		zoneLibelleFaible.setForeground(Color.WHITE);
		zoneLibelleFaible.setBackground(new Color(255, 130, 130));
		zoneLibelleFaible.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleFaible, Integer.valueOf(2));

		zoneMdpMoyen = new ZoneTexte("", zoneMdpFaible.getX()+zoneMdpFaible.getWidth()+spacingWidthSmall, zoneMdpFaible.getY(), smallZoneWidth, zoneHeight);
		this.add(zoneMdpMoyen, Integer.valueOf(1));

		zoneLibelleMoyen = new ZoneTexte("       Moyen", zoneMdpMoyen.getX(), zoneMdpMoyen.getY(), smallZoneWidth, libelleTitreHeight);
		zoneLibelleMoyen.setForeground(Color.WHITE);
		zoneLibelleMoyen.setBackground(new Color(250, 205, 100));
		zoneLibelleMoyen.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleMoyen, Integer.valueOf(2));

		zoneMdpFort = new ZoneTexte("", zoneMdpMoyen.getX()+zoneMdpMoyen.getWidth()+spacingWidthSmall, zoneMdpMoyen.getY(), smallZoneWidth, zoneHeight);
		this.add(zoneMdpFort, Integer.valueOf(1));

		zoneLibelleFort = new ZoneTexte("         Fort", zoneMdpFort.getX(), zoneMdpFort.getY(), smallZoneWidth, libelleTitreHeight);
		zoneLibelleFort.setForeground(Color.WHITE);
		zoneLibelleFort.setBackground(new Color(100, 200, 100));
		zoneLibelleFort.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleFort, Integer.valueOf(2));

		zoneTousMdp = new ZoneTexte("", zoneMdpFort.getX()+zoneMdpFort.getWidth()+spacingWidthLarge, zoneMdpFort.getY(), largeZoneWidth, zoneHeight); 
		this.add(zoneTousMdp, Integer.valueOf(1));

		zoneLibelleTousMdp = new ZoneTexte("                    Mots de passe", zoneTousMdp.getX(), zoneTousMdp.getY(), largeZoneWidth, libelleTitreHeight);
		zoneLibelleTousMdp.setForeground(Color.WHITE);
		zoneLibelleTousMdp.setBackground(Color.BLACK);
		zoneLibelleTousMdp.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.add(zoneLibelleTousMdp, Integer.valueOf(2));

		boutonValider = new Bouton("Valider", zoneMdpMoyen.getX()-5, zoneScore.getY(), zoneMdpMoyen.getWidth()+10, 40);
		boutonValider.addActionListener(e -> {

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

            // jeuSuivant
            mainController.startJeuDecrypt();
        });
		this.add(boutonValider, Integer.valueOf(1));

		motsDePasseListe = new ArrayList<>();

		int xTmp = zoneTousMdp.getX()+marginZoneMdps;
		int yTmp = zoneTousMdp.getY()+libelleTitreHeight+spacingHeightMdp;

		int cpt = 0;

		for(String mdp : jeuPassword.getPasswords()){
			
			JButton nouveauMdp = new JButton(mdp);
			nouveauMdp.setBounds(xTmp, yTmp, mdpWidth, mdpHeight);
			nouveauMdp.setForeground(Color.BLACK);
			nouveauMdp.setBackground(Color.WHITE);
			nouveauMdp.setFont(new Font("Helvetica", Font.PLAIN, fontMdp));
			nouveauMdp.addMouseListener(new SourisListener(this, nouveauMdp));

			yTmp += mdpHeight + spacingHeightMdp;

			motsDePasseListe.add(nouveauMdp);

			cpt++;

			if(cpt == 7){
				xTmp += mdpWidth+spacingWidthMdp;
				yTmp = zoneTousMdp.getY()+libelleTitreHeight+spacingHeightMdp;
				cpt = 0;
			}

			this.add(nouveauMdp, Integer.valueOf(2));
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
		return jeuPassword.getScore();
	}
}
