package backend.donnees;

import general.Init;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVReader {
    static String errCSV = "Erreur lecture fichier CSV";
    static String errNBColonnes = "La ligne ne contient pas le bon nombre de colonnes: ";
    private static final Logger logger = Logger.getLogger(CSVReader.class.getName());
    private CSVReader(){}
    public static List<Password> readCSVPassword(String filePath) {

        List<Password> listPasswords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split le csv en colonnes
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes
                if (ligne.length >= 2) {
                    String mot = ligne[0].trim();
                    int level = Integer.parseInt(ligne[1].trim());

                    // Create a new DataInstance and store the columns
                    Password passwords = new Password(mot, level);
                    listPasswords.add(passwords);

                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    logger.severe(errNBColonnes+line);
                }
            }

        }
        catch (IOException e) {
            logger.log(Level.SEVERE, errCSV, e);
        }

        return listPasswords;
    }
    public static List<Question> readCSVQuestion(String filePath) {
        List<Question> listQuestion = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Split le csv en colonnes
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes
                if (ligne.length >= 5) {
                    String enonce = ligne[0].trim();
                    ArrayList<String> question = new ArrayList<>();
                    question.add(ligne[4].trim());
                    question.add(ligne[1].trim());
                    question.add(ligne[2].trim());
                    question.add(ligne[3].trim());
                    // Create a new DataInstance and store the columns
                    Question question1 = new Question(enonce, question);
                    listQuestion.add(question1);
                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    logger.severe(errNBColonnes+line);
                }
            }

        }
        catch (IOException e) {
            logger.log(Level.SEVERE, errCSV, e);
        }

        return listQuestion;
    }
    public static List<Message> readCSVMessage(String filePath) {
        List<Message> listMessage = new ArrayList<>();
        String line;
        boolean firstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            int indiceCle = 0;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Split le csv en colonnes
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes
                if (ligne.length >= 2) {

                    indiceCle++;

                    String dechiffre = ligne[0].trim();
                    String image = Init.getCle(indiceCle);

                    /*System.out.println(dechiffre);
                    System.out.println(image);*/

                    // Create a new DataInstance and store the columns
                    Message message = new Message(dechiffre, image);
                    listMessage.add(message);

                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    logger.severe(errNBColonnes+line);
                }
            }

        }
        catch (IOException e) {
            logger.log(Level.SEVERE, errCSV, e);
        }

        return listMessage;
    }
    public static List<Indice> readCSVIndice(String filePath) {
        List<Indice> listIndice = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Split le csv en colonnes
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes
                if (ligne.length >= 5) {
                    String reponse = ligne[4].trim();
                    String indice0 = ligne[0].trim();
                    String indice1 = ligne[1].trim();
                    String indice2 = ligne[2].trim();
                    String indice3 = ligne[3].trim();

                    // Creation d'une nouvelle DataInstance pour garder les colonnes
                    Indice indice = new Indice(reponse, indice0,indice1,indice2,indice3);
                    listIndice.add(indice);
                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    logger.severe(errNBColonnes+line);
                }
            }

        }
        catch (IOException e) {
            logger.log(Level.SEVERE, errCSV, e);
        }
        return listIndice;
    }
}