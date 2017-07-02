package controller;

import exception.EmptyChoiceBoxException;
import exception.EmptyTextFieldException;
import exception.IDAlreadyExistingException;
import exception.NumberSmallerOneException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import misc.EFunctionalRequirementClassification;
import misc.EPriority;
import misc.FunctionalRequirement;
import model.IModel;
import view.ICreateFunctionalRequirementView;

import java.time.LocalDate;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 02.05.17.
 */
public class CreateFunctionalRequirementController extends CreateItemController {

    private ICreateFunctionalRequirementView _iView;

    /**
     * @author 1030129
     * @throws Exception
     */
    CreateFunctionalRequirementController(IModel iModel, ICreateFunctionalRequirementView iView) {

        _iModel = iModel;
        _iView = iView;

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _iView.getCancelButton().setOnAction(new CancelButtonEventHandler());

        createNewItem();
    }

    /**
     * @author 1030129
     */
    public void show() {
        _stage = new Stage();
        _iView.show(_stage);
    }

    private void close() {
        _iView.close(_stage);
    }

    public void setArg(Object arg) {
        FunctionalRequirement data = (FunctionalRequirement) arg;
        editItem();
        if (_editMode) {
            _oldId = data.getId();
        }
        _iView.setFunctionalRequirement(data);
    }

    private void checkIfIDAlreadyExists(int id) throws IDAlreadyExistingException {
        for (FunctionalRequirement functionalRequirement : _iModel.getFunctionalRequirementList()) {
            if (functionalRequirement.getId() == id) {
                throw new IDAlreadyExistingException();
            }
        }
    }

    private void removeItemWithOldID() {
        FunctionalRequirement toRemove = null;

        for (FunctionalRequirement functionalRequirement : _iModel.getFunctionalRequirementList()) {
            if (functionalRequirement.getId() == _oldId) {
                toRemove = functionalRequirement;
            }
        }
        _iModel.getFunctionalRequirementList().remove(toRemove);
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
                FunctionalRequirement functionalRequirement = _iView.getFunctionalRequirement();
                functionalRequirement.check();
                if (!_editMode) {
                    checkIfIDAlreadyExists(functionalRequirement.getId());
                } else {
                    removeItemWithOldID();
                }
                _iModel.addFunctionalRequirement(functionalRequirement);
                LOGGER.info("New Functional Requirement saved in Model");
                close();
            }
            catch (NumberFormatException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openNumberFormatWarning("Die Textfelder 'ID', 'FTR' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextFieldException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openEmptyTextFieldWarning("Bitte füllen Sie alle erforderlichen Textfelder aus. ('Quelle' und 'Verweise' sind optional)");
            }
            catch (EmptyChoiceBoxException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openEmptyChoiceBoxWarning("Bitte wählen Sie in den Auswahllisten \"Priorität\" und \"Klassifikation\" ein Element aus.");
            }
            catch (NumberSmallerOneException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openNumberFormatWarning("Die Textfelder 'ID', 'FTR' und 'DET' erlauben nur Ganzzahlen > 0 als Eingabe!");
            }
            catch (IDAlreadyExistingException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openIDAlreadyExistingWarning();
            }

        }
    }
}
