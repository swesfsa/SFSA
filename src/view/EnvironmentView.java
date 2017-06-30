package view;

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

    private Button _saveButton;
    private Button _editButton;
    private Button _cancelButton;

    private TextArea _hardwareEnvironment;
    private TextArea _softwareEnvironment;

    /**
     * @author 1030129
     * @throws Exception
     */
    public EnvironmentView(IModel model) throws Exception{

        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Environment.fxml"));

        _saveButton = (Button) root.lookup("#saveButton");
        _editButton = (Button) root.lookup("#editButton");
        _cancelButton = (Button) root.lookup("#cancelButton");
        _hardwareEnvironment = (TextArea) root.lookup("#hardware");
        _softwareEnvironment = (TextArea) root.lookup("#software");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");
    }

    /**
     * @author 1030129
     * @return _saveButton
     */
    public Button getSaveButton() {
        return _saveButton;
    }

    /**
     * @author 1030129
     * @return _editButton
     */
    public Button getEditButton() {
        return _editButton;
    }

    /**
     * @author 1030129
     * @return deleteButton
     */
    public Button getCancelButton() {
        return _cancelButton;
    }

    /**
     * @author 1030129
     * @return _hardwareEnvironment
     */
    public TextArea getHardwareEnvironment() {
        return _hardwareEnvironment;
    }

    /**
     * @author 1030129
     * @return _softwareEnvironment
     */
    public TextArea getSoftwareEnvironment() {
        return _softwareEnvironment;
    }

}
