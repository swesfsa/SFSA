package view;

import controller.ProductUseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import model.IModel;

/**
 * Created by 1030129 on 02.05.17.
 */
public class EnvironmentView extends TabView implements IEnvironmentView{

    private IModel _model;

    private Button saveButton;
    private Button editButton;
    private Button cancelButton;

    private TextArea hardwareEnvironment;
    private TextArea softwareEnvironment;

    /**
     * @author 1030129
     * @throws Exception
     */
    public EnvironmentView(IModel model) throws Exception{

        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Environment.fxml"));

        saveButton = (Button) root.lookup("#saveButton");
        editButton = (Button) root.lookup("#editButton");
        cancelButton = (Button) root.lookup("#cancelButton");
        hardwareEnvironment = (TextArea) root.lookup("#hardware");
        softwareEnvironment = (TextArea) root.lookup("#software");
        anchorPane = (AnchorPane) root.lookup("#AnchorPane");
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
    public Button getCancelButton() {
        return cancelButton;
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
