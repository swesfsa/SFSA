package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.ProductUse;
import model.IModel;
import view.EmptyTextFieldException;
import view.ProductUseView;

/**
 * Created by 1030129 on 02.05.17.
 */
public class ProductUseController extends TabController {

    private ProductUseView _view;

    private String _productUseString;

    public ProductUseController(IModel model) throws Exception {

        _model = model;
        _view = new ProductUseView(_model);
        _anchorPane = _view.get_anchorPane();

        _view.get_saveButton().setOnAction(new SaveButtonEventHandler());
        _view.get_editButton().setOnAction(new EditButtonEventHandler());
        _view.get_deleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    private void getDataFromView() {
        _productUseString = _view.get_productUse().getText();
    }

    private void checkForEmptyFields() throws EmptyTextFieldException {
        if (_productUseString.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    private class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                System.out.println("saveButtonClicked");
                getDataFromView();
                checkForEmptyFields();

                ProductUse productUse = new ProductUse(_productUseString);
                _model.set_productUse(productUse);
                productUse.print();
            } catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
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
