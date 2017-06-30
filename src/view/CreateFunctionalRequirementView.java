package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import misc.FunctionalRequirementClassification;
import misc.Priority;
import model.IModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1030129 on 27.04.17.
 */
public class CreateFunctionalRequirementView extends CreateItemView implements ICreateFunctionalRequirementView {

    private Scene _scene;

    private Button _saveButton;
    private Button _cancelButton;

    private DatePicker _date;

    private TextField _id;
    private TextField _title;
    private TextField _function;
    private TextField _protagonist;
    private TextField _source;
    private TextField _references;
    private TextField _ftr;
    private TextField _det;

    private TextArea _description;

    private ChoiceBox<String> _priority;
    private ChoiceBox<String> _classification;
    private Map<String, Priority> _priorityMap;
    private Map<String, FunctionalRequirementClassification> _classificationMap;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateFunctionalRequirementView(IModel model) throws Exception {

        super("CreateFunctionalRequirement");
        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CreateFunctionalRequirement.fxml"));

        _saveButton = (Button) root.lookup("#saveButton");
        _cancelButton = (Button) root.lookup("#cancelButton");
        _date = (DatePicker) root.lookup("#datePicker");
        _id = (TextField) root.lookup("#idField");
        _title = (TextField) root.lookup("#titleField");
        _priority = (ChoiceBox<String>) root.lookup("#priority");
        _function = (TextField) root.lookup("#functionField");
        _protagonist = (TextField) root.lookup("#protagonistField");
        _source = (TextField) root.lookup("#sourceField");
        _references = (TextField) root.lookup("#referencesField");
        _description = (TextArea) root.lookup("#descriptionArea");
        _ftr = (TextField) root.lookup("#ftr");
        _det = (TextField) root.lookup("#det");
        _classification = (ChoiceBox<String>) root.lookup("#classification");

        _priorityMap = new HashMap<>();
        for (Priority iterate : Priority.values()) {
            _priority.getItems().add(iterate.getPriority());
            _priorityMap.put(iterate.getPriority(), iterate);
        }

        _classificationMap = new HashMap<>();
        for (FunctionalRequirementClassification iterate : FunctionalRequirementClassification.values()) {
            _classification.getItems().add(iterate.getClassification());
            _classificationMap.put(iterate.getClassification(), iterate);
        }

        _scene = new Scene(root, 600, 450);
        System.out.println("CreatedFRView Constructor finished");
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        stage.setScene(_scene);
        stage.setTitle("Erstellung einer neuen funktionalen Anforderung");
        stage.setResizable(false);
        stage.show();
        System.out.println("Stage created");
    }

    public void close(Stage stage) {
        stage.close();
    }

    /**
     * @author 1030129
     * @return _saveButton
     */
    public Button getSaveButton() {
        return _saveButton;
    }

    /**
     * @author 1030129
     * @return _cancelButton
     */
    public Button getCancelButton() {
        return _cancelButton;
    }

    /**
     * @author 1030129
     * @return _date
     */
    public DatePicker getDate() {
        return _date;
    }

    /**
     * @author 1030129
     * @return _id
     */
    public TextField getId() {
        return _id;
    }

    /**
     * @author 1030129
     * @return _title
     */
    public TextField getTitle() {
        return _title;
    }

    /**
     * @author 1030129
     * @return priotity
     */
    public ChoiceBox<String> getPriority() {
        return _priority;
    }

    /**
     * @author 1030129
     * @return _function
     */
    public TextField getFunction() {
        return _function;
    }

    /**
     * @author 1030129
     * @return _protagonist
     */
    public TextField getProtagonist() {
        return _protagonist;
    }

    /**
     * @author 1030129
     * @return _source
     */
    public TextField getSource() {
        return _source;
    }

    /**
     * @author 1030129
     * @return _references
     */
    public TextField getReferences() {
        return _references;
    }

    /**
     * @author 1030129
     * @return _description
     */
    public TextArea getDescription() {
        return _description;
    }

    /**
     * @author 1030129
     * @return _ftr
     */
    public TextField getFtr() {
        return _ftr;
    }

    /**
     * @author 1030129
     * @return _det
     */
    public TextField getDet() {
        return _det;
    }

    /**
     * @author 1030129
     * @return _classification
     */
    public ChoiceBox<String> getClassification() {
        return _classification;
    }

    public Map<String, Priority> getPriorityMap() {
        return _priorityMap;
    }

    public Map<String, FunctionalRequirementClassification> getClassificationMap() {
        return _classificationMap;
    }
}
