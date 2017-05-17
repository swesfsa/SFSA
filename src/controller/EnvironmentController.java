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
    private IModel model;
    private EnvironmentView view;

    private Environment environment;
    private String hardwareEnvironment;
    private String softwareEnvironment;

    private EnvironmentController(IModel model) throws Exception{

        this.model = model;
        this.view = new EnvironmentView(model);

        Environment savedEnvironment = model.getEnvironment();
        String hardwareEnvironment = savedEnvironment.getHardwareEnvironment();
        String softwareEnvironment = savedEnvironment.getSoftwareEnvironment();

        view.getHardwareEnvironment().setText(hardwareEnvironment);
        view.getSoftwareEnvironment().setText(softwareEnvironment);

        view.getCancelButton().setDisable(true);
        view.getHardwareEnvironment().setEditable(false);
        view.getSoftwareEnvironment().setEditable(false);

        view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        view.getEditButton().setOnAction(new EditButtonEventHandler());
        view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    public synchronized static EnvironmentController getController(IModel model) throws Exception {

        if (instance == null) {
            instance = new EnvironmentController(model);
        }

        return instance;
    }

    private void getDataFromView() throws EmptyTextFieldException {
        hardwareEnvironment = view.getHardwareEnvironment().getText();
        softwareEnvironment = view.getSoftwareEnvironment().getText();
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

                model.setEnvironment(environment);

                view.getHardwareEnvironment().setEditable(false);
                view.getSoftwareEnvironment().setEditable(false);
                view.getEditButton().setDisable(false);
                view.getCancelButton().setDisable(true);

                // DEBUG
                model.getEnvironment().print();
            }
            catch (EmptyTextFieldException e) {
                openEmptyTextFieldWarning();
            }
        }
    }

    public class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            view.getHardwareEnvironment().setEditable(true);
            view.getSoftwareEnvironment().setEditable(true);
            view.getEditButton().setDisable(true);
            view.getCancelButton().setDisable(false);
        }
    }

    public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Environment savedEnvironment = model.getEnvironment();
            String hardwareEnvironment = savedEnvironment.getHardwareEnvironment();
            String softwareEnvironment = savedEnvironment.getSoftwareEnvironment();

            view.getHardwareEnvironment().setText(hardwareEnvironment);
            view.getSoftwareEnvironment().setText(softwareEnvironment);

            view.getHardwareEnvironment().setEditable(false);
            view.getSoftwareEnvironment().setEditable(false);
            view.getEditButton().setDisable(false);
            view.getCancelButton().setDisable(true);
        }
    }
}
