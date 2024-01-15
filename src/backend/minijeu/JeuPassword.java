package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Password;
import util.Score;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static util.Score.listeScore;

public class JeuPassword extends Minijeu {
    List<Password> listPasswords;

    // Constructeur pour initialiser le JeuPassword avec les données du fichier CSV
    public JeuPassword(String filePath) {
        listPasswords = CSVReader.readCSVPassword(filePath);
        // Avoir la liste des Passwords randomise
        Collections.shuffle(listPasswords);
    }
    // Methode pour test si le password a le bon niveau
    public boolean testNiveauPassword(String mdp, int pNiveau) {
        for (Password password : listPasswords) {
            // Assuming case-sensitive comparison for passwords
            if (password.getmdp().equals(mdp) && password.getlvl() == pNiveau) {
                return true; // Password et son niveau correctes
            }
        }
        return false; // Password et son niveau incorrects
    }

    public List<String> getPasswords(){
        List<String> listeMdp = new ArrayList<>();

        for(Password mdp : listPasswords){
            listeMdp.add(mdp.getmdp());
        }

        return listeMdp;
    }

    // SauvegardeRésultat
    public void getResultat(ArrayList<ArrayList<String>> resultats){
        int scoreTmp = 0, niveau = 1;

        for(ArrayList<String> liste : resultats){
            for(String mdp : liste){
                if(testNiveauPassword(mdp, niveau)){
                    scoreTmp++;
                }
            }
            niveau++;
        }

        int calcul = (int)(((double)scoreTmp/listPasswords.size())*100);
        // Methode setScore()
        this.score.setScore(calcul);

        // Ajout score sur la liste de score
        listeScore.add(score); // Indice 1 Pour jeuPassword sur la listeScore

    }

}

