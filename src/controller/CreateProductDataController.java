package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import misc.ProductData;
import misc.ProductDataClassification;
import misc.StageHandler;
import model.IModel;
import view.CreateProductDataView;
import view.EmptyTextfieldException;

import static misc.ProductDataClassification.EIF;
import static misc.ProductDataClassification.ILF;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataController extends CreateController implements IController {

    private IModel model;

    private CreateProductDataView view;

    private ProductData productData;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataController(IModel model) throws Exception {

        this.model = model;
        this.view = new CreateProductDataView(model);

        view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    /**
     * @author 1030129
     */
    public void show() {
        view.show(StageHandler.getInstance().getPrimaryStage());
    }

    public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            view.close(StageHandler.getInstance().getPrimaryStage());
        }
    }

    public class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {

            try {
                String memoryContent = view.getMemoryContent().getText();
                String references = view.getReferences().getText();
                String estimation = view.getEstimation().getText();

                ProductDataClassification classification = null;
                switch (view.getClassification().getValue()) {
                    case "ILF": classification = ILF;
                        break;
                    case "EIF": classification = EIF;
                        break;
                }

                if (memoryContent.equals("") || references.equals("") || estimation.equals("")) {
                    throw new EmptyTextfieldException();
                }

                int id = Integer.parseInt(view.getId().getText());
                int ret = Integer.parseInt(view.getRet().getText());
                int det = Integer.parseInt(view.getDet().getText());

                productData = new ProductData(id, ret, det, memoryContent, estimation, references, classification);

                model.addProductData(productData);
                view.close(StageHandler.getInstance().getPrimaryStage());

                model.getProductDataList().iterator().forEachRemaining(ProductData::print);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'RET' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextfieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            }
        }
    }
}
