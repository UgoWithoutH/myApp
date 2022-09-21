package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;
import model.Partie;

public class FenetrePrincipale {

    @FXML
    private Label scoreValueJ1;
    @FXML
    private Label scoreValueJ2;
    @FXML
    private Button buttonPlay;
    @FXML
    private Button restartButton;
    @FXML
    private VBox box1;
    @FXML
    private VBox box2;
    @FXML
    private ImageView imageJ1;
    @FXML
    private ImageView imageJ2;
    @FXML
    private TextField textfieldJ1;
    @FXML
    private TextField textfieldJ2;
    private Partie partie;

    public void initialize(){
        partie = new Partie(2);

        scoreValueJ1.textProperty().bindBidirectional(partie.getJoueur(1).scoreProperty(), new NumberStringConverter());
        scoreValueJ2.textProperty().bindBidirectional(partie.getJoueur(2).scoreProperty(), new NumberStringConverter());
        restartButton.visibleProperty().bind(partie.gameOverProperty());

        Border border = new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3)));

        box1.setPadding(new Insets(20));
        box2.setPadding(new Insets(20));

        box1.setBorder(border);
        box2.setBorder(border);

        textfieldJ1.textProperty().bindBidirectional(partie.getJoueur(1).nameProperty());
        textfieldJ2.textProperty().bindBidirectional(partie.getJoueur(2).nameProperty());

        imageJ1.visibleProperty().bind(partie.joueurCourantProperty().isEqualTo(partie.getJoueur(1)));
        imageJ2.visibleProperty().bind(partie.joueurCourantProperty().isEqualTo(partie.getJoueur(2)));
    }

    public void restart() {
        partie.restart();
    }

    public void Play() {
        partie.lancer_de();
    }
}
