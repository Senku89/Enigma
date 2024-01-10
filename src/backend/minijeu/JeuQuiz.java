package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Question;
import frontend.JeuQuizGraphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuQuiz extends Minijeu {
   JeuQuizGraphic jeuQuizGraphic;
   List<Question> listQuestions;
   int nQuestion;

    // Constructeur pour initialiser le JeuQuiz avec les données dans le fichier CSV
    public JeuQuiz(String filePath) {
        listQuestions = CSVReader.readCSVQuestion(filePath);
        nQuestion = 0;
    }

    // Methode pour verifier la réponse si est correcte
    public boolean checkReponse(String reponse, int questionIndex) {
        // S'assurer qu'on est avec la bonne indice
        if (questionIndex < 0 || questionIndex >= listQuestions.size()) {
            System.err.println("Index de la question invalide");
            return false;
        }

        // Obtenir la réponse correcte qui est la dernière
        String reponseCorrecte = listQuestions.get(questionIndex).getReponse().get(4);

        // Comparer la bonne réponse avec celui passe en paramètre (comparaison case-sensitive)
        return reponse.equals(reponseCorrecte);
    }

    // Envoyer les questions a afficher
    public List<String> affichageQuestion(int questionIndex) {
        // S'assurer qu'on est avec le bon indice
        if (questionIndex < 0 || questionIndex >= listQuestions.size()) {
            System.err.println("Index de la question invalide");
            return Collections.emptyList(); // Retourner une liste vide en cas d'erreur
        }

        // Obtenir la question actuelle
        Question question = listQuestions.get(questionIndex);

        // Obtenir l'énoncé de la question
        String enonce = question.getEnonce();

        // Obtenir les réponses de la question
        List<String> reponses = new ArrayList<>(question.getReponse());

        // Randomiser l'ordre des réponses
        Collections.shuffle(reponses);

        // Créer une liste contenant l'énoncé et les réponses randomisées
        List<String> quiz = new ArrayList<>();
        quiz.add(enonce);
        quiz.addAll(reponses);

        // Print the content of the quiz ArrayList
        for (String element : quiz) {
            System.out.println(element);
        }

        // Retourner la liste complète
        return quiz;
    }

    // SauvegardeRésultat
}
