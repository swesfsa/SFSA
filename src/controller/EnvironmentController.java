package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.Environment;
import model.IModel;
import view.EnvironmentView;


/**
 * Created by 1030129 on 02.05.17.
 */
public class EnvironmentController extends TabController {

    private EnvironmentView _view;

    private String _hardwareEnvironment;
    private String _softwareEnvironment;

    public EnvironmentController(IModel model) throws Exception{

        _model = model;
        _view = new EnvironmentView(model);
        _anchorPane = _view.get_anchorPane();

        Environment savedEnvironment = model.get_environment();
        String hardwareEnvironment = savedEnvironment.get_hardwareEnvironment();
        String softwareEnvironment = savedEnvironment.get_softwareEnvironment();

        _view.get_hardwareEnvironment().setText(hardwareEnvironment);
        _view.get_softwareEnvironment().setText(softwareEnvironment);

        _view.get_cancelButton().setDisable(true);
        _view.get_hardwareEnvironment().setEditable(false);
        _view.get_softwareEnvironment().setEditable(false);

        _view.get_saveButton().setOnAction(new SaveButtonEventHandler());
        _view.get_editButton().setOnAction(new EditButtonEventHandler());
        _view.get_cancelButton().setOnAction(new CancelButtonEventHandler());
    }

    private void getDataFromView() throws EmptyTextFieldException {
        _hardwareEnvironment = _view.get_hardwareEnvironment().getText();
        _softwareEnvironment = _view.get_softwareEnvironment().getText();
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

                _model.set_environment(environment);

                _view.get_hardwareEnvironment().setEditable(false);
                _view.get_softwareEnvironment().setEditable(false);
                _view.get_editButton().setDisable(false);
                _view.get_cancelButton().setDisable(true);

                // DEBUG
                _model.get_environment().print();
            }
            catch (EmptyTextFieldException e) {
                openEmptyTextFieldWarning();
            }
        }
    }

    public class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            _view.get_hardwareEnvironment().setEditable(true);
            _view.get_softwareEnvironment().setEditable(true);
            _view.get_editButton().setDisable(true);
            _view.get_cancelButton().setDisable(false);
        }
    }

    public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Environment savedEnvironment = _model.get_environment();
            String hardwareEnvironment = savedEnvironment.get_hardwareEnvironment();
            String softwareEnvironment = savedEnvironment.get_softwareEnvironment();

            _view.get_hardwareEnvironment().setText(hardwareEnvironment);
            _view.get_softwareEnvironment().setText(softwareEnvironment);

            _view.get_hardwareEnvironment().setEditable(false);
            _view.get_softwareEnvironment().setEditable(false);
            _view.get_editButton().setDisable(false);
            _view.get_cancelButton().setDisable(true);
        }
    }
}
