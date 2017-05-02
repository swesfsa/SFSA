package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Created by 1030129 on 02.05.17.
 */
public class EnvironmentView implements IEnvironmentView{

    private Button saveButton;
    private Button editButton;
    private Button deleteButton;

    private TextArea hardwareEnvironment;
    private TextArea softwareEnvironment;

    /**
     * @author 1030129
     * @throws Exception
     */
    public EnvironmentView() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Environment.fxml"));

        saveButton = (Button) root.lookup("#saveButton");
        editButton = (Button) root.lookup("#editButton");
        deleteButton = (Button) root.lookup("#deleteButton");
        hardwareEnvironment = (TextArea) root.lookup("#hardware");
        softwareEnvironment = (TextArea) root.lookup("#software");
    }

    /**
     * @author 1030129
     * @return saveButton
     */
    public Button getSaveButton() {
        return saveButton;
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
     * @return deleteButton
     */
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * @author 1030129
     * @return hardwareEnvironment
     */
    public TextArea getHardwareEnvironment() {
        return hardwareEnvironment;
    }

    /**
     * @author 1030129
     * @return softwareEnvironment
     */
    public TextArea getSoftwareEnvironment() {
        return softwareEnvironment;
    }
}
