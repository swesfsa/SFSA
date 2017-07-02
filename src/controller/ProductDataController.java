package controller;

import exception.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import misc.ProductData;
import model.IModel;
import view.IProductDataView;

import static controller.EStageController.CREATE_PRODUCT_DATA_CONTROLLER;
import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 02.05.17.
 */
class ProductDataController extends TabController {

    private IProductDataView _iView;
    private ProductData _selectedTableViewItem;

    ProductDataController(IModel iModel, IProductDataView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getNewButton().setOnAction(new NewButtonEventHandler());
        _iView.getEditButton().setOnAction(new EditButtonEventHandler());
        _iView.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

        _iView.getIdColumn().setCellValueFactory(new PropertyValueFactory<>("Id"));
        _iView.getMemoryContentColumn().setCellValueFactory(new PropertyValueFactory<>("MemoryContent"));
        _iView.getTableView().setItems(_iModel.getProductDataList());
        _iView.getTableView().setOnMouseClicked(new TableViewClickedHandler());
    }

    private ProductData getProductDataFromTableViewItem(ProductData itemToLoad) {
        int index = _iModel.getProductDataList().indexOf(itemToLoad);
        return _iModel.getProductDataList().get(index);
    }

    private void checkForEmptyList(IModel iModel) throws EmptyListException {
        if (iModel.getProductDataList().isEmpty()) {
            throw new EmptyListException();
        }
    }

    private void checkForSelection() throws NoListViewRowSelectedException {
        if (_iView.getTableView().getSelectionModel().getSelectedItem() == null) {
            throw new NoListViewRowSelectedException();
        }
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            IStageController iController = StageControllerFactory.create
                    (CREATE_PRODUCT_DATA_CONTROLLER, _iModel);
            iController.show();
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                checkForEmptyList(_iModel);
                checkForSelection();
                IStageController controller = StageControllerFactory.createWArg
                        (CREATE_PRODUCT_DATA_CONTROLLER, _iModel,
                                getProductDataFromTableViewItem(_selectedTableViewItem));
                controller.show();
            } catch (EmptyListException e) {
                LOGGER.warning(e.toString());
                openEmptyListWarning("bearbeiten");
            } catch (NoListViewRowSelectedException e) {
                LOGGER.warning(e.toString());
                openNoListViewRowSelectedWarning("bearbeiten");
            }
            _iView.clearDetailView();
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                checkForEmptyList(_iModel);
                checkForSelection();
                Boolean delete;
                delete = openDeleteQuery();
                if (delete) {
                    _iModel.getProductDataList().remove(_selectedTableViewItem);
                    LOGGER.info("Product Data deleted from Model");
                    _iView.clearDetailView();
                }
            } catch (EmptyListException e) {
                LOGGER.warning(e.toString());
                openEmptyListWarning("löschen");
            } catch (NoListViewRowSelectedException e) {
                LOGGER.warning(e.toString());
                openNoListViewRowSelectedWarning("löschen");
            }
        }
    }

    private class TableViewClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            _selectedTableViewItem = (ProductData) _iView.getTableView().getSelectionModel().getSelectedItem();
            _iView.loadDetailView(_selectedTableViewItem);
        }
    }
}
