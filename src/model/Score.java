package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class Score {

    private LongProperty score = new SimpleLongProperty();
        public long getScore() {return score.get();}
        public LongProperty scoreProperty() {return score;}
        public void setScore(long score) {this.score.set(score);}

    public Score(long score) {
        setScore(score);
    }
}
