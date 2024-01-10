package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Question;
import frontend.JeuQuizGraphic;

import java.util.ArrayList;
import java.util.List;

public class JeuQuiz extends Minijeu {
   JeuQuizGraphic jeuQuizGraphic;
   List<Question> listQuestions;
   private static int nQuestion;

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
    public ArrayList<String> affichageQuestion(int questionIndex){
        List Quiz = new ArrayList();
        Quiz.add(listQuestions.get(questionIndex).getEnonce());
        //Randomiser les reponses

    }


    // SauvegardeRésultat
}
