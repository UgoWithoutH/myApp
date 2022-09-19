package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

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
    private Joueur joueurCourant;

    public Partie(int num) {
        int cpt=0;

        while(cpt != num){
            joueurs.add(new Joueur());
            cpt++;
        }

        joueurCourant = joueurs.get(0);
    }



    public List<Joueur> getJoueurs() {
        return Collections.unmodifiableList(joueurs);
    }

    public Joueur getJoueur(int num){
        return joueurs.get(num - 1);
    }

    public void lancer_de(int num){
        if(isGameOver()) {
            return;
        }

        if(num - 1 != joueurs.indexOf(joueurCourant)) return;

        if(!joueurCourant.lancer_de()){
            setGameOver(true);
            return;
        }

        changeCurrentPlayer();
    }

    private void changeCurrentPlayer(){
            int indexCurrentPlayer = joueurs.indexOf(joueurCourant);

            if(indexCurrentPlayer == joueurs.size() - 1){
                joueurCourant = joueurs.get(0);
            }else{
                joueurCourant = joueurs.get(indexCurrentPlayer+1);
            }
    }

    public void restart(){
        for(Joueur joueur : joueurs){
            joueur.setScore(0);
        }

        joueurCourant = joueurs.get(0);

        setGameOver(false);
    }
}
