package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partie {

    public static final int GAME_OVER_CODE = 1;

    private BooleanProperty gameOver = new SimpleBooleanProperty(false);
    public final boolean isGameOver() { return gameOver.get(); }
    public final void setGameOver(boolean val){ gameOver.set(val); }
    public final BooleanProperty gameOverProperty(){ return gameOver; }

    private List<Joueur> joueurs = new ArrayList<>();
    private ObjectProperty<Joueur> joueurCourant = new SimpleObjectProperty();
        public Joueur getJoueurCourant() {return joueurCourant.get();}
        public ObjectProperty<Joueur> joueurCourantProperty() {return joueurCourant;}
        public void setJoueurCourant(Joueur joueurCourant) {this.joueurCourant.set(joueurCourant);}

    public Partie(int num) {
        int cpt=0;

        while(cpt != num){
            joueurs.add(new Joueur(cpt+1));
            cpt++;
        }

        setJoueurCourant(joueurs.get(0));
    }



    public List<Joueur> getJoueurs() {
        return Collections.unmodifiableList(joueurs);
    }

    public Joueur getJoueur(int num){
        return joueurs.get(num - 1);
    }

    public void lancer_de(){
        if(isGameOver()) {
            return;
        }

        if(!getJoueurCourant().lancer_de()){
            setGameOver(true);
            return;
        }

        changeCurrentPlayer();
    }

    private void changeCurrentPlayer(){
            int indexCurrentPlayer = joueurs.indexOf(getJoueurCourant());

            if(indexCurrentPlayer == joueurs.size() - 1){
                setJoueurCourant(joueurs.get(0));
            }else{
                setJoueurCourant(joueurs.get(indexCurrentPlayer+1));
            }
    }

    public void restart(){
        for(Joueur joueur : joueurs){
            joueur.setScore(0);
        }
        setJoueurCourant(joueurs.get(0));
        setGameOver(false);
    }
}
