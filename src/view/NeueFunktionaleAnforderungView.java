package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by marcostierle on 27.04.17.
 */
public class NeueFunktionaleAnforderungView {
    public NeueFunktionaleAnforderungView() {

    }

    public void openNeueFunktionaleAnforderung(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/NeueFunktionaleAnforderung.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
