package sfsa;

import controller.IStageController;
import controller.StageControllerFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import misc.Log;
import misc.StageHandler;
import model.IModel;
import model.Model;

import java.util.logging.Level;

import static controller.EStageController.SFSA_CONTROLLER;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    /**
     * @author 9459758
     * Start application with creation of iModel and launcher
     */

    @Override
    public void start(Stage primaryStage) {

        Log.setUp(Level.ALL);

        // store Stage instance in Singleton Pattern to be accessed by iViews
        StageHandler.getInstance().setPrimaryStage(primaryStage);
        IModel iModel = new Model();
        IStageController controller = StageControllerFactory.create(SFSA_CONTROLLER, iModel);
        controller.show();

    }

}