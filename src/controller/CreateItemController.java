package controller;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 29.06.17.
 */
public class CreateItemController extends ControllerTemplate {

    Stage _stage;

    int _id;
    int _det;
    String _references;

    boolean _editMode;
    int _oldId;

    void createNewItem() {
        _editMode = false;
    }

    void editItem() {
        _editMode = true;
    }

    void openIDAlreadyExistingWarning(int id) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("ID bereits vergeben");
        alert.setContentText("Die von Ihnen gewählte ID mit dem Wert " + id + " ist bereits vergeben.");
        alert.showAndWait();
    }
}
