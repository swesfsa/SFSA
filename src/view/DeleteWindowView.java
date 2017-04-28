package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 27.04.17.
 */
public class DeleteWindowView {

    private Scene scene;

    private Button yesButton;
    private Button noButton;

    /**
     * @author 1030129
     * @throws Exception
     */
    public DeleteWindowView() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/DeleteWindow.fxml"));

        yesButton = (Button) root.lookup("yesButton");
        noButton = (Button) root.lookup("noButton");

        scene = new Scene(root, 400, 200);
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    /**
     * @author 1030129
     * @return yesButton
     */
    public Button getYesButton() {
        return yesButton;
    }

    /**
     * @author 1030129
     * @return noButton
     */
    public Button getNoButton() {
        return noButton;
    }
}
