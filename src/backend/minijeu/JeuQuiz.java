package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Question;
import frontend.JeuQuizGraphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuQuiz extends Minijeu {
    // Si besoin : private JeuQuizGraphic jeuQuizGraphic;
    public static List<Question> listQuestions;
    private int nQuestion;

    // Constructeur pour initialiser le JeuQuiz avec les données dans le fichier CSV
    public JeuQuiz(String filePath) {
        listQuestions = CSVReader.readCSVQuestion(filePath);
        nQuestion = 0;
    }

    // Methode pour verifier la réponse si est correcte
    public boolean checkReponse(String reponse, int questionIndex) {
        // S'assurer que la liste de questions n'est pas nulle et que l'indice est valide
        if (listQuestions == null || questionIndex < 0 || questionIndex >= listQuestions.size()) {
            System.err.println("Index de la question invalide");
            return false;
        }

        // Obtenir la réponse correcte qui est la dernière
        String reponseCorrecte = listQuestions.get(questionIndex).reponse.get(0);

        // S'assurer que la réponse correcte n'est pas nulle
        if (reponseCorrecte == null) {
            System.err.println("Réponse correcte non disponible pour la question spécifiée");
            return false;
        }

        // Comparer la réponse avec la réponse correcte en ignorant la casse
        return reponse.equalsIgnoreCase(reponseCorrecte);
    }

    public int gererReponse(String reponse, int questionIndex) {
        //questionIndex++;
        if (checkReponse(reponse, questionIndex)){
            System.out.println("Reponse Correcte");
        }else
            System.out.println("Reponse Incorrecte");
        return questionIndex;
    }

    // Envoyer les questions à afficher
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

        // Créer une liste contenant l'énoncé et les réponses randomisées
        List<String> quiz = new ArrayList<>();
        quiz.addAll(reponses);
        // Randomiser l'ordre des réponses
        Collections.shuffle(quiz);
        // Ajouter l'énoncé au début de la liste
        quiz.add(0, enonce);

        // Retourner la liste complète
        return quiz;
    }

    // SauvegardeRésultat

    public int getNQuestion() {
        return nQuestion;
    }
    public void setNQuestion(int nQuestion) {
        this.nQuestion = nQuestion;
    }
}
