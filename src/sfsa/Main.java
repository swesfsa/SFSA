package sfsa;

import controller.CreateProductDataController;
import controller.DeleteWindowController;
import controller.SFSAController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import misc.FunctionalRequirement;
import model.IModel;
import view.CreateProductDataView;
import view.DeleteWindowView;
import view.CreateFunctionalRequirementView;

import java.util.List;

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
        //createProductDataController.show();

    }

}
