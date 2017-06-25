package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.IModel;

/**
 * Created by 1030129 on 28.04.17.
 */
public class FunctionalRequirementsView extends TabView implements IFunctionalRequirementsView{

    private IModel _model;

    private Button _newButton;
    private Button _editButton;
    private Button _deleteButton;

    private ListView _requirementsList;

    /**
     * @author 1030129
     * @throws Exception
     */
    public FunctionalRequirementsView(IModel model) throws Exception {

        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FunctionalRequirements.fxml"));

        _newButton = (Button) root.lookup("#newButton");
        _editButton = (Button) root.lookup("#editButton");
        _deleteButton = (Button) root.lookup("#deleteButton");
        _requirementsList = (ListView) root.lookup("#requirementsList");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");
    }

    /**
     * @author 1030129
     * @return _newButton
     */
    public Button get_newButton() {
        return _newButton;
    }

    /**
     * @author 1030129
     * @return _editButton
     */
    public Button get_editButton() {
        return _editButton;
    }

    /**
     * @author 1030129
     * @return _deleteButton
     */
    public Button get_deleteButton() {
        return _deleteButton;
    }

    /**
     * @author 1030129
     * @return _requirementsList
     */
    public ListView get_requirementsList() {
        return _requirementsList;
    }
}
