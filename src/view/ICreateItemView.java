package view;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by tmonn on 01.07.2017.
 */
public interface ICreateItemView extends IStageView {
    void close(Stage stage);

    Button getSaveButton();
    Button getCancelButton();
}
