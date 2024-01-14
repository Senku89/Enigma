package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Message;
import util.Score;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import static util.Score.listeScore;

public class JeuDechiffrement extends Minijeu {
    public static List<Message> listMessages;
    private static Message currentMessage;
    private int sizeListMess;

    public JeuDechiffrement(String filePath) {
        listMessages = CSVReader.readCSVMessage(filePath);
        sizeListMess = listMessages.size();
        choisirMessageRandom(); // Message aléatoire au debut
        score.setScore(0);
    }

    // Choisir le message à déchiffrer de manière aléatoire
    private void choisirMessageRandom() {
        if (!listMessages.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(listMessages.size());
            currentMessage = listMessages.get(randomIndex);
            //System.out.println(currentMessage.getDechiffre()); // A retirer apres
            //System.out.println(currentMessage.getPathImage()); // A retirer apres
            listMessages.remove(randomIndex);
        }else{
            currentMessage = null;

                //Calcul score sur 100
                int calcul = (int) (( ((double) score.getScore()) / getSizeListMess()) * 100);
                setScore(calcul);

            listeScore.add(score); // Indice 2 Pour jeuDechiffrement sur la listeScore

            for (Score score : listeScore) {
                System.out.println("Lets see: "+score.toString()); //A virer apres
            }
            System.out.println("Fin jeu !"); // a virer apres
        }
    }

    // Valider déchiffrement (utiliser equals avec les valeurs passes en paramètre)
    public boolean isDechiffCorrect(String decryptedText) {
        if (currentMessage != null) {
            //System.out.println(decryptedText); // A retirer apres
            //System.out.println(currentMessage.getDechiffre().toLowerCase()); // A retirer apres
            String originalText = currentMessage.getDechiffre().toLowerCase();
            return originalText.equals(decryptedText);
        }
        return false;
    }

    // Envoyer le résultat et le stocker sur la classe JeuFinal
    public void checkResultat(String decryptedText) {
        if (isDechiffCorrect(decryptedText)) {
            System.out.println("Dechiffrement correct!");
            score.setScore(score.getScore()+1);
        } else {
            System.out.println("Dechiffrement incorrect!");
            // Résultat incorrect SCORE 0
        }
    }

    // Choisir un nouvel message au hasard pour le prochain tour
    public void nextMessage() {
        choisirMessageRandom();
    }

    public static String showImageCle(){
        if(currentMessage == null){
            return "";
        }
        return currentMessage.getPathImage();
    }

    public int getSizeListMess() {
        return sizeListMess;
    }

    public void setSizeListMess(int sizeListMess) {
        this.sizeListMess = sizeListMess;
    }
}