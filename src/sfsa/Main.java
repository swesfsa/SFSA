package sfsa;

import controller.DeleteWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.DeleteWindowView;
import view.CreateFunctionalRequirementView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
      /*  Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));
        primaryStage.setTitle("SFSA - Software für standardisierte Anforderungssammlung");
        Scene scene = new Scene(root, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.show();*/

        //DeleteWindowView deleteWindow = new DeleteWindowView();
        //Stage deleteStage = new Stage();
        //deleteWindow.show(primaryStage);

      /*  CreateFunctionalRequirementView fa = new CreateFunctionalRequirementView();
        Stage faStage = new Stage();
        fa.show(faStage);*/

        try {
            DeleteWindowController controller = new DeleteWindowController();
            controller.show(primaryStage);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

}
