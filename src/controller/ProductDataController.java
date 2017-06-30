package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import misc.FunctionalRequirement;
import misc.ProductData;
import model.IModel;
import view.ProductDataView;

/**
 * Created by 1030129 on 02.05.17.
 */
class ProductDataController extends TabController {
//TODO change like FunctionalRequirementsController
    private ProductDataView _view;
    private ProductData _selectedTableViewItem;

    ProductDataController(IModel model) throws Exception {

        _model = model;
        _view = new ProductDataView(_model);
        _anchorPane = _view.getAnchorPane();

        _view.getNewButton().setOnAction(new NewButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

        _view.getIdColumn().setCellValueFactory(new PropertyValueFactory<>("_id"));
        _view.getMemoryContentColumn().setCellValueFactory(new PropertyValueFactory<>("_memoryContent"));
        _view.getTableView().setItems(_model.getProductDataList());
        _view.getTableView().setOnMouseClicked(new TableViewClickedHandler());
    }

    private void loadDetailView(ProductData itemToLoad) {
        ProductData productDataToLoad;
        productDataToLoad = getProductDataFromTableViewItem(itemToLoad);
        _view.getIdLabel().setText(Integer.toString(productDataToLoad.getId()));
        _view.getMemoryContentLabel().setText(productDataToLoad.getMemoryContent());
        _view.getReferencesLabel().setText(productDataToLoad.getReferences());
        _view.getEstimationLabel().setText(productDataToLoad.getEstimation());
        _view.getRetLabel().setText(Integer.toString(productDataToLoad.getRet()));
        _view.getDetLabel().setText(Integer.toString(productDataToLoad.getDet()));
        _view.getClassificationLabel().setText(productDataToLoad.getClassification().getClassification());
    }

    private void clearDetailView() {
        _view.getIdLabel().setText("");
        _view.getMemoryContentLabel().setText("");
        _view.getReferencesLabel().setText("");
        _view.getEstimationLabel().setText("");
        _view.getRetLabel().setText("");
        _view.getDetLabel().setText("");
        _view.getClassificationLabel().setText("");
    }

    private ProductData getProductDataFromTableViewItem(ProductData itemToLoad) {
        ProductData productData;
        Integer index;
        index = _model.getFunctionalRequirementList().indexOf(itemToLoad);
        productData = _model.getProductDataList().get(index);

        return productData;
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                IStageController controller = new CreateProductDataController(_model);
                controller.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                IStageController controller = new CreateProductDataController(_model,
                        getProductDataFromTableViewItem(_selectedTableViewItem));
                controller.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Boolean delete;
            delete = openDeleteQuery();
            if (delete) {
                _model.getProductDataList().remove(_selectedTableViewItem);
                clearDetailView();
            }
        }
    }

    private class TableViewClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            _selectedTableViewItem = (ProductData) _view.getTableView().getSelectionModel().getSelectedItem();
            loadDetailView(_selectedTableViewItem);
        }
    }
}
