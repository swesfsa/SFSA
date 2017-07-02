package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import misc.Environment;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 02.05.17.
 */
public class EnvironmentView extends TabView implements IEnvironmentView{

    private Button _saveButton;
    private Button _editButton;
    private Button _deleteButton;

    private TextArea _hardwareEnvironment;
    private TextArea _softwareEnvironment;

    /**
     * @author 1030129
     * @throws Exception
     */
    public EnvironmentView(IModel iModel) throws IOException {

        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Environment.fxml"));

        _saveButton = (Button) root.lookup("#saveButton");
        _editButton = (Button) root.lookup("#editButton");
        _deleteButton = (Button) root.lookup("#deleteButton");
        _hardwareEnvironment = (TextArea) root.lookup("#hardware");
        _softwareEnvironment = (TextArea) root.lookup("#software");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");

        update(null, null);
        setEditable(false);
    }

    public void setEditable(boolean editable) {
        _hardwareEnvironment.setEditable(editable);
        _softwareEnvironment.setEditable(editable);
        if (editable) {
            _editButton.setText("Abbrechen");
        } else {
            _editButton.setText("Bearbeiten");
        }
    }

    public Environment getEnvironment() {

        Environment environment = new Environment();
        environment.setHardwareEnvironment(_hardwareEnvironment.getText());
        environment.setSoftwareEnvironment(_softwareEnvironment.getText());
        return environment;

    }

    public void setEnvironment(Environment environment) {
        _hardwareEnvironment.setText(environment.getHardwareEnvironment());
        _softwareEnvironment.setText(environment.getSoftwareEnvironment());
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
    public Button getDeleteButton() {
        return _deleteButton;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(_iModel.getEnvironment() != null)
            setEnvironment(_iModel.getEnvironment());
        else
            LOGGER.severe("Environment null");
    }
}
