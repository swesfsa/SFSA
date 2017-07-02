package view;

import javafx.scene.control.*;
import misc.FunctionalRequirement;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IFunctionalRequirementsView extends ITableView {

    TableColumn getIdColumn();
    TableColumn getTitleColumn();
    TableColumn getDateColumn();

    Button getNewButton();
    Button getEditButton();
    Button getDeleteButton();

    void loadDetailView(FunctionalRequirement functionalRequirement);
}
