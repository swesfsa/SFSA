package sfsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public interface ITabController {

    @FXML
    Button editButton = null;

    @FXML
    Button finishButton = null;

    @FXML
    Button deleteButton = null;

    @FXML
    void editButtonPressed(ActionEvent event);

    @FXML
    void finishButtonPressed(ActionEvent event);

    @FXML
    void deleteButtonPressed(ActionEvent event);
}