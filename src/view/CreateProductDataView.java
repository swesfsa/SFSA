package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import misc.EProductDataClassification;
import misc.ProductData;
import model.IModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataView extends StageView implements ICreateProductDataView {

    private Scene _scene;

    private Button _saveButton;
    private Button _cancelButton;

    private TextField _id;
    private TextField _memoryContent;
    private TextField _references;
    private TextField _ret;
    private TextField _det;

    private TextArea _estimation;

    private ChoiceBox<String> _classification;
    private Map<String, EProductDataClassification> _classificationMap;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataView(IModel iModel) throws IOException {

        super("CreateProductData");
        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CreateProductData.fxml"));

        _saveButton = (Button) root.lookup("#saveButton");
        _cancelButton = (Button) root.lookup("#cancelButton");
        _id = (TextField) root.lookup("#idField");
        _memoryContent = (TextField) root.lookup("#memoryContentField");
        _references = (TextField) root.lookup("#referencesField");
        _ret = (TextField) root.lookup("#RETField");
        _det = (TextField) root.lookup("#DETField");
        _estimation = (TextArea) root.lookup("#estimationArea");
        _classification = (ChoiceBox<String>) root.lookup("#classificationChoiceBox");

        _classificationMap = new HashMap<>();
        for (EProductDataClassification iterate : EProductDataClassification.values()) {
            _classification.getItems().add(iterate.getClassification());
            _classificationMap.put(iterate.getClassification(), iterate);
        }
        _classification.setValue(EProductDataClassification.ILF.getClassification());

        _scene = new Scene(root, 600, 400);
    }

    public ProductData getProductData() {

        ProductData productData = new ProductData();
        productData.setId(Integer.parseInt(_id.getText()));
        productData.setMemoryContent(_memoryContent.getText());
        productData.setReferences(_references.getText());
        productData.setRet(Integer.parseInt(_ret.getText()));
        productData.setDet(Integer.parseInt(_det.getText()));
        productData.setEstimation(_estimation.getText());
        productData.setClassification(_classificationMap.get(_classification.getValue()));

        return productData;
    }

    public void setProductData(ProductData productData) {

        _memoryContent.setText(productData.getMemoryContent());
        _estimation.setText(productData.getEstimation());
        _references.setText(productData.getReferences());
        _classification.setValue(productData.getClassification().getClassification());
        _id.setText(Integer.toString(productData.getId()));
        _ret.setText(Integer.toString(productData.getRet()));
        _det.setText(Integer.toString(productData.getDet()));
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {

        stage.setScene(_scene);
        stage.setTitle("Erstellen eines neuen Produktdatums");
        stage.setResizable(false);
        stage.show();
    }

    public void close(Stage stage) {
        stage.close();
    }

    /**
     * @author 1030129
     * @return
     */
    public Button getSaveButton() {
        return _saveButton;
    }

    /**
     * @author 1030129
     * @return
     */
    public Button getCancelButton() {
        return _cancelButton;
    }
}
