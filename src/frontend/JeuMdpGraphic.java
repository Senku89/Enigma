package frontend;

import general.Init;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.util.ArrayList;

public class JeuMdpGraphic extends MiniJeuGraphic{
	
	ZoneTexte zoneMdpFaible, zoneMdpMoyen, zoneMdpFort, zoneTousMdp;
	ZoneTexte zoneLibelleFaible, zoneLibelleMoyen, zoneLibelleFort, zoneLibelleTousMdp;
	Bouton boutonValider;
	ArrayList<JTextArea> motsDePasseListe;

	int zoneHeight = 350, spacingWidthSmall = 10, spacingWidthLarge = 50, spacingHeight = 50; 
	int smallZoneWidth = 150, largeZoneWidth = 370;
	int libelleTitreHeight = 35, mdpWidth = 140, mdpHeight = 20;
	int spacingHeightMdp = 20, spacingWidthMdp = 50, margin = 20;

	JTextArea mdpChoisi;

	public JeuMdpGraphic(Fenetre fenetre){
		super(fenetre);
		// System.out.println("mpg graphic");
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());

		this.addMouseListener(new SourisListener(this));

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
				// Methode Valider
				System.out.println("Valider");
			}
		});
		this.add(boutonValider, new Integer(1));

		motsDePasseListe = new ArrayList<>();

		int xTmp = zoneTousMdp.getX()+margin;
		int yTmp = zoneTousMdp.getY()+libelleTitreHeight+spacingHeightMdp;

		int nbMdps = 12;
		int cpt = 0;

		for(int i = 1; i <= nbMdps; i++){
			
			JTextArea nouveauMdp = new JTextArea("MDP "+i);
			nouveauMdp.setBounds(xTmp, yTmp, mdpWidth, mdpHeight);
			nouveauMdp.setForeground(Color.BLACK);
			nouveauMdp.setBackground(Color.WHITE);
			nouveauMdp.setFont(new Font("Helvetica", Font.PLAIN, 15));

			yTmp += mdpHeight + spacingHeightMdp;

			motsDePasseListe.add(nouveauMdp);

			cpt++;

			if(cpt == 7){
				xTmp += mdpWidth+spacingWidthMdp;
				yTmp = zoneTousMdp.getY()+libelleTitreHeight+spacingHeightMdp;
				cpt = 0;
			}
		}

		for(JTextArea mdp : motsDePasseListe){
			this.add(mdp, new Integer(2));
		}
	}

	public boolean choisirMdp(MouseEvent e){
		for(JTextArea mdp : motsDePasseListe){
			if(e.getX() >= mdp.getX() && e.getY() >= mdp.getY() && e.getX() < mdp.getX()+mdp.getWidth() && e.getY() < mdp.getY() + mdp.getHeight()){
				mdpChoisi = mdp;
				return true;
			}
		}
		
		return false;
	}

	public void deplacerMdp(MouseEvent e){
		mdpChoisi.setBounds(e.getX(), e.getY(), mdpChoisi.getWidth(), mdpChoisi.getHeight());
		fenetre.repaintFenetre();
		mdpChoisi = null;
	}
}