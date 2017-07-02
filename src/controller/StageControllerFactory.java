package controller;

import model.IModel;
import view.ICreateFunctionalRequirementView;
import view.ICreateProductDataView;
import view.ISFSAView;
import view.ViewFacade;

import static misc.Log.LOGGER;

/**
 * Created by tmonn on 30.06.2017.
 */
public class StageControllerFactory {
    /**
     * Don't let anyone instantiate this class.
     */
    private StageControllerFactory() {}

    /**
     * Static factory method
     */
    public static IStageController create(EStageController type, IModel iModel) {

        IStageController iController = null;

        try {
            switch(type) {
                case CREATE_PRODUCT_DATA_CONTROLLER:
                    ICreateProductDataView iCreateProductDataView = ViewFacade.createCreateProductDataView(iModel);
                    iController = new CreateProductDataController(iModel, iCreateProductDataView);
                    LOGGER.info("CreateProductDataController instantiated");
                    break;
                case CREATE_FUNCTIONAL_REQUIREMENT_CONTROLLER:
                    ICreateFunctionalRequirementView iCreateFunctionalRequirementView =
                            ViewFacade.createCreateFunctionalRequirementView(iModel);
                    iController = new CreateFunctionalRequirementController(iModel, iCreateFunctionalRequirementView);
                    LOGGER.info("CreateFunctionalRequirementsController instantiated");
                    break;
                case SFSA_CONTROLLER:
                    ISFSAView iSFSAView = ViewFacade.createSFSAView(iModel);
                    iController = new SFSAController(iModel, iSFSAView);
                    LOGGER.info("SFSAController instantiated");
                default:
                    LOGGER.warning("No stage controller type matched");
                    break;
            }
        } catch (Exception e) {
            LOGGER.severe("IO Exception creating View from FXML: " + e);
        }
        return iController;
    }

    static ICreateItemController createWArg(EStageController type, IModel iModel, Object arg) {
        ICreateItemController controller = (ICreateItemController) create(type, iModel);
        controller.setArg(arg);
        return controller;
    }
}
