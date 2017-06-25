package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.IModel;
import view.ProductDataView;

/**
 * Created by 1030129 on 02.05.17.
 */
public class ProductDataController extends TabController {

    private ProductDataView _view;

    public ProductDataController(IModel model) throws Exception {

        _model = model;
        _view = new ProductDataView(_model);
        _anchorPane = _view.get_anchorPane();

        _view.get_newButton().setOnAction(new NewButtonEventHandler());
        _view.get_editButton().setOnAction(new EditButtonEventHandler());
        _view.get_deleteButton().setOnAction(new DeleteButtonEventHandler());
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
