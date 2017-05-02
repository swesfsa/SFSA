package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.IModel;

/**
 * Created by 1030129 on 27.04.17.
 */
public class CreateFunctionalRequirementView implements ICreateFunctionalRequirementView {

    private IModel model;

    private Scene scene;

    private Button saveButton;
    private Button cancelButton;

    private DatePicker date;

    private TextField id;
    private TextField title;
    private TextField function;
    private TextField protagonist;
    private TextField source;
    private TextField references;

    private TextArea description;

    private ChoiceBox<String> priority;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateFunctionalRequirementView(IModel model) throws Exception {

        this.model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CreateFunctionalRequirement.fxml"));

        saveButton = (Button) root.lookup("#saveButton");
        cancelButton = (Button) root.lookup("#cancelButton");
        date = (DatePicker) root.lookup("#datePicker");
        id = (TextField) root.lookup("#idField");
        title = (TextField) root.lookup("#titleField");
        priority = (ChoiceBox<String>) root.lookup("#priority");
        function = (TextField) root.lookup("#functionField");
        protagonist = (TextField) root.lookup("#protagonistField");
        source = (TextField) root.lookup("#sourceField");
        references = (TextField) root.lookup("#referencesField");
        description = (TextArea) root.lookup("#descriptionArea");

        priority.getItems().addAll("Niedrig", "Mittel", "Hoch");
        priority.setValue("Mittel");

        scene = new Scene(root, 600, 400);
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        stage.setScene(scene);
        stage.setTitle("Erstellung einer neuen funktionalen Anforderung");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @author 1030129
     * @return saveButton
     */
    public Button getSaveButton() {
        return saveButton;
    }

    /**
     * @author 1030129
     * @return cancelButton
     */
    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * @author 1030129
     * @return date
     */
    public DatePicker getDate() {
        return date;
    }

    /**
     * @author 1030129
     * @return id
     */
    public TextField getID() {
        return id;
    }

    /**
     * @author 1030129
     * @return title
     */
    public TextField getTitle() {
        return title;
    }

    /**
     * @author 1030129
     * @return priotity
     */
    public String getPriority() {
        return priority.getValue();
    }

    /**
     * @author 1030129
     * @return function
     */
    public TextField getFunction() {
        return function;
    }

    /**
     * @author 1030129
     * @return protagonist
     */
    public TextField getProtagonist() {
        return protagonist;
    }

    /**
     * @author 1030129
     * @return source
     */
    public TextField getSource() {
        return source;
    }

    /**
     * @author 1030129
     * @return references
     */
    public TextField getReferences() {
        return references;
    }

    /**
     * @author 1030129
     * @return description
     */
    public TextArea getDescription() {
        return description;
    }
}
