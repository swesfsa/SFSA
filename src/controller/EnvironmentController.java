package controller;

import exception.EmptyTextFieldException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.Environment;
import model.IModel;
import view.IEnvironmentView;

import static misc.Log.LOGGER;


/**
 * Created by 1030129 on 02.05.17.
 */
class EnvironmentController extends TabController {

    private IEnvironmentView _iView;

    EnvironmentController(IModel iModel, IEnvironmentView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _iView.getEditButton().setOnAction(new EditButtonEventHandler());
        _iView.getDeleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    private void toggleEditMode(boolean editable) {
        _iView.setEditable(editable);
        _editable = editable;
    }

    public class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            try {
                Environment environment = _iView.getEnvironment();
                environment.check();
                _iModel.setEnvironment(environment);
                LOGGER.info("Environment saved in Model");
            }
            catch (EmptyTextFieldException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openEmptyTextFieldWarning();
            }
            toggleEditMode(false);
        }
    }

    public class EditButtonEventHandler implements EventHandler<ActionEvent> {

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

    public class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            boolean delete;
            delete = openDeleteQuery();
            if (delete) {
                _iView.setEnvironment(new Environment("", ""));
            }
        }
    }
}
