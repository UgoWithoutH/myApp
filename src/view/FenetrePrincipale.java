package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import model.Partie;
import model.Score;

import java.io.IOException;
import java.util.List;

public class FenetrePrincipale {

    @FXML
    private Button restartButton;
    @FXML
    private VBox root;
    @FXML
    private HBox myHbox;
    private Partie partie;
    private Stage stage;

    public FenetrePrincipale(Stage stage) {
        this.stage = stage;
    }

    public void initialize() throws IOException {
        partie = new Partie(2);

        restartButton.visibleProperty().bind(partie.gameOverProperty());

        myHbox.getChildren().add(0, new JoueurUserControl(partie.joueurCourantProperty(), partie.getJoueur(1)));
        myHbox.getChildren().add(new JoueurUserControl(partie.joueurCourantProperty(), partie.getJoueur(2)));

        bindSize();
    }

    private void bindSize(){
        root.prefWidthProperty().bind(stage.widthProperty());
        root.prefHeightProperty().bind(stage.heightProperty());
    }

    public void restart() {
        partie.restart();
    }

    public void Play() {
        partie.lancer_de();
    }
}
