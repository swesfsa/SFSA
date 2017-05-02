package view;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateFunctionalRequirementView extends IView{

    Button getSaveButton();
    Button getCancelButton();

    DatePicker getDate();

    TextField getID();
    TextField getTitle();
    String getPriority();
    TextField getFunction();
    TextField getProtagonist();
    TextField getSource();
    TextField getReferences();

    TextArea getDescription();
}
