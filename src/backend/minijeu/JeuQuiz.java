package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Question;

import java.util.List;

public class JeuQuiz extends Minijeu {
   List<Question> listQuestions;

    // Constructeur pour initialiser le JeuQuiz avec les données dans le fichier CSV
    public JeuQuiz(String filePath) {
        listQuestions = CSVReader.readCSVQuestion(filePath);
    }

    // Methode pour verifier la réponse si est correcte
    public boolean checkReponse(String reponse, int questionIndex) {
        // S'assurer qu'on est avec la bonne indice
        if (questionIndex < 0 || questionIndex >= listQuestions.size()) {
            System.err.println("Index de la question invalide");
            return false;
        }

        // Obtenir la réponse correcte qui est la dernière
        String reponseCorrecte = listQuestions.get(questionIndex).getReponse().get(3);

        // Comparer la bonne réponse avec celui passe en paramètre (comparaison case-sensitive)
        return reponse.equals(reponseCorrecte);
    }

    // SauvegardeRésultat
}
