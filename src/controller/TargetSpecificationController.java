package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.TargetSpecification;
import model.IModel;
import view.EmptyTextFieldException;
import view.TargetSpecificationView;

/**
 * Created by marcostierle on 28.04.17.
 */
public class TargetSpecificationController extends TabController {

    private static TargetSpecificationController instance;
    private TargetSpecificationView _view;

    private TargetSpecification targetSpecification;
    private String targetSpecString;

    public TargetSpecificationController(IModel model) throws Exception {

        _model = model;
        _view = new TargetSpecificationView(_model);
        anchorPane = _view.getAnchorPane();

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    private void getDataFromView() {
        targetSpecString = _view.getTargetSpecification().getText();
    }

    private void checkForEmptyFields() throws EmptyTextFieldException {
        if (targetSpecString.equals("")) {
            throw new EmptyTextFieldException();
        }
    }

    private class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                System.out.println("saveButtonClicked");
                getDataFromView();
                checkForEmptyFields();

                targetSpecification = new TargetSpecification(targetSpecString);
                _model.setTargetSpecification(targetSpecification);
                targetSpecification.print();
            } catch (EmptyTextFieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("EditButtonClicked");
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("DeleteButtonClicked");
            openDeleteQuery();
        }
    }
}
