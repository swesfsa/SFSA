package sfsa;

import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;
import misc.StageHandler;
import model.IModel;
import model.Model;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        //DeleteWindowController controller = new DeleteWindowController();
        //controller.show(primaryStage);

        //SFSAController sfsaController = new SFSAController();
        //sfsaController.show(primaryStage);

        //CreateProductDataController createProductDataController = new CreateProductDataController();
        //createProductDataController.show(primaryStage);

/**
 * @author 9459758
 * example using mvc model
 * todo: adding fxml import to view classes
 */

        // store Stage instance in Singleton Pattern to be accessed by views
        StageHandler.getInstance().setPrimaryStage(primaryStage);

        IModel model = new Model();

        IController controller = new SFSAController(model);
        //IController controller = new CreateProductDataController(model);
        //IController controller = new CreateFunctionalRequirementController(model);
        controller.show();

    }

}