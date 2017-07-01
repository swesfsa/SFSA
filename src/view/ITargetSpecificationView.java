package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ITargetSpecificationView extends ITabView {

    Button getDeleteButton();
    Button getEditButton();
    Button getSaveButton();

    TextArea getTargetSpecification();

}
