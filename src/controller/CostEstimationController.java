package controller;

import exception.NumberSmallerOneException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.CostEstimation;
import misc.FPCalc;
import misc.FunctionPoints;
import model.IModel;
import view.ICostEstimationView;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 30.06.17.
 */
public class CostEstimationController extends TabController {

    private ICostEstimationView _iView;

    CostEstimationController(IModel iModel, ICostEstimationView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _iView.getEditButton().setOnAction(new EditButtonEventHandler());
        _iView.getExecuteButton().setOnAction(new ExecuteButtonEventHandler());

        _editable = false;
    }

    private void toggleEditMode(boolean editable) {
        _iView.setEditable(editable);
        _editable = editable;
    }

    private class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                CostEstimation costEstimation = _iView.getCostEstimation();
                costEstimation.check();
                _iModel.setCostEstimation(costEstimation);
                LOGGER.info("CostEstimation saved in Model");
            } catch (NumberFormatException e) {
                openNumberFormatWarning("Bitte geben Sie nur Zahlen in die Textfelder ein. " +
                        "Die Felder 'ungewichtete Function Points', 'gewichtete Function Points' " +
                        "und 'Personen' dürfen zudem nur Ganzzahlen enthalten.");
                LOGGER.severe(e.toString() + " in " + getClass());
            } catch (NumberSmallerOneException e) {
                openNumberFormatWarning("Bitte geben Sie nur positive Zahlen ein.");
                LOGGER.severe(e.toString() + " in " + getClass());
            }
            toggleEditMode(false);
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (!_editable) {
                toggleEditMode(true);
            } else {
                toggleEditMode(false);
                _iView.update(null, null);
            }
        }
    }

    private class ExecuteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            CostEstimation costEstimation = _iModel.costEstimationCalculation();
            _iModel.setCostEstimation(costEstimation);
        }
    }
}
