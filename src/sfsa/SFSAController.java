package sfsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SFSAController {

    @FXML
    private TextField targetDefinitionTextField;

    @FXML
    private TextField productUseTextField;

    @FXML
    private Button targetDefinitionSaveButton;

    @FXML
    private Button productUseSaveButton;

    @FXML
    private Button targetDefinitionEditButton;

    @FXML
    private Button productUseEditButton;

    @FXML
    private Button targetDefinitionDeleteButton;

    @FXML
    private Button productUseDeleteButton;

    @FXML
    void targetDefinitionSaveButtonPressed(ActionEvent event) {
        targetDefinitionTextField.setEditable(false);
    }

    @FXML
    void targetDefinitonEditButtonPressed(ActionEvent event) {
        targetDefinitionTextField.setEditable(true);
    }

    @FXML
    void targetDefinitionDeleteButtonPressed(ActionEvent event) {
        targetDefinitionTextField.deleteText(0, targetDefinitionTextField.getLength());
    }

    @FXML
    void productUseSaveButtonPressed(ActionEvent event) {
        productUseTextField.setEditable(false);
    }

    @FXML
    void productUseEditButtonPressed(ActionEvent event) {
        productUseTextField.setEditable(true);
    }

    @FXML
    void productUseDeleteButtonPressed(ActionEvent event) {
        productUseTextField.deleteText(0, productUseTextField.getLength());
    }

}
