package backend.minijeu;

import backend.donnees.CSVReader;
import backend.donnees.Message;

import java.util.List;
import java.util.Random;

public class JeuDechiffrement extends Minijeu{
    List<Message> listMessages;
    private Message currentMessage; // Message aléatoire

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
        }
    }

    // Valider déchiffrement (utiliser equals avec les valeurs passes en paramètre)
    public boolean validerDechiffrement(String decryptedText) {
        if (currentMessage != null) {
            String originalText = currentMessage.getDechiffre();
            return originalText.equals(decryptedText);
        }
        return false;
    }

    // Envoyer le résultat et le stocker sur la classe JeuFinal
    public void sauvegardeResultat(boolean isDechiffCorrect) {
        if (isDechiffCorrect) {
            System.out.println("Decryption is correct!");
            // Garder le résultat correct SCORE 100
        } else {
            System.out.println("Decryption is incorrect!");
            // Garder le résultat incorrect SCORE 0
        }

        // Après avoir traité le résultat, choisissez un nouveau message au hasard pour le prochain tour
        // choisirMessageRandom();
    }

    // Choisir un nouvel message au hasard pour le prochain tour
    public void nextMessage() {
        choisirMessageRandom();
    }

}