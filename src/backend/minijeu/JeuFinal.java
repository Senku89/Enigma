package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Indice;
import util.Score;

import java.util.List;
import java.util.Random;

import static util.Score.listeScore;

public class JeuFinal extends Minijeu {
    protected List<Indice> listIndices;
    private Indice currentIndice;
    private Score finalScore;

    public JeuFinal(String filePath) {
        listIndices = CSVReader.readCSVIndice(filePath);
        choisirIndiceRandom();
    }

    // Choisir l'indice random
    private void choisirIndiceRandom() {
        if (!listIndices.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(listIndices.size());
            currentIndice = listIndices.get(randomIndex);
        }
    }

    // Valider le mot final
    public boolean validerMotFinal(String motFinal) {
        if (currentIndice != null) {
            String motCorrect = currentIndice.getTxtReponse().toLowerCase();
            boolean reponse = motCorrect.equals(motFinal);
            if(reponse){
                System.out.println("CORRECTO AMIGO"); //TEST A EFFACER APRES
                // Sauvegarder le Résultat si mot correct pour afficher que c'est trouve pour les resultats finaux
                return reponse;
            }
            System.out.println("NO ES CORRECTO AMIGO"); //TEST A EFFACER APRES
            return reponse;
        }
        return false;
    }

    // Calcul seuil pour livrer l'indice dans l'interface
    public boolean ifIndiceTrouveQuiz(int indice, int minScore) {
        // Check if the index is valid before accessing the list
        if (indice >= 0 && indice < listeScore.size()) {
            Score jeuScore = listeScore.get(indice);
            return (jeuScore.getScore() >= minScore);
        } else {
            // Handle the case where the index is out of bounds
            return false;
        }
    }

    public Indice getCurrentIndice() {
        return currentIndice;
    }

    public void setCurrentIndice(Indice currentIndice) {
        this.currentIndice = currentIndice;
    }

    public Score getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Score finalScore) {
        this.finalScore = finalScore;
    }
}
