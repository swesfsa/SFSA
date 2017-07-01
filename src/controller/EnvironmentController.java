package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.Environment;
import model.IModel;
import exception.EmptyTextFieldException;
import view.EnvironmentView;
import view.IEnvironmentView;


/**
 * Created by 1030129 on 02.05.17.
 */
class EnvironmentController extends TabController {

    private IEnvironmentView _view;

    private String _hardwareEnvironment;
    private String _softwareEnvironment;

    EnvironmentController(IModel model) throws Exception{

        _model = model;
        _view = new EnvironmentView(model);
        _anchorPane = _view.getAnchorPane();

        Environment savedEnvironment = model.getEnvironment();
        String hardwareEnvironment = savedEnvironment.getHardwareEnvironment();
        String softwareEnvironment = savedEnvironment.getSoftwareEnvironment();

        _view.getHardwareEnvironment().setText(hardwareEnvironment);
        _view.getSoftwareEnvironment().setText(softwareEnvironment);

        _view.getCancelButton().setDisable(true);
        _view.getHardwareEnvironment().setEditable(false);
        _view.getSoftwareEnvironment().setEditable(false);

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    private void getDataFromView() throws EmptyTextFieldException {
        _hardwareEnvironment = _view.getHardwareEnvironment().getText();
        _softwareEnvironment = _view.getSoftwareEnvironment().getText();
        checkForEmptyFields();
    }

    private void checkForEmptyFields() throws EmptyTextFieldException {
        if (_hardwareEnvironment.equals("") || _softwareEnvironment.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    public class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            try {
                getDataFromView();

                Environment environment = new Environment(_hardwareEnvironment, _softwareEnvironment);

                _model.setEnvironment(environment);

                _view.getHardwareEnvironment().setEditable(false);
                _view.getSoftwareEnvironment().setEditable(false);
                _view.getEditButton().setDisable(false);
                _view.getCancelButton().setDisable(true);

                // DEBUG
                _model.getEnvironment().print();
            }
            catch (EmptyTextFieldException e) {
                openEmptyTextFieldWarning();
            }
        }
    }

    public class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            _view.getHardwareEnvironment().setEditable(true);
            _view.getSoftwareEnvironment().setEditable(true);
            _view.getEditButton().setDisable(true);
            _view.getCancelButton().setDisable(false);
        }
    }

    public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Environment savedEnvironment = _model.getEnvironment();
            String hardwareEnvironment = savedEnvironment.getHardwareEnvironment();
            String softwareEnvironment = savedEnvironment.getSoftwareEnvironment();

            _view.getHardwareEnvironment().setText(hardwareEnvironment);
            _view.getSoftwareEnvironment().setText(softwareEnvironment);

            _view.getHardwareEnvironment().setEditable(false);
            _view.getSoftwareEnvironment().setEditable(false);
            _view.getEditButton().setDisable(false);
            _view.getCancelButton().setDisable(true);
        }
    }
}
