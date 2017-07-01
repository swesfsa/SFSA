package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IProductUseView extends ITabView {

    Button getSaveButton();
    Button getEditButton();
    Button getDeleteButton();

    TextArea getProductUse();
}
