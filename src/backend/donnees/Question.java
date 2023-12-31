package backend.donnees;

import java.util.ArrayList;
import java.util.List;
public class Question {
    private String enonce;
    private ArrayList<String> reponse;

    public Question(String enonce, ArrayList<String> reponse) {
        this.enonce = enonce;
        this.reponse = reponse; // revoir
    }

    public String getEnonce() {
        return enonce;
    }

    public ArrayList<String> getReponse() {
        return reponse;
    }

    // Setters si besoin

    @Override
    public String toString() {
        return "DataInstance{" +
                "password='" + enonce + '\'' +
                ", lvl='" + reponse + '\'' +
                '}';
    }
}
