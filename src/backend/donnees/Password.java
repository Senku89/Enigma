package src.backend.donnees;


public class Password {

    private String mdp;
    private int lvl;

    public Password(String mdp, int lvl) {
        this.mdp = mdp;
        this.lvl = lvl;
    }

    public String getmdp() {
        return mdp;
    }

    public int getlvl() {
        return lvl;
    }


    // Vous pouvez ajouter d'autres méthodes getters au besoin

    @Override
    public String toString() {
        return "DataInstance{" +
                "password='" + mdp + '\'' +
                ", lvl='" + lvl + '\'' +
                '}';
    }
}


