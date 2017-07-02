package controller;

import javafx.scene.control.Alert;
import model.IModel;

/**
 * Created by 1030129 on 10.05.17.
 */
public class ControllerTemplate {

    protected IModel _iModel;

    void openEmptyTextFieldWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Leeres Textfeld");
        alert.setContentText("Bitte füllen Sie alle Textfelder aus.");
        alert.showAndWait();
    }

    void openEmptyTextFieldWarning(String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Leeres Textfeld");
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    void openNumberFormatWarning(String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Falsches Eingabeformat");
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    void openEmptyChoiceBoxWarning(String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("Leere Auswahlliste");
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
