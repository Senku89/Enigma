package util;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private int nbscore;
    public static List<Score> listeScore = new ArrayList<>();

    public Score() {
        this.nbscore = 0;
    }

    public int getScore() {
        return nbscore;
    }

    public void setScore(int score) {
        nbscore = score;
    }

    public void increaseScore(int points) {
        nbscore += points;
    }

    public void resetScore() {
        nbscore = 0;
    }

    @Override
    public String toString() {
        return "Score{" +
                "nbscore=" + nbscore +
                '}';
    }
}
