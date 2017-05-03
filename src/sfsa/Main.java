package sfsa;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import misc.FunctionalRequirement;
import misc.Priority;
import misc.StageHandler;
import model.IModel;
import model.Model;
import view.CreateProductDataView;
import view.DeleteWindowView;
import view.CreateFunctionalRequirementView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
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
        /*model.addFunctionalRequirement(new FunctionalRequirement(1, "Peter Bohl", "Test", Priority.LOW));
        model.addFunctionalRequirement(new FunctionalRequirement(2, "Tim Seitz", "ABC", Priority.HIGH));
        model.addFunctionalRequirement(new FunctionalRequirement(3, "Marco Stierle", "Test", Priority.HIGH));
        model.addFunctionalRequirement(new FunctionalRequirement(4, "Dr. Dre", "2001", Priority.MIDDLE));
        model.addFunctionalRequirement(new FunctionalRequirement(5, "Future", "Mask Off", Priority.HIGH));*/

        IController controller = new CreateFunctionalRequirementController(model);
        controller.show();
    }

}