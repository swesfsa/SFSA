package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import misc.EFunctionalRequirementClassification;
import misc.EPriority;
import misc.FunctionalRequirement;
import model.IModel;
import sun.util.calendar.BaseCalendar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 27.04.17.
 */
public class CreateFunctionalRequirementView extends StageView implements ICreateFunctionalRequirementView {

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
    private Map<String, EPriority> _priorityMap;
    private Map<String, EFunctionalRequirementClassification> _classificationMap;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateFunctionalRequirementView(IModel iModel) throws IOException {

        super("CreateFunctionalRequirement");
        _iModel = iModel;

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
        for (EPriority iterate : EPriority.values()) {
            _priority.getItems().add(iterate.getPriority());
            _priorityMap.put(iterate.getPriority(), iterate);
        }
        _priority.setValue(EPriority.MIDDLE.getPriority());

        _classificationMap = new HashMap<>();
        for (EFunctionalRequirementClassification iterate : EFunctionalRequirementClassification.values()) {
            _classification.getItems().add(iterate.getClassification());
            _classificationMap.put(iterate.getClassification(), iterate);
        }
        _classification.setValue(EFunctionalRequirementClassification.INPUT.getClassification());

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

    public FunctionalRequirement getFunctionalRequirement() {
        Date date = Date.from(_date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        FunctionalRequirement functionalRequirement = new FunctionalRequirement();
        functionalRequirement.setDate(date);
        functionalRequirement.setId(Integer.parseInt(_id.getText()));
        functionalRequirement.setTitle(_title.getText());
        functionalRequirement.setPriority(_priorityMap.get(_priority.getValue()));
        functionalRequirement.setFunction(_function.getText());
        functionalRequirement.setProtagonist(_protagonist.getText());
        functionalRequirement.setSource(_source.getText());
        functionalRequirement.setReferences(_references.getText());
        functionalRequirement.setDescription(_description.getText());
        functionalRequirement.setFtr(Integer.parseInt(_ftr.getText()));
        functionalRequirement.setDet(Integer.parseInt(_det.getText()));
        functionalRequirement.setClassification(_classificationMap.get(_classification.getValue()));

        return functionalRequirement;

    }

    public void setFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        LocalDate date = functionalRequirement.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        _date.setValue(date);
        _id.setText(Integer.toString(functionalRequirement.getId()));
        _title.setText(functionalRequirement.getTitle());
        _priority.setValue(functionalRequirement.getPriority().getPriority());
        _function.setText(functionalRequirement.getFunction());
        _protagonist.setText(functionalRequirement.getProtagonist());
        _source.setText(functionalRequirement.getSource());
        _references.setText(functionalRequirement.getReferences());
        _ftr.setText(Integer.toString(functionalRequirement.getFtr()));
        _det.setText(Integer.toString(functionalRequirement.getDet()));
        _classification.setValue(functionalRequirement.getClassification().getClassification());
        _description.setText(functionalRequirement.getDescription());

    }

}
