package backend.donnees;

public class Message {
    private String txtChiffre;
    private String txtDechiffre;

    public Message(String Chiffre , String Dechiffre) {
        this.txtChiffre = Chiffre ;
        this.txtDechiffre = Dechiffre;
    }

    public String getChiffre() {
        return txtChiffre;
    }

    public String getDechiffre() {
            return txtDechiffre;
        }

    // Setters si besoin

    @Override
    public String toString() {
        return "DataInstance{" +
                "chiffrer='" + txtChiffre + '\'' +
                ", dechiffrer='" + txtDechiffre + '\'' +
                '}';
    }
}




