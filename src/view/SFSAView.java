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

    private IModel _model;

    private Scene _scene;

    private TabPane _tabPane;
    private Tab _targetSpecificationTab;
    private Tab _environmentTab;
    private Tab _productUseTab;
    private Tab _functionalRequirementsTab;
    private Tab _productDataTab;
    private Tab _estimationConfigTab;
    private Tab _costEstimationTab;

    private MenuBar _menuBar;
    private Menu _fileMenu;
    private Menu _xml;
    private MenuItem _closeItem;
    private MenuItem _import;
    private MenuItem _export;

    /**
     * @author 1030129
     * @throws Exception
     */
    public SFSAView(IModel model) throws Exception{

        super("SFSA");
        _model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/SFSA.fxml"));

        _tabPane = (TabPane) root.lookup("#tabPane");
        _targetSpecificationTab = _tabPane.getTabs().get(0);
        _environmentTab = _tabPane.getTabs().get(1);
        _productUseTab = _tabPane.getTabs().get(2);
        _functionalRequirementsTab = _tabPane.getTabs().get(3);
        _productDataTab = _tabPane.getTabs().get(4);
        _estimationConfigTab = _tabPane.getTabs().get(5);
        _costEstimationTab = _tabPane.getTabs().get(6);

        _menuBar = (MenuBar) root.lookup("#menuBar");
        _fileMenu = _menuBar.getMenus().get(0);
        _closeItem = _fileMenu.getItems().get(4);
        _xml = _menuBar.getMenus().get(2);
        _import = _xml.getItems().get(0);
        _export = _xml.getItems().get(1);



        _scene = new Scene(root, 1000, 600);
    }

    /**
     * @author 1030129
     * @param stage
     */
    public void show(Stage stage) {
        stage.setScene(_scene);
        stage.setTitle("SFSA - Software für standardisierte Anforderungssammlung");
        stage.show();
    }

    public void close(Stage stage) {
        stage.close();
    }

    /**
     * @author 1030129
     * @return _targetSpecificationTab
     */
    public Tab get_targetSpecificationTab() {
        return _targetSpecificationTab;
    }

    /**
     * @author 1030129
     * @return _productUseTab
     */
    public Tab get_productUseTab() {
        return _productUseTab;
    }

    /**
     * @author 1030129
     * @return _functionalRequirementsTab
     */
    public Tab get_functionalRequirementsTab() {
        return _functionalRequirementsTab;
    }

    /**
     * @author 1030129
     * @return _productDataTab
     */
    public Tab get_productDataTab() {
        return _productDataTab;
    }

    /**
     * @author 1030129
     * @return _environmentTab
     */
    public Tab get_environmentTab() {
        return _environmentTab;
    }

    public Tab get_estimationConfigTab() {
        return _estimationConfigTab;
    }

    public Tab get_costEstimationTab() {
        return _costEstimationTab;
    }

    public MenuItem get_closeItem() {
        return _closeItem;
    }

    public MenuItem getImportItem() {
        return _import;
    }

    public MenuItem getExportItem() {
        return _export;
    }
}
