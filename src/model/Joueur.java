package model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class Joueur {
    public final String DEFAULT_NAME = "Joueur";
    private IntegerProperty score = new SimpleIntegerProperty(0);
        public final int getScore(){ return score.get(); }
        public final void setScore(int val){ score.set(val); }
        public IntegerProperty scoreProperty(){ return score; }

    private StringProperty name = new SimpleStringProperty();
        public String getName() {return name.get();}
        public StringProperty nameProperty() {return name;}
        public void setName(String name) {this.name.set(name);}
    private ObservableList<Score> observableScores = FXCollections.observableArrayList();
    private ListProperty<Score> scores = new SimpleListProperty<>(observableScores);
        public ObservableList<Score> getScores() {return scores.get();}
        public ListProperty<Score> scoresProperty() {return scores;}
        public void setScores(ObservableList<Score> scores) {this.scores.set(scores);}

    private De de = new De();

    public Joueur(int num){
        setName(DEFAULT_NAME+num);
    }

    public boolean lancer_de(){
        setScore(de.lancer() + getScore());
        return de.getScoreVal() != Partie.GAME_OVER_CODE;
    }

    public De getDe() {
        return de;
    }

    public void ajouterScore(long valScore){
        observableScores.add(new Score(valScore));
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
