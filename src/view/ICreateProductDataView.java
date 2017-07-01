package view;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateProductDataView extends IStageView {

    void close(Stage stage);

    Button getSaveButton();
    Button getCancelButton();

    TextField getId();
    TextField getMemoryContent();
    TextField getReferences();
    TextField getRet();
    TextField getDet();

    TextArea getEstimation();

    ChoiceBox<String> getClassification();
}
