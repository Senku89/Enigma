package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Indice;

import java.util.List;
import java.util.Random;

public class JeuFinal extends Minijeu {
    List<Indice> listIndices;
    private Indice currentIndice;

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
            return motCorrect.equals(motFinal);
        }
        return false;
    }

    // SauvegardeRésultat

    // Choisir un nouvel indice au hasard pour le prochain tour
    public void nextIndice() {
        choisirIndiceRandom();
    }

}
