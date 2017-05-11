package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by 1030129 on 03.05.17.
 */
public class CreateController extends ControllerTemplate {

    public void openEmptyTextFieldWarning() {

        Alert alert = new Alert((Alert.AlertType.WARNING));
        alert.setTitle("Warnung");
        alert.setHeaderText("Leeres Textfeld");
        alert.setContentText("Bitte füllen Sie alle Textfelder aus.");
        alert.showAndWait();
    }

    public void openNumberFormatWarning(String contentText) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Falsches Eingabeformat");
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void openDeleteQuery() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Achtung Löschvorgang!");
        alert.setContentText("Möchten Sie das ausgewälte Element wirklich unwiderruflich löschen?");

        alert.getButtonTypes().setAll(ButtonType.NO, ButtonType.YES);

        Optional<ButtonType> choice = alert.showAndWait();
        if (choice.get() == ButtonType.YES) {
            System.out.println("Löschvorgang bestätigt");
        } else {
            System.out.println("Löschvorgang abgebrochen");
        }
    }
}
