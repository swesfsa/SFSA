package view;

import javafx.scene.control.*;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IFunctionalRequirementsView {

    Button getNewButton();
    Button getEditButton();
    Button getDeleteButton();

    ListView getRequirementsList();
}
