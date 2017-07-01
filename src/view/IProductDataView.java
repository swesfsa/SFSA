package view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IProductDataView extends ITabView {

    Button getNewButton();
    Button getEditButton();
    Button getDeleteButton();
}
