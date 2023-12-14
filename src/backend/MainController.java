package backend;

import backend.minijeu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainController {
    private List<Minijeu> listeMinijeux = new ArrayList<Minijeu>();
    Logger logger = Logger.getLogger(getClass().getName());

    public MainController() {
        try {
            listeMinijeux.add(new JeuQuiz());
            listeMinijeux.add(new JeuPassword());
            listeMinijeux.add(new JeuDechiffrement());
            listeMinijeux.add(new JeuFinal());
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
