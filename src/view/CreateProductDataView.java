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
public class CreateProductDataView extends ViewTemplate implements ICreateProductDataView{

    private IModel model;

    private Scene scene;

    private Button saveButton;
    private Button cancelButton;

    private TextField id;
    private TextField memoryContent;
    private TextField references;
    private TextField ret;
    private TextField det;

    private TextArea estimation;

    private ChoiceBox<String> classification;
    private Map<String, ProductDataClassification> classificationMap;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataView(IModel model) throws Exception{

        super("CreateProductData");
        this.model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CreateProductData.fxml"));

        saveButton = (Button) root.lookup("#saveButton");
        cancelButton = (Button) root.lookup("#cancelButton");
        id = (TextField) root.lookup("#idField");
        memoryContent = (TextField) root.lookup("#memoryContentField");
        references = (TextField) root.lookup("#referencesField");
        ret = (TextField) root.lookup("#RETField");
        det = (TextField) root.lookup("#DETField");
        estimation = (TextArea) root.lookup("#estimationArea");
        classification = (ChoiceBox<String>) root.lookup("#classificationChoiceBox");

        classificationMap = new HashMap<>();
        for (ProductDataClassification iterate : ProductDataClassification.values()) {
            classification.getItems().add(iterate.getClassification());
            classificationMap.put(iterate.getClassification(), iterate);
        }

        scene = new Scene(root, 600, 400);
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {

        stage.setScene(scene);
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
        return saveButton;
    }

    /**
     * @author 1030129
     * @return
     */
    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getId() {
        return id;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getMemoryContent() {
        return memoryContent;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getReferences() {
        return references;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getRet() {
        return ret;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getDet() {
        return det;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextArea getEstimation() {
        return estimation;
    }

    /**
     * @author 1030129
     * @return
     */
    public ChoiceBox<String> getClassification() {
        return classification;
    }

    public Map<String, ProductDataClassification> getClassificationMap() {
        return classificationMap;
    }
}
