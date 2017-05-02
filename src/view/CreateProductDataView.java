package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.IModel;

/**
 * Created by 1030129 on 29.04.17.
 */
public class CreateProductDataView implements ICreateProductDataView{

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

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateProductDataView(IModel model) throws Exception{

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

        classification.getItems().addAll("ILF", "EIF");
        classification.setValue("ILF");

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
    public TextField getID() {
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
    public TextField getRET() {
        return ret;
    }

    /**
     * @author 1030129
     * @return
     */
    public TextField getDET() {
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
    public String getClassificationValue() {
        return classification.getValue();
    }
}
