package view;

import javafx.scene.control.ListCell;
import model.Score;

public class CelluleScore extends ListCell<Score> {

    @Override
    protected void updateItem(Score item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.scoreProperty().asString());
        }
        else{
            textProperty().unbind();
        }
    }
}
