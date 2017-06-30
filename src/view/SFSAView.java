package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by 1030129 on 28.04.17.
 */
public class SFSAView extends ViewTemplate implements ISFSAView {

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
    private MenuItem _xmlImportItem;
    private MenuItem _xmlExportItem;
    private MenuItem _aboutItem;
    private MenuItem _saveItem;
    private MenuItem _newItem;
    private MenuItem _openItem;
    private MenuItem _saveAsItem;


    /**
     * @throws Exception
     * @author 1030129
     */
    public SFSAView() throws Exception {

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
        _newItem = _fileMenu.getItems().get(0);
        _openItem = _fileMenu.getItems().get(1);
        _saveItem = _fileMenu.getItems().get(2);
        _saveAsItem = _fileMenu.getItems().get(3);
        _closeItem = _fileMenu.getItems().get(4);

        _closeItem = _fileMenu.getItems().get(4);
        _xml = _menuBar.getMenus().get(2);
        _xmlImportItem = _xml.getItems().get(0);
        _xmlExportItem = _xml.getItems().get(1);

        _aboutItem = _menuBar.getMenus().get(3).getItems().get(0);


        _scene = new Scene(root, 1000, 600);
    }

    /**
     * @param stage
     * @author 1030129
     */
    public void show(Stage stage) {
        stage.setScene(_scene);
        stage.setTitle("SFSA - Software für standardisierte Anforderungssammlung");
        stage.show();
    }

    /**
     * @return _targetSpecificationTab
     * @author 1030129
     */
    public Tab getTargetSpecificationTab() {
        return _targetSpecificationTab;
    }

    /**
     * @return _productUseTab
     * @author 1030129
     */
    public Tab getProductUseTab() {
        return _productUseTab;
    }

    /**
     * @return _functionalRequirementsTab
     * @author 1030129
     */
    public Tab getFunctionalRequirementsTab() {
        return _functionalRequirementsTab;
    }

    /**
     * @return _productDataTab
     * @author 1030129
     */
    public Tab getProductDataTab() {
        return _productDataTab;
    }

    /**
     * @return _environmentTab
     * @author 1030129
     */
    public Tab getEnvironmentTab() {
        return _environmentTab;
    }

    public Tab getEstimationConfigTab() {
        return _estimationConfigTab;
    }

    public Tab getCostEstimationTab() {
        return _costEstimationTab;
    }

    public MenuItem getCloseItem() {
        return _closeItem;
    }

    public MenuItem getXMLImportItem() {
        return _xmlImportItem;
    }

    public MenuItem getXMLExportItem() {
        return _xmlExportItem;
    }

    public MenuItem getAboutItem() {
        return _aboutItem;
    }

    public void setAboutItem(MenuItem _aboutItem) {
        this._aboutItem = _aboutItem;
    }

    public MenuItem getNewItem() {
        return _newItem;
    }

    public void setNewItem(MenuItem newItem) {
        this._newItem = newItem;
    }

    public MenuItem getSaveItem() {
        return _saveItem;
    }

    public void setSaveItem(MenuItem _saveItem) {
        this._saveItem = _saveItem;
    }

    public MenuItem getOpenItem() {
        return _openItem;
    }

    public void setOpenItem(MenuItem _openItem) {
        this._openItem = _openItem;
    }

    public MenuItem getSaveAsItem() {
        return _saveAsItem;
    }

    public void setSaveAsItem(MenuItem _saveAsItem) {
        this._saveAsItem = _saveAsItem;
    }
}
