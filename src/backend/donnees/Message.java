package backend.donnees;

public class Message {
    private String dechiffre;
    private String pathImage;

    public Message(String dechiffre, String image) {
        this.dechiffre = dechiffre;
        this.pathImage = image;
    }

    public String getDechiffre() {
        return dechiffre;
    }

    public String getPathImage() {
            return pathImage;
        }

    // Getter et Setters si besoin

    @Override
    public String toString() {
        return "DataInstance{" +
                "chiffrer='" + dechiffre + '\'' +
                ", pathImage='" + pathImage + '\'' +
                '}';
    }
}




