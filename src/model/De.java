package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class De {
    private static final Random RANDOM_GENERATOR = new Random();

    private IntegerProperty scoreVal = new SimpleIntegerProperty(0);
    public final int getScoreVal(){ return scoreVal.get(); }
    public final void setScoreVal(int val){ scoreVal.set(val); }
    public IntegerProperty scoreValProperty(){ return scoreVal; }


    public int lancer(){
        setScoreVal(RANDOM_GENERATOR.nextInt(7));
        return getScoreVal();
    }
}
