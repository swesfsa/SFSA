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
class TargetSpecificationController extends TabController {

    private TargetSpecificationView _view;

    private String _targetSpecString;

    TargetSpecificationController(IModel model) throws Exception {

        _model = model;
        _view = new TargetSpecificationView(_model);
        _anchorPane = _view.getAnchorPane();

        _view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    private void getDataFromView() {
        _targetSpecString = _view.getTargetSpecification().getText();
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
