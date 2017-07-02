package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import misc.Environment;

import java.util.Observable;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IEnvironmentView extends ITabView {

    Button getSaveButton();
    Button getEditButton();
    Button getDeleteButton();

    Environment getEnvironment();
    void setEnvironment(Environment environment);

    void setEditable(boolean editable);
    void update(Observable o, Object arg);

}
