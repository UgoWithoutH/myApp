package view;

import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Joueur;
import model.Score;

import java.io.IOException;

public class JoueurUserControl extends VBox {

    @FXML
    private ImageView imageView;
    @FXML
    private TextField textfield;
    @FXML
    private Label deValue;
    @FXML
    private Label scoreValue;
    @FXML
    private ListView<Score> scoreList;
    @FXML
    private VBox vBox;
    private ObjectProperty<Joueur> joueurCourantProperty;
    private Joueur joueur;

    public JoueurUserControl(ObjectProperty<Joueur> joueurCourantProperty, Joueur joueur) throws IOException {
        this.joueurCourantProperty = joueurCourantProperty;
        this.joueur = joueur;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UC/JoueurUserControl.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public void initialize() {
        imageView.visibleProperty().bind(joueurCourantProperty.isEqualTo(joueur));
        textfield.textProperty().bind(joueur.nameProperty());
        deValue.textProperty().bind(joueur.getDe().scoreValProperty().asString());
        scoreValue.textProperty().bind(joueur.scoreProperty().asString());
        initializeVBox();
        initializeListView();
    }

    private void initializeVBox(){
        vBox.setPadding(new Insets(20));
        vBox.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
    }

    private void initializeListView(){
        scoreList.itemsProperty().bind(joueur.scoresProperty());
        scoreList.setCellFactory(__ -> new CelluleScore());
    }
}
