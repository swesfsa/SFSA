package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.ProductData;
import misc.ProductDataClassification;
import misc.StageHandler;
import model.IModel;
import view.CreateProductDataView;
import view.EmptyTextFieldException;

import static misc.ProductDataClassification.EIF;
import static misc.ProductDataClassification.ILF;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController extends ControllerTemplate {

    private IModel model;

    private CreateProductDataView _view;

    private ProductData productData;

    private String memoryContent;
    private String references;
    private String estimation;
    private ProductDataClassification classification = null;
    private int id;
    private int ret;
    private int det;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataController(IModel model) throws Exception {

        this.model = model;
        this._view = new CreateProductDataView(model);

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    /**
     * @author 1030129
     */
    public void show() {
        _view.show(StageHandler.getInstance().getPrimaryStage());
    }

    /**
     * This function gets the data out of the TextFields, TextArea and ChoiceBoxes
     * of the CreateProductDataView.
     * @author 1030129
     */
    private void getDataFromView() {
        memoryContent = _view.getMemoryContent().getText();
        references = _view.getReferences().getText();
        estimation = _view.getEstimation().getText();

        switch (_view.getClassification().getValue()) {
            case "ILF": classification = ILF;
                break;
            case "EIF": classification = EIF;
                break;
        }

        id = Integer.parseInt(_view.getId().getText());
        ret = Integer.parseInt(_view.getRet().getText());
        det = Integer.parseInt(_view.getDet().getText());
    }

    /**
     * This function checks if any of the data elements gotten from the
     * CreateProductDataView is empty.
     * @author 1030129
     * @throws EmptyTextFieldException
     */
    private void checkForEmptyFields() throws EmptyTextFieldException {
        if (memoryContent.equals("") || references.equals("") || estimation.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    private class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            _view.close(StageHandler.getInstance().getPrimaryStage());
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
                checkForEmptyFields();

                productData = new ProductData(id, ret, det, memoryContent, estimation, references, classification);

                model.addProductData(productData);
                _view.close(StageHandler.getInstance().getPrimaryStage());

                model.getProductDataList().iterator().forEachRemaining(ProductData::print);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'RET' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            }
        }
    }
}
