package controller;

import javafx.scene.control.Alert;

/**
 * Created by 1030129 on 03.05.17.
 */
public class CreateController {

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
}
