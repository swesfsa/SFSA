package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 27.04.17.
 */
public class CreateFunctionalRequirementView {

    private Scene scene;

    private Button saveButton;
    private Button cancelButton;

    private DatePicker date;

    private TextField id;
    private TextField title;
    private TextField priority;
    private TextField function;
    private TextField protagonist;
    private TextField source;
    private TextField references;

    private TextArea description;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateFunctionalRequirementView() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CreateFunctionalRequirement.fxml"));

        saveButton = (Button) root.lookup("#saveButton");
        cancelButton = (Button) root.lookup("#cancelButton");
        date = (DatePicker) root.lookup("#datePicker");
        id = (TextField) root.lookup("#idField");
        title = (TextField) root.lookup("#titleField");
        priority = (TextField) root.lookup("#priorityField");
        function = (TextField) root.lookup("#functionField");
        protagonist = (TextField) root.lookup("#protagonistField");
        source = (TextField) root.lookup("#sourceField");
        references = (TextField) root.lookup("#referencesField");
        description = (TextArea) root.lookup("#descriptionArea");

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
}
