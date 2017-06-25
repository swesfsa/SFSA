package view;

import javafx.scene.control.*;
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
    ChoiceBox<String> get_priority();
    TextField get_function();
    TextField getProtagonist();
    TextField getSource();
    TextField getReferences();
    TextField get_ftr();
    TextField getDet();
    ChoiceBox<String> get_classification();

    TextArea get_description();
}
