package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.util.Optional;

/**
 * Created by 1030129 on 12.05.17.
 */
public abstract class TabController extends ControllerTemplate implements ITabController {

    AnchorPane _anchorPane;

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
            System.out.println("Löschvorgang bestätigt");
            return true;
        } else {
            System.out.println("Löschvorgang abgebrochen");
            return false;
        }
    }
}
