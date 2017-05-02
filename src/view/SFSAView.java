package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 28.04.17.
 */
public class SFSAView implements ISFSAView {

    private Scene scene;

    private TabPane tabPane;
    private Tab targetSpecification;
    private Tab environment;
    private Tab productUse;
    private Tab functionalRequirements;
    private Tab productData;

    /**
     * @author 1030129
     * @throws Exception
     */
    public SFSAView() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));

        tabPane = (TabPane) root.lookup("#tabPane");
        targetSpecification = tabPane.getTabs().get(1);
        environment = tabPane.getTabs().get(2);
        productUse = tabPane.getTabs().get(3);
        functionalRequirements = tabPane.getTabs().get(4);
        productData = tabPane.getTabs().get(5);

        scene = new Scene(root, 1000, 600);
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        stage.setScene(scene);
        stage.setTitle("SFSA - Software für standardisierte Anforderungssammlung");
        stage.show();
    }

    /**
     * @author 1030129
     * @return targetSpecification
     */
    public Tab getTargetSpecification() {
        return targetSpecification;
    }

    /**
     * @author 1030129
     * @return productUse
     */
    public Tab getProductUse() {
        return productUse;
    }

    /**
     * @author 1030129
     * @return functionalRequirements
     */
    public Tab getFunctionalRequirements() {
        return functionalRequirements;
    }

    /**
     * @author 1030129
     * @return productData
     */
    public Tab getProductData() {
        return productData;
    }

    /**
     * @author 1030129
     * @return environmentf
     */
    public Tab getEnvironment() {
        return environment;
    }
}
