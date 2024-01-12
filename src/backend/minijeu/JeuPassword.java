package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Password;

import java.util.List;
import java.util.ArrayList;

public class JeuPassword extends Minijeu {
    List<Password> listPasswords;

    // Constructeur pour initialiser le JeuPassword avec les données du fichier CSV
    public JeuPassword(String filePath) {
        listPasswords = CSVReader.readCSVPassword(filePath);
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
    public int getResultat(ArrayList<ArrayList<String>> resultats){
        int scoreTmp = 0, niveau = 1;

        for(ArrayList<String> liste : resultats){
            for(String mdp : liste){
                if(testNiveauPassword(mdp, niveau)){
                    scoreTmp++;
                }
            }
            niveau++;
        }

        this.score = (int)(((double)scoreTmp/listPasswords.size())*100);

        System.out.println(finalscore+"/100");

        // Methode setScore()
    }

}

