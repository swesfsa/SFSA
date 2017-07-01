package view;

import javafx.scene.control.*;
import javafx.stage.Stage;
import misc.FunctionalRequirementClassification;
import misc.Priority;

import java.util.Map;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateFunctionalRequirementView extends IStageView {

    void close(Stage stage);

    Map<String, Priority> getPriorityMap();
    Map<String, FunctionalRequirementClassification> getClassificationMap();

    Button getSaveButton();
    Button getCancelButton();

    DatePicker getDate();

    TextField getId();
    TextField getTitle();
    ChoiceBox<String> getPriority();
    TextField getFunction();
    TextField getProtagonist();
    TextField getSource();
    TextField getReferences();
    TextField getFtr();
    TextField getDet();
    ChoiceBox<String> getClassification();

    TextArea getDescription();
}
