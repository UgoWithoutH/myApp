package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Joueur {
    private IntegerProperty score = new SimpleIntegerProperty(0);
        public final int getScore(){ return score.get(); }
        public final void setScore(int val){ score.set(val); }
        public IntegerProperty scoreProperty(){ return score; }

    private static final Random RANDOM_GENERATOR = new Random();

    public boolean lancer_de(){
        setScore(RANDOM_GENERATOR.nextInt(7));
        return getScore() != Partie.GAME_OVER_CODE;
    }
}
