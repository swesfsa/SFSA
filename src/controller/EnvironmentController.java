package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.Environment;
import model.IModel;
import view.EmptyTextFieldException;
import view.EnvironmentView;


/**
 * Created by 1030129 on 02.05.17.
 */
public class EnvironmentController extends TabController {

    private static EnvironmentController instance;
    private EnvironmentView _view;

    private Environment environment;
    private String hardwareEnvironment;
    private String softwareEnvironment;

    public EnvironmentController(IModel model) throws Exception{

        _model = model;
        _view = new EnvironmentView(model);
        anchorPane = _view.getAnchorPane();

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

    public void getDataFromView() throws EmptyTextFieldException {
        hardwareEnvironment = _view.getHardwareEnvironment().getText();
        softwareEnvironment = _view.getSoftwareEnvironment().getText();
        checkForEmptyFields();
    }

    private void checkForEmptyFields() throws EmptyTextFieldException {
        if (hardwareEnvironment.equals("") || softwareEnvironment.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    public class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            try {
                getDataFromView();

                environment = new Environment(hardwareEnvironment, softwareEnvironment);

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
