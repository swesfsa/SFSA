package view;

import javafx.scene.control.Tab;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ISFSAView extends IView {

    Tab getTargetSpecification();
    Tab getProductUse();
    Tab getEnvironment();
    Tab getFunctionalRequirements();
    Tab getProductData();
}
