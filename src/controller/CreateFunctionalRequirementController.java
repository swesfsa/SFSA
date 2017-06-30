package controller;

import exception.EmptyChoiceBoxException;
import exception.IDAlreadyExistingException;
import exception.NumberSmallerOneException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import misc.FunctionalRequirement;
import misc.FunctionalRequirementClassification;
import misc.Priority;
import model.IModel;
import view.CreateFunctionalRequirementView;
import exception.EmptyTextFieldException;

import java.time.LocalDate;

/**
 * Created by 1030129 on 02.05.17.
 */
public class CreateFunctionalRequirementController extends StageController {

    private CreateFunctionalRequirementView _view;

    private LocalDate _date;
    private String _title;
    private String _function;
    private String _protagonist;
    private String _source;
    private String _description;
    private Priority _priority = null;
    private FunctionalRequirementClassification _classification = null;
    private int _ftr;

    /**
     * @author 1030129
     * @throws Exception
     */
    CreateFunctionalRequirementController(IModel model) throws Exception {

        _model = model;
        _view = new CreateFunctionalRequirementView(_model);

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getCancelButton().setOnAction(new CancelButtonEventHandler());

        createNewItem();
    }

    CreateFunctionalRequirementController(IModel model, FunctionalRequirement data) throws Exception {

        _model = model;
        _view = new CreateFunctionalRequirementView(_model);

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getCancelButton().setOnAction(new CancelButtonEventHandler());

        editItem();
        loadData(data);
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

    private void loadData(FunctionalRequirement data) {

        if (_editMode) {
            _oldId = data.getId();
        }
        _view.getDate().setValue(data.getDate());
        _view.getTitle().setText(data.getTitle());
        _view.getFunction().setText(data.getFunction());
        _view.getProtagonist().setText(data.getProtagonist());
        _view.getSource().setText(data.getSource());
        _view.getReferences().setText(data.getReferences());
        _view.getDescription().setText(data.getDescription());
        _view.getPriority().setValue(data.getPriority().getPriority());
        _view.getClassification().setValue(data.getClassification().getClassification());
        _view.getId().setText(Integer.toString(data.getId()));
        _view.getFtr().setText(Integer.toString(data.getFtr()));
        _view.getDet().setText(Integer.toString(data.getDet()));
    }

    /**
     * This function gets the data out of the TextFields, TextArea and ChoiceBoxes
     * of the CreateFunctionalRequirementView.
     * @author 1030129
     */
    private void getDataFromView() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException {

        _date = _view.getDate().getValue();
        _title = _view.getTitle().getText();
        _function = _view.getFunction().getText();
        _protagonist = _view.getProtagonist().getText();
        _source = _view.getSource().getText();
        _references = _view.getReferences().getText();
        _description = _view.getDescription().getText();
        checkForEmptyFields();

        _priority = _view.getPriorityMap().get(_view.getPriority().getValue());
        _classification = _view.getClassificationMap().get(_view.getClassification().getValue());
        checkForEmptyChoiceBox();

        _id = Integer.parseInt(_view.getId().getText());
        _ftr = Integer.parseInt(_view.getFtr().getText());
        _det = Integer.parseInt(_view.getDet().getText());
        checkForNumbersSmallerOne();
    }

    /**
     * This function checks if any of the data elements gotten from the
     * CreateFunctionalRequirementView is empty.
     * @author 1030129
     * @throws EmptyTextFieldException
     */
    private void checkForEmptyFields() throws EmptyTextFieldException {

        if (_date == null || _title.equals("") || _function.equals("") || _protagonist.equals("")
                || _source.equals("") || _references.equals("") || _description.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    private void checkForEmptyChoiceBox() throws EmptyChoiceBoxException {

        if (_priority == null || _classification == null) {
            throw new EmptyChoiceBoxException();
        }
    }

    private void checkForNumbersSmallerOne() throws NumberSmallerOneException {

        if (_id < 1 || _ftr < 1 || _det < 1) {
            throw new NumberSmallerOneException();
        }
    }

    private void checkIfIDAlreadyExists() throws IDAlreadyExistingException {
        for (FunctionalRequirement functionalRequirement : _model.getFunctionalRequirementList()) {
            if (functionalRequirement.getId() == _id) {
                throw new IDAlreadyExistingException();
            }
        }
    }

    private void removeItemWithOldID() {
        FunctionalRequirement toRemove = null;

        for (FunctionalRequirement functionalRequirement : _model.getFunctionalRequirementList()) {
            if (functionalRequirement.getId() == _oldId) {
                toRemove = functionalRequirement;
            }
        }
        _model.getFunctionalRequirementList().remove(toRemove);
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

                if (!_editMode) {
                    checkIfIDAlreadyExists();
                } else {
                    removeItemWithOldID();
                }

                FunctionalRequirement functionalRequirement = new FunctionalRequirement(_id, _ftr, _det, _date, _title, _function, _protagonist,
                        _source, _references, _description, _priority, _classification);

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
            catch (IDAlreadyExistingException e) {
                System.out.println("Error: " + e);
                openIDAlreadyExistingWarning(_id);
            }
        }
    }
}
