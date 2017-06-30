package controller;

import exception.EmptyChoiceBoxException;
import exception.IDAlreadyExistingException;
import exception.NumberSmallerOneException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import misc.ProductData;
import misc.ProductDataClassification;
import model.IModel;
import view.CreateProductDataView;
import exception.EmptyTextFieldException;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController extends CreateItemController {

    private CreateProductDataView _view;

    private String _memoryContent;
    private String _estimation;

    private int _ret;

    private ProductDataClassification _classification = null;
  
    /**
     * @author 1030129
     * @throws Exception
     */
    CreateProductDataController(IModel model) throws Exception {

        _model = model;
        _view = new CreateProductDataView(model);

        _view.get_saveButton().setOnAction(new SaveButtonEventHandler());
        _view.get_cancelButton().setOnAction(new CancelButtonEventHandler());

        createNewItem();
    }

    CreateProductDataController(IModel model, ProductData data) throws Exception {

        _model = model;
        _view = new CreateProductDataView(model);

        _view.get_saveButton().setOnAction(new SaveButtonEventHandler());
        _view.get_cancelButton().setOnAction(new CancelButtonEventHandler());

        editItem();
        loadData(data);
    }

    /**
     * @author 1030129
     */
    public void show() {
        _stage = new Stage();
        _view.show(_stage);
    }

    private void close() {
        _view.close(_stage);
    }

    private void loadData(ProductData data) {

        if (_editMode) {
            _oldId = data.get_id();
        }
        _view.get_memoryContent().setText(data.get_memoryContent());
        _view.get_estimation().setText(data.get_estimation());
        _view.get_references().setText(data.get_references());
        _view.get_classification().setValue(data.get_classification().get_classification());
        _view.get_id().setText(Integer.toString(data.get_id()));
        _view.get_ret().setText(Integer.toString(data.get_ret()));
        _view.get_det().setText(Integer.toString(data.get_det()));
    }

    /**
     * This function gets the data out of the TextFields, TextArea and ChoiceBoxes
     * of the CreateProductDataView.
     * @author 1030129
     */
    private void getDataFromView() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException {
        _memoryContent = _view.get_memoryContent().getText();
        _references = _view.get_references().getText();
        _estimation = _view.get_estimation().getText();
        checkForEmptyFields();

        _classification = _view.get_classificationMap().get(_view.get_classification().getValue());
        checkForEmptyChoiceBox();

        _id = Integer.parseInt(_view.get_id().getText());
        _ret = Integer.parseInt(_view.get_ret().getText());
        _det = Integer.parseInt(_view.get_det().getText());
        checkForNumbersSmallerOne();
    }

    /**
     * This function checks if any of the data elements gotten from the
     * CreateProductDataView is empty.
     * @author 1030129
     * @throws EmptyTextFieldException
     */
    private void checkForEmptyFields() throws EmptyTextFieldException {

        if (_memoryContent.equals("") || _references.equals("") || _estimation.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    private void checkForEmptyChoiceBox() throws EmptyChoiceBoxException {

        if (_classification == null) {
            throw new EmptyChoiceBoxException();
        }
    }

    private void checkForNumbersSmallerOne() throws NumberSmallerOneException {

        if (_id < 1 || _ret < 1 || _det < 1) {
            throw new NumberSmallerOneException();
        }
    }

    private void checkIfIDAlreadyExists() throws IDAlreadyExistingException {
        for (ProductData productData : _model.get_productDataList()) {
            if (productData.get_id() == _id) {
                throw new IDAlreadyExistingException();
            }
        }
    }

    private void removeItemWithOldID() {
        ProductData toRemove = null;

        for (ProductData productData : _model.get_productDataList()) {
            if (productData.get_id() == _oldId) {
                toRemove = productData;
            }
        }
        _model.get_productDataList().remove(toRemove);
    }

    private class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            close();
        }
    }

    private class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {

            try {
                getDataFromView();

                if (!_editMode) {
                    checkIfIDAlreadyExists();
                } else {
                    removeItemWithOldID();
                }

                ProductData productData = new ProductData(_id, _ret, _det, _memoryContent, _estimation, _references, _classification);

                _model.addProductData(productData);
                close();

                _model.get_productDataList().iterator().forEachRemaining(ProductData::print);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'RET' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            }
            catch (EmptyChoiceBoxException e) {
                System.out.println("Error: " + e);
                openEmptyChoiceBoxWarning("Bitte wählen Sie in der Auswahlliste \"Klassifikation\" ein Element aus.");
            }
            catch (NumberSmallerOneException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'RET' und 'DET' erlauben nur Ganzzahlen > 0 als Eingabe!");
            }
            catch (IDAlreadyExistingException e) {
                System.out.println("Error: " + e);
                openIDAlreadyExistingWarning(_id);
            }
        }
    }
}
