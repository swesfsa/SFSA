package sfsa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.DeleteWindowView;
import view.NeueFunktionaleAnforderungView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));
        primaryStage.setTitle("SFSA - Software für standardisierte Anforderungssammlung");
        Scene scene = new Scene(root, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        DeleteWindowView deleteWindow = new DeleteWindowView();
        Stage deleteStage = new Stage();
        deleteWindow.openDeleteWindow(deleteStage);

        NeueFunktionaleAnforderungView fa = new NeueFunktionaleAnforderungView();
        Stage faStage = new Stage();
        fa.openNeueFunktionaleAnforderung(faStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
