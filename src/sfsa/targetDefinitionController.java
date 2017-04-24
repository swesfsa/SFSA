package sfsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by marcostierle on 25.04.17.
 */
public class targetDefinitionController implements ITabController {

    @FXML
    private TextField textField;

    @Override
    public void editButtonPressed(ActionEvent event) {
        editButton.setDisable(true);
        editButton.setVisible(false);
        finishButton.setDisable(false);
        finishButton.setVisible(true);
        textField.setEditable(true);
    }

    @Override
    public void finishButtonPressed(ActionEvent event) {
        editButton.setDisable(false);
        editButton.setVisible(true);
        textField.setEditable(false);
        finishButton.setDisable(true);
        finishButton.setVisible(false);
    }

    @Override
    public void deleteButtonPressed(ActionEvent event) {
        textField.deleteText(0, textField.getLength());
    }
}
