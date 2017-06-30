package misc;

import javafx.stage.Stage;
/**
 * @author 9459758
 */
public class StageHandler {

    private static StageHandler _instance;
    private static Stage _primaryStage;

    /**
     * Private constructor
     * Class can't be instantiated from outside
     */
    private StageHandler() {
    }

    /**
     * Static method "get_instance()" returns _instance of StageHandler
     * Singleton pattern - new _instance if first call
     * Synchronized to be thread-secure
     */
    public synchronized static StageHandler getInstance()
    {
        if (_instance == null) {
            _instance = new StageHandler();
        }
        return _instance;
    }

    public Stage getPrimaryStage() {
        return _primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        StageHandler._primaryStage = primaryStage;
    }
}