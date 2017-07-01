package view;

import javafx.scene.control.*;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IFunctionalRequirementsView extends ITabView {

    TableView getTableView();
    TableColumn getIdColumn();
    TableColumn getTitleColumn();
    TableColumn getDateColumn();
    Label getIdLabel();
    Label getDateLabel();
    Label getTitleLabel();
    Label getFunctionLabel();
    Label getProtagonistLabel();
    Label getSourceLabel();
    Label getReferencesLabel();
    Label getPriorityLabel();
    Label getFtrLabel();
    Label getDetLabel();
    Label getClassificationLabel();
    TextArea getDescriptionArea();
    Button getNewButton();
    Button getEditButton();
    Button getDeleteButton();

}
