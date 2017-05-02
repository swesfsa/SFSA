package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.IModel;
import view.DeleteWindowView;

/**
 * Created by marcostierle on 27.04.17.
 */
public class DeleteWindowController {

    private IModel model;

    private DeleteWindowView view;

    /**
     * @author 1030129
     * @throws Exception
     */
    public DeleteWindowController(IModel model) throws Exception{

        this.model = model;
        this.view = new DeleteWindowView(model);

        view.getYesButton().setOnAction(new yesButtonEventHandler());
        view.getNoButton().setOnAction(new noButtonEventHandler());
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        view.show(stage);
    }

    /**
     * @author 1030129
     */
    class yesButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("yesButton clicked");
        }
    }

    /**
     * @author 1030129
     */
    class noButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("noButton clicked");
        }
    }
}
