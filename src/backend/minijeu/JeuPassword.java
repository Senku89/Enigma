package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Password;

import java.util.List;

public class JeuPassword extends Minijeu {
    List<Password> listPasswords;

    // Constructeur pour initialiser le JeuPassword avec les données du fichier CSV
    public JeuPassword(String filePath) {
        listPasswords = CSVReader.readCSVPassword(filePath);
    }

    // Methode pour test si le password a le bon niveau
    public boolean testNiveauPassword(String pLevel, int pNiveau) {
        for (Password password : listPasswords) {
            // Assuming case-sensitive comparison for passwords
            if (password.getmdp().equals(pLevel) && password.getlvl() == pNiveau) {
                return true; // Password et son niveau correctes
            }
        }
        return false; // Password et son niveau incorrectes
    }

    // SauvegardeRésultat
}
