package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.IModel;
import sun.plugin.javascript.navig.Anchor;

/**
 * Created by 1030129 on 28.04.17.
 */
public class FunctionalRequirementsView extends TabView implements IFunctionalRequirementsView{

    private IModel _model;

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

    private SplitPane _splitPane;
    private AnchorPane _leftSplitPane;
    private AnchorPane _rightSplitPane;


    /**
     * @author 1030129
     * @throws Exception
     */
    public FunctionalRequirementsView(IModel model) throws Exception {

        _model = model;

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

    public TableView get_tableView() {
        return _tableView;
    }

    public TableColumn get_idColumn() {
        return _idColumn;
    }

    public TableColumn get_titleColumn() {
        return _titleColumn;
    }

    public TableColumn get_dateColumn() {
        return _dateColumn;
    }

    public Label get_idLabel() {
        return _idLabel;
    }

    public Label get_dateLabel() {
        return _dateLabel;
    }

    public Label get_titleLabel() {
        return _titleLabel;
    }

    public Label get_functionLabel() {
        return _functionLabel;
    }

    public Label get_protagonistLabel() {
        return _protagonistLabel;
    }

    public Label get_sourceLabel() {
        return _sourceLabel;
    }

    public Label get_referencesLabel() {
        return _referencesLabel;
    }

    public Label get_priorityLabel() {
        return _priorityLabel;
    }

    public Label get_ftrLabel() {
        return _ftrLabel;
    }

    public Label get_detLabel() {
        return _detLabel;
    }

    public Label get_classificationLabel() {
        return _classificationLabel;
    }

    public TextArea get_descriptionArea() {
        return _descriptionArea;
    }
}
