package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import misc.TargetSpecification;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 28.04.17.
 */
public class TargetSpecificationView extends TabView implements ITargetSpecificationView {

    private Button _deleteButton;
    private Button _editButton;
    private Button _saveButton;

    private TextArea _targetSpecification;

    /**
     * @author 1030129
     * @throws Exception
     */
    public TargetSpecificationView(IModel iModel) throws IOException {
        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/TargetSpecification.fxml"));

        _deleteButton = (Button) root.lookup("#deleteButton");
        _editButton = (Button) root.lookup("#editButton");
        _saveButton = (Button) root.lookup("#saveButton");
        _targetSpecification = (TextArea) root.lookup("#textArea");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");

        update(null, null);
        setEditable(false);
    }

    public void setEditable(boolean editable) {
        _targetSpecification.setEditable(editable);
        if (editable) {
            _editButton.setText("Abbrechen");
        } else {
            _editButton.setText("Bearbeiten");
        }
    }

    public TargetSpecification getTargetSpecification() {
        TargetSpecification targetSpecification = new TargetSpecification();
        targetSpecification.setTargetSpecification(_targetSpecification.getText());
        return targetSpecification;
    }

    public void setTargetSpecification(TargetSpecification targetSpecification) {
        _targetSpecification.setText(targetSpecification.getTargetSpecification());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(_iModel.getTargetSpecification() != null)
            setTargetSpecification(_iModel.getTargetSpecification());
        else
            LOGGER.severe("Target Specification null");
    }

    /**
     * @author 1030129
     * @return _deleteButton
     */
    public Button getDeleteButton() {
        return _deleteButton;
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
     * @return _saveButton
     */
    public Button getSaveButton() {
        return _saveButton;
    }

}
