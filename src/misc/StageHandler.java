package misc;

import javafx.stage.Stage;
/**
 * @author 9459758
 */
public class StageHandler {

    private static StageHandler instance;
    private static Stage primaryStage;

    /**
     * Private constructor
     * Class can't be instantiated from outside
     */
    private StageHandler() {
    }

    /**
     * Static method "getInstance()" returns instance of StageHandler
     * Singleton pattern - new instance if first call
     * Synchronized to be thread-secure
     */
    public synchronized static StageHandler getInstance()
    {
        if (instance == null) {
            instance = new StageHandler();
        }
        return instance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        StageHandler.primaryStage = primaryStage;
    }
}