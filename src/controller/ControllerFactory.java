package controller;

import model.IModel;

/**
 * Created by tmonn on 25.06.2017.
 */
class ControllerFactory {
    static ITabController create(java.lang.Class controller, IModel model) {
        ITabController iController = null;
        try{
            if(controller.equals(EnvironmentController.class))
                iController = new EnvironmentController(model);
            else if(controller.equals(FunctionalRequirementsController.class))
                iController = new FunctionalRequirementsController(model);
            else if(controller.equals(ProductDataController.class))
                iController = new ProductDataController(model);
            else if(controller.equals(ProductUseController.class))
                iController = new ProductUseController(model);
            else if(controller.equals(TargetSpecificationController.class))
                iController = new TargetSpecificationController(model);
        } catch(Exception e) {
            System.out.println(e);
        }
        return iController;
    }
}
