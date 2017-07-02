package controller;

import exception.EmptyTextFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.TargetSpecification;
import model.IModel;
import view.ITargetSpecificationView;

import static misc.Log.LOGGER;

/**
 * Created by marcostierle on 28.04.17.
 */
class TargetSpecificationController extends TabController {

    private ITargetSpecificationView _iView;

    TargetSpecificationController(IModel iModel, ITargetSpecificationView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _iView.getEditButton().setOnAction(new EditButtonEventHandler());
        _iView.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

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
                TargetSpecification targetSpecification = _iView.getTargetSpecification();
                targetSpecification.check();
                _iModel.setTargetSpecification(targetSpecification);
                toggleEditMode(false);
                LOGGER.info("Target Specification saved in Model");
            } catch (EmptyTextFieldException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openEmptyTextFieldWarning();
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

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            boolean delete;
            delete = openDeleteQuery();
            if (delete) {
                _iModel.setTargetSpecification(new TargetSpecification(""));
            }
        }
    }
}
