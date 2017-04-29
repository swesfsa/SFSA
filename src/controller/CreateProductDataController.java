package controller;

import eventHandler.CancelButtonEventHandler;
import eventHandler.SaveButtonEventHandler;
import javafx.stage.Stage;
import view.CreateProductDataView;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController {

    private CreateProductDataView view;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataController() throws Exception {

        view = new CreateProductDataView();
        view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        view.show(stage);
    }

}
