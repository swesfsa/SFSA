package view;

import javafx.scene.control.Button;
import misc.TargetSpecification;


import java.util.Observable;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ITargetSpecificationView extends ITabView {

    Button getDeleteButton();
    Button getEditButton();
    Button getSaveButton();

    TargetSpecification getTargetSpecification();
    void setTargetSpecification(TargetSpecification targetSpecification);

    void setEditable(boolean editable);
    void update(Observable o, Object arg);
}
