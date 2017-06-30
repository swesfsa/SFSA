package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.IModel;

/**
 * Created by 1030129 on 28.04.17.
 */
public class ProductDataView extends TabView implements IProductDataView{

    private Button _newButton;
    private Button _editButton;
    private Button _deleteButton;

    private TableView _tableView;
    private TableColumn _idColumn;
    private TableColumn _memoryContentColumn;

    private Label _idLabel;
    private Label _memoryContentLabel;
    private Label _referencesLabel;
    private Label _estimationLabel;
    private Label _retLabel;
    private Label _detLabel;
    private Label _classificationLabel;

    /**
     * @author 1030129
     * @throws Exception
     */
    public ProductDataView(IModel model) throws Exception {

        SplitPane _splitPane;
        AnchorPane _leftSplitPane;
        AnchorPane _rightSplitPane;

        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/ProductData.fxml"));

        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");
        _splitPane = (SplitPane) root.lookup("#splitPane");
        _leftSplitPane = (AnchorPane) _splitPane.getItems().get(0);
        _rightSplitPane = (AnchorPane) _splitPane.getItems().get(1);
        _tableView = (TableView) _leftSplitPane.lookup("#tableView");
        _idColumn = (TableColumn) _tableView.getColumns().get(0);
        _memoryContentColumn = (TableColumn) _tableView.getColumns().get(1);
        _idLabel = (Label) _rightSplitPane.lookup("idLabel");
        _memoryContentLabel = (Label) _rightSplitPane.lookup("memoryContentLabel");
        _referencesLabel = (Label) _rightSplitPane.lookup("referencesLabel");
        _estimationLabel = (Label) _rightSplitPane.lookup("estimationLabel");
        _retLabel = (Label) _rightSplitPane.lookup("retLabel");
        _detLabel = (Label) _rightSplitPane.lookup("detLabel");
        _classificationLabel = (Label) _rightSplitPane.lookup("classificationLabel");
        _newButton = (Button) root.lookup("#newButton");
        _editButton = (Button) root.lookup("#editButton");
        _deleteButton = (Button) root.lookup("#deleteButton");
    }

    /**
     * @author 1030129
     * @return _newButton
     */
    public Button getNewButton() {
        return _newButton;
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
     * @return _deleteButton
     */
    public Button getDeleteButton() {
        return _deleteButton;
    }

    public TableView getTableView() {
        return _tableView;
    }

    public TableColumn getIdColumn() {
        return _idColumn;
    }

    public TableColumn getMemoryContentColumn() {
        return _memoryContentColumn;
    }

    public Label getIdLabel() {
        return _idLabel;
    }

    public Label getMemoryContentLabel() {
        return _memoryContentLabel;
    }

    public Label getReferencesLabel() {
        return _referencesLabel;
    }

    public Label getEstimationLabel() {
        return _estimationLabel;
    }

    public Label getRetLabel() {
        return _retLabel;
    }

    public Label getDetLabel() {
        return _detLabel;
    }

    public Label getClassificationLabel() {
        return _classificationLabel;
    }
}
