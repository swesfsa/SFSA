package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import model.IModel;
import view.FunctionalRequirementsView;

/**
 * Created by 1030129 on 02.05.17.
 */
public class FunctionalRequirementsController extends TabController {

    private static FunctionalRequirementsController instance;
    private FunctionalRequirementsView _view;

    public FunctionalRequirementsController(IModel model) throws Exception {

        _model = model;
        _view = new FunctionalRequirementsView(_model);
        anchorPane = _view.getAnchorPane();

        _view.getNewButton().setOnAction(new NewButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());
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
