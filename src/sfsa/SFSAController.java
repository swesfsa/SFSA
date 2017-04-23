package sfsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SFSAController {

    @FXML
    private TextField zielbestimmungTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    void saveButtonPressed(ActionEvent event) {
        zielbestimmungTextField.setEditable(false);
    }

    @FXML
    void editButtonPressed(ActionEvent event) {
        zielbestimmungTextField.setEditable(true);
    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        zielbestimmungTextField.deleteText(0, zielbestimmungTextField.getLength());
    }

}
