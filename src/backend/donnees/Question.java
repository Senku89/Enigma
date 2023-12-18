package src.backend.donnees;


import java.util.ArrayList;
import java.util.List;
public class Question {

    private String enonce;
    private ArrayList<String> reponse;

    public Question(String enonce, ArrayList<String> reponse) {
        this.enonce = enonce;
        this.reponse = reponse; // revoir
    }

    public String getenonce() {
        return enonce;
    }

    public ArrayList<String> getreponse() {
        return reponse;
    }
    // Vous pouvez ajouter d'autres méthodes getters au besoin

    @Override
    public String toString() {
        return "DataInstance{" +
                "password='" + enonce + '\'' +
                ", lvl='" + reponse + '\'' +
                '}';
    }
}
