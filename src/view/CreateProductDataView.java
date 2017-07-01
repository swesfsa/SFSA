package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import misc.ProductDataClassification;
import model.IModel;

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
    private Map<String, ProductDataClassification> _classificationMap;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataView(IModel model) throws Exception{

        super("CreateProductData");
        _model = model;

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
        for (ProductDataClassification iterate : ProductDataClassification.values()) {
            _classification.getItems().add(iterate.getClassification());
            _classificationMap.put(iterate.getClassification(), iterate);
        }

        _scene = new Scene(root, 600, 400);
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

    /**
     * @author 1030129
     * @return
     */
    public TextField getId() {
        return _id;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getMemoryContent() {
        return _memoryContent;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getReferences() {
        return _references;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getRet() {
        return _ret;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getDet() {
        return _det;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextArea getEstimation() {
        return _estimation;
    }

    /**
     * @author 1030129
     * @return
     */
    public ChoiceBox<String> getClassification() {
        return _classification;
    }

    public Map<String, ProductDataClassification> getClassificationMap() {
        return _classificationMap;
    }
}
