package src;

import java.util.List;

public class TestDonnes {
        public static void TestCSV() {
            String filePath;

            filePath = "/Users/nadir/Documents/Master1/gestionPro/MDP.csv";
            List<Password> instances = CSVReader.readCSVPassword(filePath);

            // Afficher les données
            for (Password instance : instances) {
                System.out.println("mdp: " + instance.getmdp());
                System.out.println("niveau: " + instance.getlvl());
                System.out.println("-----------");
            }
            filePath = "/Users/nadir/Documents/Master1/gestionPro/Q-R-crypto.csv";
            List<Question> instances2 = CSVReader.readCSVQuestion(filePath);

            // Afficher les données
            for (Question instance2 : instances2) {
                System.out.println("enonce " + instance2.getenonce());
                System.out.println("reponse: " + instance2.getreponse());
                System.out.println("-----------");
            }
            filePath = "/Users/nadir/Documents/Master1/gestionPro/decryptage/classeur1.csv";
            List<Message> instances3 = CSVReader.readCSVMessage(filePath);

            // Afficher les données
            for (Message instance3 : instances3) {
                System.out.println("chiffre " + instance3.getChiffre());
                System.out.println("dechiffre: " + instance3.getDechiffre());
                System.out.println("-----------");
            }
            filePath = "/Users/nadir/Documents/Master1/gestionPro/jeufinal.csv";
            List<Indice> instances4 = CSVReader.readCSVIndice(filePath);

            // Afficher les données
            for (Indice instance4 : instances4) {
                System.out.println("reponse = " + instance4.getTxtReponse());
                System.out.println("indice 0 = " + instance4.getTxt0());
                System.out.println("indice 1 = " + instance4.getTxt1());
                System.out.println("indice 2 = " + instance4.getTxt2());
                System.out.println("indice 3 = " + instance4.getTxt3());
                System.out.println("-----------");
            }
        }
    }

