package view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IProductDataView {

    Button get_newButton();
    Button get_editButton();
    Button get_deleteButton();

    ListView get_dataList();
}
