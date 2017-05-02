package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.StageHandler;
import model.IModel;
import view.CreateProductDataView;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController implements IController {

    private IModel model;

    private CreateProductDataView view;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataController(IModel model) throws Exception {

        this.model = model;
        this.view = new CreateProductDataView(model);

        view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    /**
     * @author 1030129
     */
    public void show() {
        view.show(StageHandler.getInstance().getPrimaryStage());
    }

    public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            System.out.println("cancelButton pressed");
        }
    }

    public class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            System.out.println("saveButton pressed");
        }
    }
}
