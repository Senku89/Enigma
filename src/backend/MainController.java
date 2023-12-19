package backend;

import backend.minijeu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainController {
    private List<Minijeu> listeMinijeux = new ArrayList<Minijeu>();
    Logger logger = Logger.getLogger(getClass().getName());

    // Constructeur
    public MainController() {
        try {
            listeMinijeux.add(new JeuQuiz("resources/Q-R-crypto.csv"));
            //listeMinijeux.add(new JeuPassword("resources/MDP.csv")); FINIR
            //listeMinijeux.add(new JeuDechiffrement("resources/classeur1.csv")); FINIR
            //listeMinijeux.add(new JeuFinal("resources/jeufinal.csv")); FINIR
        }catch(Exception e){
            logger.severe("Error sur l'initialisation du Minijeu : " + e.getMessage());
        }
    }

    public List<Minijeu> getlisteMinijeux() {
        return listeMinijeux;
    }

    public void setlisteMinijeux(List<Minijeu> listeMinijeux) {
        listeMinijeux = listeMinijeux;
    }
}
