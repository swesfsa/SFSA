package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.IModel;
import view.FunctionalRequirementsView;

/**
 * Created by 1030129 on 02.05.17.
 */
public class FunctionalRequirementsController extends TabController {

    private FunctionalRequirementsView _view;

    public FunctionalRequirementsController(IModel model) throws Exception {

        _model = model;
        _view = new FunctionalRequirementsView(_model);
        _anchorPane = _view.get_anchorPane();

        _view.get_newButton().setOnAction(new NewButtonEventHandler());
        _view.get_editButton().setOnAction(new EditButtonEventHandler());
        _view.get_deleteButton().setOnAction(new DeleteButtonEventHandler());
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                IController controller = new CreateFunctionalRequirementController(_model);
                controller.show();
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
