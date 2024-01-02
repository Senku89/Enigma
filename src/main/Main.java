package src.main;

import frontend.Fenetre;

import javax.swing.*;

import static src.backend.donnees.TestDonnees.TestCSV;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Static method");
        // TestCSV();
        SwingUtilities.invokeLater(() -> {
            Fenetre fenetre = new Fenetre();
            // Initialization aditionnelles ici comme fenetre.setPanelActif(initialPanel);
        });
    }
}