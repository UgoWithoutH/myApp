package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.converter.NumberStringConverter;
import model.Partie;

public class FenetrePrincipale {

    @FXML
    private Label scoreValueJ1;
    @FXML
    private Label scoreValueJ2;
    @FXML
    private Button buttonj1;
    @FXML
    private Button buttonj2;
    @FXML
    private Button restartButton;

    private Partie partie;

    public void initialize(){
        partie = new Partie(2);
        scoreValueJ1.textProperty().bindBidirectional(partie.getJoueur(1).scoreProperty(), new NumberStringConverter());
        scoreValueJ2.textProperty().bindBidirectional(partie.getJoueur(2).scoreProperty(), new NumberStringConverter());
        partie.gameOverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                restartButton.setVisible(true);
            }
            else{
                restartButton.setVisible(false);
            }
        });

        restartButton.setVisible(false);
    }

    public void PlayJ1() {
        partie.lancer_de(1);
    }

    public void PlayJ2() {
        partie.lancer_de(2);
    }

    public void restart() {
        partie.restart();
    }
}
