package backend.donnees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Password> readCSVPassword(String filePath) {
        List<Password> listPasswords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the CSV line into columns
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes (dans cet exemple, 3 colonnes)
                if (ligne.length >= 2) {
                    String mot = ligne[0].trim();
                    int level = Integer.parseInt(ligne[1].trim());

                    // Create a new DataInstance and store the columns
                    Password passwords = new Password(mot, level);
                    listPasswords.add(passwords);
                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    System.err.println("La ligne ne contient pas le bon nombre de colonnes: " + line);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return listPasswords;
    }
    public static List<Question> readCSVQuestion(String filePath) {
        List<Question> listQuestion = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the CSV line into columns
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes (dans cet exemple, 3 colonnes)
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
                    System.err.println("La ligne ne contient pas le bon nombre de colonnes: " + line);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return listQuestion;
    }
    public static List<Message> readCSVMessage(String filePath) {
        List<Message> listMessage = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the CSV line into columns
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes (dans cet exemple, 3 colonnes)
                if (ligne.length >= 2) {
                    String chiffrer = ligne[1].trim();
                    String dechiffrer = ligne[0].trim();

                    // Create a new DataInstance and store the columns
                    Message message = new Message(chiffrer, dechiffrer);
                    listMessage.add(message);
                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    System.err.println("La ligne ne contient pas le bon nombre de colonnes: " + line);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return listMessage;
    }
    public static List<Indice> readCSVIndice(String filePath) {
        List<Indice> listIndice = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the CSV line into columns
                String[] ligne = line.split(";");

                // Vérifier si la ligne a le bon nombre de colonnes (dans cet exemple, 3 colonnes)
                if (ligne.length >= 5) {
                    String reponse = ligne[4].trim();
                    String indice0 = ligne[0].trim();
                    String indice1 = ligne[1].trim();
                    String indice2 = ligne[2].trim();
                    String indice3 = ligne[3].trim();

                    // Create a new DataInstance and store the columns
                    Indice indice = new Indice(reponse, indice0,indice1,indice2,indice3);
                    listIndice.add(indice);
                } else {
                    // Gérer le cas où la ligne n'a pas le bon nombre de colonnes
                    System.err.println("La ligne ne contient pas le bon nombre de colonnes: " + line);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return listIndice;
    }
}



