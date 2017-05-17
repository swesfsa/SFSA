package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import misc.FunctionalRequirement;
import misc.FunctionalRequirementClassification;
import misc.Priority;
import model.IModel;
import view.CreateFunctionalRequirementView;
import view.EmptyTextFieldException;

import java.time.LocalDate;

/**
 * Created by 1030129 on 02.05.17.
 */
public class CreateFunctionalRequirementController extends ControllerTemplate {

    private Stage _stage;
    private CreateFunctionalRequirementView _view;
    private FunctionalRequirement functionalRequirement;

    private LocalDate date;
    private String title;
    private String function;
    private String protagonist;
    private String source;
    private String references;
    private String description;
    private Priority priority = null;
    private FunctionalRequirementClassification classification = null;
    private int id;
    private int ftr;
    private int det;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateFunctionalRequirementController(IModel model) throws Exception {

        _model = model;
        _view = new CreateFunctionalRequirementView(_model);
        
        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getCancelButton().setOnAction(new CancelButtonEventHandler());

    }

    /**
     * @author 1030129
     */
    public void show() {
        _stage = new Stage();
        _view.show(_stage);
    }

    private void close() {
        _view.close(_stage);
    }

    /**
     * This function gets the data out of the TextFields, TextArea and ChoiceBoxes
     * of the CreateFunctionalRequirementView.
     * @author 1030129
     */
    private void getDataFromView() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException {

        date = _view.getDate().getValue();
        title = _view.getTitle().getText();
        function = _view.getFunction().getText();
        protagonist = _view.getProtagonist().getText();
        source = _view.getSource().getText();
        references = _view.getReferences().getText();
        description = _view.getDescription().getText();
        checkForEmptyFields();

        priority = _view.getPriorityMap().get(_view.getPriority().getValue());
        classification = _view.getClassificationMap().get(_view.getClassification().getValue());
        checkForEmptyChoiceBox();

        id = Integer.parseInt(_view.getId().getText());
        ftr = Integer.parseInt(_view.getFtr().getText());
        det = Integer.parseInt(_view.getDet().getText());
        checkForNumbersSmallerOne();
    }

    /**
     * This function checks if any of the data elements gotten from the
     * CreateFunctionalRequirementView is empty.
     * @author 1030129
     * @throws EmptyTextFieldException
     */
    private void checkForEmptyFields() throws EmptyTextFieldException {

        if (date == null || title.equals("") || function.equals("") || protagonist.equals("")
                || source.equals("") || references.equals("") || description.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    private void checkForEmptyChoiceBox() throws EmptyChoiceBoxException {

        if (priority == null || classification == null) {
            throw new EmptyChoiceBoxException();
        }
    }

    private void checkForNumbersSmallerOne() throws NumberSmallerOneException {

        if (id < 1 || ftr < 1 || det < 1) {
            throw new NumberSmallerOneException();
        }
    }

    private class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            close();
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

                functionalRequirement = new FunctionalRequirement(id, ftr, det, date, title, function, protagonist,
                        source, references, description, priority, classification);

                _model.addFunctionalRequirement(functionalRequirement);
                close();

                // DEBUG
                _model.getFunctionalRequirementList().iterator().forEachRemaining(FunctionalRequirement::print);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'FTR' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            }
            catch (EmptyChoiceBoxException e) {
                System.out.println("Error: " + e);
                openEmptyChoiceBoxWarning("Bitte wählen Sie in den Auswahllisten \"Priorität\" und \"Klassifikation\" ein Element aus.");
            }
            catch (NumberSmallerOneException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'FTR' und 'DET' erlauben nur Ganzzahlen > 0 als Eingabe!");
            }

        }
    }
}
