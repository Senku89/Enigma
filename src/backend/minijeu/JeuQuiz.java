package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Question;

import java.util.List;

public class JeuQuiz extends Minijeu {
   List<Question> ListeQuestions;

    // Constructeur pour initialiser le JeuQuiz avec les données dans le fichier CSV
    public JeuQuiz(String filePath) {
        ListeQuestions = CSVReader.readCSVQuestion(filePath);
    }

    // Methode pour verifier la reponse si est correcte
    public boolean checkReponse(String reponse, int questionIndex) {
        // S'assurer qu'on est avec la bonne indice
        if (questionIndex < 0 || questionIndex >= ListeQuestions.size()) {
            System.err.println("Index de la question invalide");
            return false;
        }

        // Obtenir la reponse correcte qui est la derniere
        String reponseCorrecte = ListeQuestions.get(questionIndex).getReponse().get(3);

        // Comparer la bonne reponse avec celui passée en parametre (comparaison case-sensitive)
        return reponse.equals(reponseCorrecte);
    }

}
