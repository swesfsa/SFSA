package controller;

import exception.EmptyChoiceBoxException;
import exception.EmptyTextFieldException;
import exception.IDAlreadyExistingException;
import exception.NumberSmallerOneException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import misc.EProductDataClassification;
import misc.FunctionalRequirement;
import misc.ProductData;
import model.IModel;
import view.ICreateProductDataView;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController extends CreateItemController {

    private ICreateProductDataView _iView;

    /**
     * @author 1030129
     * @throws Exception
     */
    CreateProductDataController(IModel iModel, ICreateProductDataView iView) {

        _iModel = iModel;
        _iView = iView;

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _iView.getCancelButton().setOnAction(new CancelButtonEventHandler());

        createNewItem();
    }

    /**
     * @author 1030129
     */
    public void show() {
        _stage = new Stage();
        _iView.show(_stage);
    }

    private void close() {
        _iView.close(_stage);
    }

    public void setArg(Object arg) {
        ProductData data = (ProductData) arg;
        editItem();
        if (_editMode) {
            _oldId = data.getId();
        }
        _iView.setProductData(data);
    }

    private void checkIfIDAlreadyExists(int id) throws IDAlreadyExistingException {
        for (ProductData productData : _iModel.getProductDataList()) {
            if (productData.getId() == id) {
                throw new IDAlreadyExistingException();
            }
        }
    }

    private void removeItemWithOldID() {
        ProductData toRemove = null;

        for (ProductData productData : _iModel.getProductDataList()) {
            if (productData.getId() == _oldId) {
                toRemove = productData;
            }
        }
        _iModel.getProductDataList().remove(toRemove);
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
                ProductData productData = _iView.getProductData();
                productData.check();
                if (!_editMode) {
                    checkIfIDAlreadyExists(productData.getId());
                } else {
                    removeItemWithOldID();
                }
                _iModel.addProductData(productData);
                LOGGER.info("New Product Data saved in Model");

                close();
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'RET' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning("Bitte füllen Sie alle erforderlichen Textfelder aus. ('Verweise' sind optional)");
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
                openIDAlreadyExistingWarning();
            }

        }
    }
}
