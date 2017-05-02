package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Created by 1030129 on 28.04.17.
 */
public class FunctionalRequirementsView implements IFunctionalRequirementsView{

    private Button newButton;
    private Button editButton;
    private Button deleteButton;

    private ListView requirementsList;

    /**
     * @author 1030129
     * @throws Exception
     */
    public FunctionalRequirementsView() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FunctionalRequirements.fxml"));

        newButton = (Button) root.lookup("#newButton");
        editButton = (Button) root.lookup("#editButton");
        deleteButton = (Button) root.lookup("#deleteButton");
        requirementsList = (ListView) root.lookup("#requirementsList");
    }

    /**
     * @author 1030129
     * @return newButton
     */
    public Button getNewButton() {
        return newButton;
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
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * @author 1030129
     * @return requirementsList
     */
    public ListView getRequirementsList() {
        return requirementsList;
    }
}
