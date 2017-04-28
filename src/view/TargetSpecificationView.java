package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Created by 1030129 on 28.04.17.
 */
public class TargetSpecificationView {

    private Button deleteButton;
    private Button editButton;
    private Button saveButton;

    private TextArea textArea;

    /**
     * @author 1030129
     * @throws Exception
     */
    public TargetSpecificationView() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/TargetSpecification.fxml"));

        deleteButton = (Button) root.lookup("#deleteButton");
        editButton = (Button) root.lookup("#editButton");
        saveButton = (Button) root.lookup("#saveButton");
        textArea = (TextArea) root.lookup("#textArea");
    }

    /**
     * @author 1030129
     * @return deleteButton
     */
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * @author 1030129
     * @return editButton
     */
    public Button getEditButton() {
        return editButton;
    }

    /**
     * @author 1030129
     * @return saveButton
     */
    public Button getSaveButton() {
        return saveButton;
    }
}
