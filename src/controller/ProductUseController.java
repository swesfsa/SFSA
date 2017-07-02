package controller;

import exception.EmptyTextFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.ProductUse;
import misc.TargetSpecification;
import model.IModel;
import view.IProductUseView;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 02.05.17.
 */
class ProductUseController extends TabController {

    private IProductUseView _iView;

    ProductUseController(IModel iModel, IProductUseView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _iView.getEditButton().setOnAction(new EditButtonEventHandler());
        _iView.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

        _editable = false;
    }

    private void toggleEditMode(boolean editable) {
        _iView.setEditable(editable);
        _editable = editable;
    }

    private class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            try {
                ProductUse productUse = _iView.getProductUse();
                productUse.check();
                _iModel.setProductUse(productUse);
                LOGGER.info("Product Use saved in Model");
            } catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            }
            toggleEditMode(false);
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (!_editable) {
                toggleEditMode(true);
            } else {
                toggleEditMode(false);
                _iView.update(null, null);
            }
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            boolean delete;
            delete = openDeleteQuery();
            if (delete) {
                _iModel.setProductUse(new ProductUse(""));
            }
        }
    }
}
