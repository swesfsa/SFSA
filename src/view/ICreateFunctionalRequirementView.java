package view;

import javafx.scene.control.*;
import misc.Classification;
import misc.Priority;

import java.time.LocalDate;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateFunctionalRequirementView extends IView{

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
