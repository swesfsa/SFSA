package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import misc.ProductData;
import misc.ProductDataClassification;
import model.IModel;
import view.CreateProductDataView;
import view.EmptyTextFieldException;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController extends ControllerTemplate {

    private Stage _stage;
    private CreateProductDataView _view;

    private String _memoryContent;
    private String _references;
    private String _estimation;
  
    private int _id;
    private int _ret;
    private int _det;

    private ProductDataClassification _classification = null;
  
    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataController(IModel model) throws Exception {

        _model = model;
        _view = new CreateProductDataView(model);

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    /**
     * @author 1030129
     */
    public void show() {
        _stage = new Stage();
        _view.show(_stage);
    }

    public void close() {
        _view.close(_stage);
    }

    /**
     * This function gets the data out of the TextFields, TextArea and ChoiceBoxes
     * of the CreateProductDataView.
     * @author 1030129
     */
    private void getDataFromView() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException {
        _memoryContent = _view.getMemoryContent().getText();
        _references = _view.getReferences().getText();
        _estimation = _view.getEstimation().getText();
        checkForEmptyFields();

        _classification = _view.getClassificationMap().get(_view.getClassification().getValue());
        checkForEmptyChoiceBox();

        _id = Integer.parseInt(_view.getId().getText());
        _ret = Integer.parseInt(_view.getRet().getText());
        _det = Integer.parseInt(_view.getDet().getText());
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

                ProductData productData = new ProductData(_id, _ret, _det, _memoryContent, _estimation, _references, _classification);

                _model.addProductData(productData);
                close();

                _model.getProductDataList().iterator().forEachRemaining(ProductData::print);
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
        }
    }
}
