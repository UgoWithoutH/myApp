package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;
import java.util.Random;

public class Joueur {

    private static final Random RANDOM_GENERATOR = new Random();
    public final String DEFAULT_NAME = "Joueur";
    private IntegerProperty score = new SimpleIntegerProperty(0);
        public final int getScore(){ return score.get(); }
        public final void setScore(int val){ score.set(val); }
        public IntegerProperty scoreProperty(){ return score; }

    private StringProperty name = new SimpleStringProperty();
        public String getName() {return name.get();}
        public StringProperty nameProperty() {return name;}
        public void setName(String name) {this.name.set(name);}

    public Joueur(int num){
        setName(DEFAULT_NAME+num);
    }

    public boolean lancer_de(){
        setScore(RANDOM_GENERATOR.nextInt(7));
        return getScore() != Partie.GAME_OVER_CODE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return getName().equals(joueur.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
