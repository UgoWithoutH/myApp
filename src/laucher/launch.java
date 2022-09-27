package laucher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FenetrePrincipale;

public class launch extends Application {

    private static final long WIDTH = 800;
    private static final long HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
        fxmlLoader.setController(new FenetrePrincipale(primaryStage));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setHeight(WIDTH);
        primaryStage.setWidth(HEIGHT);

        primaryStage.show();
    }
}
