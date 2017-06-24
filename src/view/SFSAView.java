package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.IModel;

/**
 * Created by 1030129 on 28.04.17.
 */
public class SFSAView extends ViewTemplate implements ISFSAView {

    private IModel model;

    private Scene scene;

    private TabPane tabPane;
    private Tab targetSpecificationTab;
    private Tab environmentTab;
    private Tab productUseTab;
    private Tab functionalRequirementsTab;
    private Tab productDataTab;
    private Tab estimationConfigTab;
    private Tab costEstimationTab;

    private MenuBar menuBar;
    private Menu fileMenu;
    private MenuItem closeItem;

    /**
     * @author 1030129
     * @throws Exception
     */
    public SFSAView(IModel model) throws Exception{

        super("SFSA");
        this.model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));

        tabPane = (TabPane) root.lookup("#tabPane");
        targetSpecificationTab = tabPane.getTabs().get(0);
        environmentTab = tabPane.getTabs().get(1);
        productUseTab = tabPane.getTabs().get(2);
        functionalRequirementsTab = tabPane.getTabs().get(3);
        productDataTab = tabPane.getTabs().get(4);
        estimationConfigTab = tabPane.getTabs().get(5);
        costEstimationTab = tabPane.getTabs().get(6);

        menuBar = (MenuBar) root.lookup("#menuBar");
        fileMenu = menuBar.getMenus().get(0);
        closeItem = fileMenu.getItems().get(4);

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

    public void close(Stage stage) {
        stage.close();
    }

    /**
     * @author 1030129
     * @return targetSpecificationTab
     */
    public Tab getTargetSpecificationTab() {
        return targetSpecificationTab;
    }

    /**
     * @author 1030129
     * @return productUseTab
     */
    public Tab getProductUseTab() {
        return productUseTab;
    }

    /**
     * @author 1030129
     * @return functionalRequirementsTab
     */
    public Tab getFunctionalRequirementsTab() {
        return functionalRequirementsTab;
    }

    /**
     * @author 1030129
     * @return productDataTab
     */
    public Tab getProductDataTab() {
        return productDataTab;
    }

    /**
     * @author 1030129
     * @return environmentTab
     */
    public Tab getEnvironmentTab() {
        return environmentTab;
    }

    public Tab getEstimationConfigTab() {
        return estimationConfigTab;
    }

    public Tab getCostEstimationTab() {
        return costEstimationTab;
    }

    public MenuItem getCloseItem() {
        return closeItem;
    }
}
