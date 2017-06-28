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

    private LocalDate _date;
    private String _title;
    private String _function;
    private String _protagonist;
    private String _source;
    private String _references;
    private String _description;
    private Priority _priority = null;
    private FunctionalRequirementClassification _classification = null;
    private int _id;
    private int _ftr;
    private int _det;

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

    public void loadData(FunctionalRequirement data) {

        _view.getDate().setValue(data.get_date());
        _view.getTitle().setText(data.get_title());
        _view.get_function().setText(data.get_function());
        _view.getProtagonist().setText(data.get_protagonist());
        _view.getSource().setText(data.get_source());
        _view.getReferences().setText(data.get_references());
        _view.get_description().setText(data.get_description());
        _view.get_priority().setValue(data.get_priority().get_priority());
        _view.get_classification().setValue(data.get_classification().get_classification());
        _view.getId().setText(Integer.toString(data.get_id()));
        _view.get_ftr().setText(Integer.toString(data.get_ftr()));
        _view.getDet().setText(Integer.toString(data.get_det()));
    }

    /**
     * This function gets the data out of the TextFields, TextArea and ChoiceBoxes
     * of the CreateFunctionalRequirementView.
     * @author 1030129
     */
    private void getDataFromView() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException {

        _date = _view.getDate().getValue();
        _title = _view.getTitle().getText();
        _function = _view.get_function().getText();
        _protagonist = _view.getProtagonist().getText();
        _source = _view.getSource().getText();
        _references = _view.getReferences().getText();
        _description = _view.get_description().getText();
        checkForEmptyFields();

        _priority = _view.get_priorityMap().get(_view.get_priority().getValue());
        _classification = _view.get_classificationMap().get(_view.get_classification().getValue());
        checkForEmptyChoiceBox();

        _id = Integer.parseInt(_view.getId().getText());
        _ftr = Integer.parseInt(_view.get_ftr().getText());
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

                FunctionalRequirement functionalRequirement = new FunctionalRequirement(_id, _ftr, _det, _date, _title, _function, _protagonist,
                        _source, _references, _description, _priority, _classification);

                _model.addFunctionalRequirement(functionalRequirement);
                close();

                // DEBUG
                _model.get_functionalRequirementList().iterator().forEachRemaining(FunctionalRequirement::print);
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
