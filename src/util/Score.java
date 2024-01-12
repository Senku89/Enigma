package util;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private int nbscore;
    private static List listeScore = new ArrayList<Score>();

    public Score() {
        this.nbscore = 0;
    }

    public int getScore() {
        return nbscore;
    }

    public int setScore(int score) {
        return score;
    }

    public void increaseScore(int points) {
        nbscore += points;
    }

    public void resetScore() {
        nbscore = 0;
    }
}
