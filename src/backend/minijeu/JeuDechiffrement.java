package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Message;

import java.util.List;
import java.util.Random;

public class JeuDechiffrement extends Minijeu{
    public static List<Message> listMessages;
    private static Message currentMessage; // Message aléatoire

    public JeuDechiffrement(String filePath) {
        listMessages = CSVReader.readCSVMessage(filePath);
        choisirMessageRandom(); //message aleatoire
    }

    // Choisir le message à déchiffrer de manière aléatoire
    private void choisirMessageRandom() {
        if (!listMessages.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(listMessages.size());
            currentMessage = listMessages.get(randomIndex);
            System.out.println(currentMessage.getDechiffre());
            //System.out.println(currentMessage.getPathImage());
        }else{
            System.out.println("La liste des Messages a dechiffrer est vide !");
        }
    }

    // Valider déchiffrement (utiliser equals avec les valeurs passes en paramètre)
    public boolean isDechiffCorrect(String decryptedText) {
        if (currentMessage != null) {
            //System.out.println(decryptedText);
            //System.out.println(currentMessage.getDechiffre().toLowerCase());
            String originalText = currentMessage.getDechiffre().toLowerCase();
            return originalText.equals(decryptedText);
        }
        return false;
    }

    // Envoyer le résultat et le stocker sur la classe JeuFinal
    public void checkResultat(String decryptedText) {
        if (isDechiffCorrect(decryptedText)) {
            System.out.println("Dechiffrement correct!");
            // Garder le résultat correct SCORE 100
        } else {
            System.out.println("Dechiffrement incorrect!");
            // Garder le résultat incorrect SCORE 0
        }

        // Après avoir traité le résultat, choisissez un nouveau message au hasard pour le prochain tour
        // choisirMessageRandom();
    }

    // Choisir un nouvel message au hasard pour le prochain tour
    public void nextMessage() {
        choisirMessageRandom();
    }

    public static String showImageCle(){
        return currentMessage.getPathImage();
    }

}