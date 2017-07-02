package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 12.05.17.
 */
public abstract class TabController extends ControllerTemplate implements ITabController {

    AnchorPane _anchorPane;

    boolean _editable;

    public AnchorPane getAnchorPane(){
        return _anchorPane;
    }

    Boolean openDeleteQuery() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Achtung Löschvorgang!");
        alert.setContentText("Möchten Sie das ausgewälte Element wirklich unwiderruflich löschen?");

        alert.getButtonTypes().setAll(ButtonType.NO, ButtonType.YES);

        Optional<ButtonType> choice = alert.showAndWait();
        if (choice.isPresent() && choice.get() == ButtonType.YES) {
            LOGGER.info("Löschvorgang bestätigt");
            return true;
        } else {
            LOGGER.info("Löschvorgang abgebrochen");
            return false;
        }
    }

    void openEmptyListWarning(String requestedAction) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Achtung leere Liste!");
        alert.setContentText("Sie können kein Element " + requestedAction + ", da die Liste leer ist.");
        alert.showAndWait();
    }

    void openNoListViewRowSelectedWarning(String requestedAction) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Achtung kein Listenelement ausgewählt!");
        alert.setContentText("Um ein Element zu " + requestedAction + ", müssen Sie ein Element in der Liste auswählen.");
        alert.showAndWait();
    }
}
