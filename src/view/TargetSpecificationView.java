package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import model.IModel;

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
    public TargetSpecificationView(IModel model) throws Exception {
        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/TargetSpecification.fxml"));

        _deleteButton = (Button) root.lookup("#deleteButton");
        _editButton = (Button) root.lookup("#editButton");
        _saveButton = (Button) root.lookup("#saveButton");
        _targetSpecification = (TextArea) root.lookup("#textArea");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");
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

    /**
     * @author 1030129
     * @return _targetSpecification
     */
    public TextArea getTargetSpecification() {
        return _targetSpecification;
    }
}
