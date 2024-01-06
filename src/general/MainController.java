package general;

import frontend.*;

public class MainController{
	
	public static void main(String[] args){
		Fenetre f = new Fenetre();

		MenuPrincipalGraphic mpg = new MenuPrincipalGraphic(f);

		JeuQuizGraphic jqg = new JeuQuizGraphic(f);

		JeuMdpGraphic jmg = new JeuMdpGraphic(f);

		JeuDecryptGraphic jdg = new JeuDecryptGraphic(f);

		JeuFinalGraphic jfg = new JeuFinalGraphic(f);

		ResultatsFinauxGraphic rfg = new ResultatsFinauxGraphic(f);

		f.setPanelActif(mpg);
	}
}