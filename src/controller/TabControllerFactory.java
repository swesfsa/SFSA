package controller;

import model.IModel;
import view.*;

import java.io.IOException;

import static misc.Log.LOGGER;

/**
 * Created by tmonn on 25.06.2017.
 */
class TabControllerFactory {
    /**
     * Don't let anyone instantiate this class.
     */
    private TabControllerFactory() {}

    /**
     * Static factory method
     */
    static ITabController create(ETabController type, IModel iModel) {

        ITabController iController = null;

        try {
            switch(type) {
                case ENVIRONMENT_CONTROLLER:
                    IEnvironmentView iEnvironmentView = ViewFacade.createEnvironmentView(iModel);
                    iController = new EnvironmentController(iModel, iEnvironmentView);
                    LOGGER.info("EnvironmentController instantiated");

                    break;
                case FUNCTIONAL_REQUIREMENTS_CONTROLLER:
                    IFunctionalRequirementsView iFunctionalRequirementsView =
                            ViewFacade.createFunctionalRequirementsView(iModel);
                    iController = new FunctionalRequirementsController(iModel, iFunctionalRequirementsView);
                    LOGGER.info("FunctionalRequirementsController instantiated");
                    break;
                case PRODUCT_DATA_CONTROLLER:
                    IProductDataView iProductDataView = ViewFacade.createProductDataView(iModel);
                    iController = new ProductDataController(iModel, iProductDataView);
                    LOGGER.info("ProductDataController instantiated");
                    break;
                case PRODUCT_USE_CONTROLLER:
                    IProductUseView iProductUseView = ViewFacade.createProductUseView(iModel);
                    iController = new ProductUseController(iModel, iProductUseView);
                    LOGGER.info("ProductUseController instantiated");
                    break;
                case TARGET_SPECIFICATION_CONTROLLER:
                    ITargetSpecificationView iTargetSpecificationView =
                            ViewFacade.createTargetSpecificationView(iModel);
                    iController = new TargetSpecificationController(iModel, iTargetSpecificationView);
                    LOGGER.info("TargetSpecificationController instantiated");
                    break;
                case ESTIMATION_CONFIGURATION_CONTROLLER:
                    IEstimationConfigurationView iEstimationConfigurationView =
                            ViewFacade.createEstimationConfigurationView(iModel);
                    iController = new EstimationConfigurationController(iModel, iEstimationConfigurationView);
                    LOGGER.info("EstimationConfigurationController instantiated");
                    break;
                case COST_ESTIMATION_CONTROLLER:
                    ICostEstimationView iCostEstimationView =
                            ViewFacade.createCostEstimationView(iModel);
                    iController = new CostEstimationController(iModel, iCostEstimationView);
                    LOGGER.info("CostEstimationController instantiated");
                    break;
                default:
                    LOGGER.warning("No tab controller type matched");
                    break;
            }
        } catch (IOException e) {
            System.out.println(e);
            LOGGER.severe("IO Exception creating View from FXML");
        }
        return iController;
    }

}
