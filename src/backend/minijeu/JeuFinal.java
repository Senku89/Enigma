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

    private Boolean motTrouve = false;

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
            String motCorrect = currentIndice.getTxtReponse();
            boolean reponse = motCorrect.equalsIgnoreCase(motFinal);

            if (reponse) {
                // Sauvegarder le Résultat si mot correct pour afficher que c'est trouvé pour les résultats finaux
                setMotTrouve(true);
            }

            return reponse;
        }

        return false;
    }

    // Calcul seuil pour livrer l'indice dans l'interface
    public boolean ifIndiceTrouve(int indice, int minScore) {
        // Check if the indice is out of bounds
        if (indice >= listeScore.size() || indice < 0) {
            return false;
        }

        Score jeuScore = listeScore.get(indice);

        return jeuScore.getScore() >= minScore;
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

    public Boolean getMotTrouve() {
        return motTrouve;
    }

    public void setMotTrouve(Boolean motTrouve) {
        this.motTrouve = motTrouve;
    }
}
