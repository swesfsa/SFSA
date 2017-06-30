package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.TargetSpecification;
import model.IModel;
import exception.EmptyTextFieldException;
import view.TargetSpecificationView;

/**
 * Created by marcostierle on 28.04.17.
 */
public class TargetSpecificationController extends TabController {

    private TargetSpecificationView _view;

    private String _targetSpecString;

    public TargetSpecificationController(IModel model) throws Exception {

        _model = model;
        _view = new TargetSpecificationView(_model);
        _anchorPane = _view.get_anchorPane();

        _view.get_saveButton().setOnAction(new SaveButtonEventHandler());
        _view.get_editButton().setOnAction(new EditButtonEventHandler());
        _view.get_deleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    private void getDataFromView() {
        _targetSpecString = _view.get_targetSpecification().getText();
    }

    private void checkForEmptyFields() throws EmptyTextFieldException {
        if (_targetSpecString.equals("")) {
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

                TargetSpecification targetSpecification = new TargetSpecification(_targetSpecString);
                _model.set_targetSpecification(targetSpecification);
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
