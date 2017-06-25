package view;

import javafx.scene.control.Tab;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ISFSAView extends IView {

    Tab get_targetSpecificationTab();
    Tab get_productUseTab();
    Tab get_environmentTab();
    Tab get_functionalRequirementsTab();
    Tab get_productDataTab();
}
