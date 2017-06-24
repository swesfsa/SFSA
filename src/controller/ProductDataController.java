package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.IModel;
import view.FunctionalRequirementsView;
import view.ProductDataView;

/**
 * Created by 1030129 on 02.05.17.
 */
public class ProductDataController extends TabController {

    private static ProductDataController instance;
    private ProductDataView _view;

    private ProductDataController(IModel model) throws Exception {

        _model = model;
        _view = new ProductDataView(_model);
        anchorPane = _view.getAnchorPane();

        _view.getNewButton().setOnAction(new NewButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    public synchronized static ProductDataController getController(IModel model) throws Exception {

        if (instance == null) {
            instance = new ProductDataController(model);
        }

        return instance;
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                IController controller = new CreateProductDataController(_model);
                controller.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("EditButtonClicked");
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("DeleteButtonClicked");
            openDeleteQuery();
        }
    }
}
