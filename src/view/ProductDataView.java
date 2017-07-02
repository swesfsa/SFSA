package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import misc.ProductData;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

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
    public ProductDataView(IModel iModel) throws IOException {

        SplitPane _splitPane;
        AnchorPane _leftSplitPane;
        AnchorPane _rightSplitPane;

        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/ProductData.fxml"));

        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");
        _splitPane = (SplitPane) root.lookup("#splitPane");
        _leftSplitPane = (AnchorPane) _splitPane.getItems().get(0);
        _rightSplitPane = (AnchorPane) _splitPane.getItems().get(1);
        _tableView = (TableView) _leftSplitPane.lookup("#tableView");
        _idColumn = (TableColumn) _tableView.getColumns().get(0);
        _memoryContentColumn = (TableColumn) _tableView.getColumns().get(1);
        _idLabel = (Label) _rightSplitPane.lookup("#id");
        _memoryContentLabel = (Label) _rightSplitPane.lookup("#memoryContent");
        _referencesLabel = (Label) _rightSplitPane.lookup("#references");
        _estimationLabel = (Label) _rightSplitPane.lookup("#estimation");
        _retLabel = (Label) _rightSplitPane.lookup("#ret");
        _detLabel = (Label) _rightSplitPane.lookup("#det");
        _classificationLabel = (Label) _rightSplitPane.lookup("#classification");
        _newButton = (Button) _rightSplitPane.lookup("#newButton");
        _editButton = (Button) _rightSplitPane.lookup("#editButton");
        _deleteButton = (Button) _rightSplitPane.lookup("#deleteButton");

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

    public void loadDetailView(ProductData productData) {
        _idLabel.setText(Integer.toString(productData.getId()));
        _memoryContentLabel.setText(productData.getMemoryContent());
        _referencesLabel.setText(productData.getReferences());
        _estimationLabel.setText(productData.getEstimation());
        _retLabel.setText(Integer.toString(productData.getRet()));
        _detLabel.setText(Integer.toString(productData.getDet()));
        _classificationLabel.setText(productData.getClassification().getClassification());
    }

    public void clearDetailView() {
        _idLabel.setText("");
        _memoryContentLabel.setText("");
        _referencesLabel.setText("");
        _estimationLabel.setText("");
        _retLabel.setText("");
        _detLabel.setText("");
        _classificationLabel.setText("");
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void setEditable(boolean editable) {

    }
}
