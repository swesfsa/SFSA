package view;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateProductDataView extends IView{

    Button get_saveButton();
    Button get_cancelButton();

    TextField get_id();
    TextField get_memoryContent();
    TextField get_references();
    TextField get_ret();
    TextField get_det();

    TextArea get_estimation();

    ChoiceBox<String> get_classification();
}
