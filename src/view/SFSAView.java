package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 28.04.17.
 */
public class SFSAView {

    private Scene scene;

    private TabPane tabPane;
    private Tab targetSpecification;
    private Tab productUse;
    private Tab functionalRequirements;
    private Tab productData;


    public SFSAView() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));

        tabPane = (TabPane) root.lookup("#tabPane");
        targetSpecification = tabPane.getTabs().get(1);
        productUse = tabPane.getTabs().get(3);
        functionalRequirements = tabPane.getTabs().get(4);
        productData = tabPane.getTabs().get(5);

        scene = new Scene(root, 1000, 600);
    }

    public void show(Stage stage) {
        stage.setScene(scene);
        stage.setTitle("SFSA - Software für standardisierte Anforderungssammlung");
        stage.show();
    }

    public Tab getTargetSpecification() {
        return targetSpecification;
    }

    public Tab getProductUse() {
        return productUse;
    }

    public Tab getFunctionalRequirements() {
        return functionalRequirements;
    }

    public Tab getProductData() {
        return productData;
    }
}
