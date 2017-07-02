package controller;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 29.06.17.
 */
public abstract class CreateItemController extends ControllerTemplate implements ICreateItemController {

    Stage _stage;

    boolean _editMode;
    int _oldId;

    void createNewItem() {
        _editMode = false;
    }

    void editItem() {
        _editMode = true;
    }

    void openIDAlreadyExistingWarning() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("ID bereits vergeben");
        alert.setContentText("Die von Ihnen gewählte ID ist bereits vergeben.");
        alert.showAndWait();
    }
}
