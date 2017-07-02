package view;

import model.IModel;

import java.io.IOException;

import static misc.Log.LOGGER;

/**
 * Created by tmonn on 30.06.2017.
 */
public class ViewFacade {

    private ViewFacade() {}

    public static ICreateFunctionalRequirementView createCreateFunctionalRequirementView(IModel iModel) throws IOException {
        return new CreateFunctionalRequirementView(iModel);
    }

    public static ICreateProductDataView createCreateProductDataView(IModel iModel) throws IOException {
        return new CreateProductDataView(iModel);
    }

    public static IEnvironmentView createEnvironmentView(IModel iModel) throws IOException {
        EnvironmentView environmentView = new EnvironmentView(iModel);
        iModel.addObserver(environmentView);
        return environmentView;
    }

    public static IFunctionalRequirementsView createFunctionalRequirementsView(IModel iModel) throws IOException {
        FunctionalRequirementsView functionalRequirementsView = new FunctionalRequirementsView(iModel);
        iModel.addObserver(functionalRequirementsView);
        return functionalRequirementsView;
    }

    public static IProductDataView createProductDataView(IModel iModel) throws IOException {
        ProductDataView productDataView = new ProductDataView(iModel);
        iModel.addObserver(productDataView);
        return productDataView;
    }

    public static IProductUseView createProductUseView(IModel iModel) throws IOException {
        LOGGER.info("ProductUseView instantiation started");
        ProductUseView productUseView = new ProductUseView(iModel);
        LOGGER.info("ProductUseView instantiated");
        iModel.addObserver(productUseView);
        return productUseView;
    }

    public static ISFSAView createSFSAView(IModel iModel) throws IOException {
        return new SFSAView();
    }

    public static ITargetSpecificationView createTargetSpecificationView(IModel iModel) throws IOException {
        TargetSpecificationView targetSpecificationView = new TargetSpecificationView(iModel);
        iModel.addObserver(targetSpecificationView);
        return targetSpecificationView;
    }

    public static IEstimationConfigurationView createEstimationConfigurationView(IModel iModel) throws IOException {
        EstimationConfigurationView estimationConfigurationView = new EstimationConfigurationView(iModel);
        iModel.addObserver(estimationConfigurationView);
        return estimationConfigurationView;
    }

    public static ICostEstimationView createCostEstimationView(IModel iModel) throws IOException {
        CostEstimationView costEstimationView = new CostEstimationView(iModel);
        iModel.addObserver(costEstimationView);
        return costEstimationView;
    }

}
