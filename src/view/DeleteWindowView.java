package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by marcostierle on 27.04.17.
 */
public class DeleteWindowView {

    public DeleteWindowView() {

    }

    public void openDeleteWindow(Stage deleteStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/DeleteWindow.fxml"));
        Scene scene = new Scene(root, 400, 200);
        deleteStage.setScene(scene);
        deleteStage.show();
        deleteStage.setResizable(false);
    }
}
