package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.DeleteWindowView;

/**
 * Created by marcostierle on 27.04.17.
 */
public class DeleteWindowController {

    private DeleteWindowView view;

    /**
     * @author 1030129
     * @throws Exception
     */
    public DeleteWindowController() throws Exception{

        view = new DeleteWindowView();

        view.getYesButton().setOnAction(new yesButtonEventHandler());
        view.getNoButton().setOnAction(new noButtonEventHandler());
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void view(Stage stage) {
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
