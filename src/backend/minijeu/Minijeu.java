package backend.minijeu;

import util.Score;

public class Minijeu {

    protected Score score = new Score();

    public int getScore(){
        return score.getScore();
    }

    public void setScore(int score){
        this.score.setScore(score);
    }

}
