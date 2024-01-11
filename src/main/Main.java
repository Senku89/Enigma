package main;

import general.MainController;

public class Main
{
    /*
    public static void main(String[] args)
    {
        System.out.println("Static method");
        // TestCSV();
        SwingUtilities.invokeLater(() -> {
            Fenetre fenetre = new Fenetre();
            // Initialization aditionnelles ici comme fenetre.setPanelActif(initialPanel);
        });
    }
     */
    /*
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
     */
    public static void main(String[] args){
        MainController JeuEnigma = new MainController();
        JeuEnigma.startMenuPrincipal();
    }
}