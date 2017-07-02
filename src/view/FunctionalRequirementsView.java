package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import misc.FunctionalRequirement;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by 1030129 on 28.04.17.
 */
public class FunctionalRequirementsView extends TabView implements IFunctionalRequirementsView{

    private Button _newButton;
    private Button _editButton;
    private Button _deleteButton;

    private TableView _tableView;
    private TableColumn _idColumn;
    private TableColumn _titleColumn;
    private TableColumn _dateColumn;

    private Label _idLabel;
    private Label _dateLabel;
    private Label _titleLabel;
    private Label _functionLabel;
    private Label _protagonistLabel;
    private Label _sourceLabel;
    private Label _referencesLabel;
    private Label _priorityLabel;
    private Label _ftrLabel;
    private Label _detLabel;
    private Label _classificationLabel;
    private TextArea _descriptionArea;

    /**
     * @author 1030129
     * @throws Exception
     */
    public FunctionalRequirementsView(IModel iModel) throws IOException {

        SplitPane _splitPane;
        AnchorPane _leftSplitPane;
        AnchorPane _rightSplitPane;

        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FunctionalRequirements.fxml"));

        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");
        _splitPane = (SplitPane) root.lookup("#splitPane");
        _leftSplitPane = (AnchorPane) _splitPane.getItems().get(0);
        _rightSplitPane = (AnchorPane) _splitPane.getItems().get(1);
        _tableView = (TableView) _leftSplitPane.lookup("#tableView");
        _idColumn = (TableColumn) _tableView.getColumns().get(0);
        _titleColumn = (TableColumn) _tableView.getColumns().get(1);
        _dateColumn = (TableColumn) _tableView.getColumns().get(2);
        _idLabel = (Label) _rightSplitPane.lookup("#id");
        _dateLabel = (Label) _rightSplitPane.lookup("#date");
        _titleLabel = (Label) _rightSplitPane.lookup("#title");
        _functionLabel = (Label) _rightSplitPane.lookup("#function");
        _protagonistLabel = (Label) _rightSplitPane.lookup("#protagonist");
        _sourceLabel = (Label) _rightSplitPane.lookup("#source");
        _referencesLabel = (Label) _rightSplitPane.lookup("#references");
        _priorityLabel = (Label) _rightSplitPane.lookup("#priority");
        _ftrLabel = (Label) _rightSplitPane.lookup("#ftr");
        _detLabel = (Label) _rightSplitPane.lookup("#det");
        _classificationLabel = (Label) _rightSplitPane.lookup("#classification");
        _descriptionArea = (TextArea) _rightSplitPane.lookup("#description");
        _newButton = (Button) _rightSplitPane.lookup("#newButton");
        _editButton = (Button) _rightSplitPane.lookup("#editButton");
        _deleteButton = (Button) _rightSplitPane.lookup("#deleteButton");
    }

    public void loadDetailView(FunctionalRequirement functionalRequirement) {
        _idLabel.setText(Integer.toString(functionalRequirement.getId()));
        _dateLabel.setText(functionalRequirement.getDate().getDay() + "."
                + functionalRequirement.getDate().getMonth() + "."
                + functionalRequirement.getDate().getYear());
        _titleLabel.setText(functionalRequirement.getTitle());
        _functionLabel.setText(functionalRequirement.getFunction());
        _descriptionArea.setText(functionalRequirement.getDescription());
        _protagonistLabel.setText(functionalRequirement.getProtagonist());
        _sourceLabel.setText(functionalRequirement.getSource());
        _referencesLabel.setText(functionalRequirement.getReferences());
        _priorityLabel.setText(functionalRequirement.getPriority().getPriority());
        _ftrLabel.setText(Integer.toString(functionalRequirement.getFtr()));
        _detLabel.setText(Integer.toString(functionalRequirement.getDet()));
        _classificationLabel.setText(functionalRequirement.getClassification().getClassification());
    }

    public void clearDetailView() {
        _idLabel.setText("");
        _dateLabel.setText("");
        _titleLabel.setText("");
        _functionLabel.setText("");
        _descriptionArea.setText("");
        _protagonistLabel.setText("");
        _sourceLabel.setText("");
        _referencesLabel.setText("");
        _priorityLabel.setText("");
        _ftrLabel.setText("");
        _detLabel.setText("");
        _classificationLabel.setText("");
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

    public TableColumn getTitleColumn() {
        return _titleColumn;
    }

    public TableColumn getDateColumn() {
        return _dateColumn;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void setEditable(boolean editable) {

    }
}
