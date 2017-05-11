package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import model.IModel;

/**
 * Created by 1030129 on 28.04.17.
 */
public class SFSAView extends ViewTemplate implements ISFSAView {

    private IModel model;

    private Scene scene;

    private TabPane tabPane;
    private Tab targetSpecification;
    private Tab environment;
    private Tab productUse;
    private Tab functionalRequirements;
    private Tab productData;
    private Tab estimationConfig;
    private Tab effortEstimation;

    /**
     * @author 1030129
     * @throws Exception
     */
    public SFSAView(IModel model) throws Exception{

        super("SFSA");
        this.model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));

        tabPane = (TabPane) root.lookup("#tabPane");
        targetSpecification = tabPane.getTabs().get(0);
        environment = tabPane.getTabs().get(1);
        productUse = tabPane.getTabs().get(2);
        functionalRequirements = tabPane.getTabs().get(6);
        productData = tabPane.getTabs().get(3);
        estimationConfig = tabPane.getTabs().get(4);
        effortEstimation = tabPane.getTabs().get(5);

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
     * @return environment
     */
    public Tab getEnvironment() {
        return environment;
    }

    public Tab getEstimationConfig() {
        return estimationConfig;
    }

    public Tab getEffortEstimation() {
        return effortEstimation;
    }
}
