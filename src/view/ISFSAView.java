package view;

import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ISFSAView extends IView {

    Tab getTargetSpecificationTab();
    Tab getProductUseTab();
    Tab getEnvironmentTab();
    Tab getFunctionalRequirementsTab();
    Tab getProductDataTab();
    Tab getEstimationConfigTab();
    Tab getCostEstimationTab();
    MenuItem getCloseItem();
    MenuItem getXMLImportItem();
    MenuItem getXMLExportItem();
    MenuItem getAboutItem();
    MenuItem getNewItem();
    MenuItem getOpenItem();
    MenuItem getSaveItem();
    MenuItem getSaveAsItem();


    }
