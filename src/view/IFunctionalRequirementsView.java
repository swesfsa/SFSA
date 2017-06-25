package view;

import javafx.scene.control.*;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IFunctionalRequirementsView {

    Button get_newButton();
    Button get_editButton();
    Button get_deleteButton();

    ListView get_requirementsList();
}
