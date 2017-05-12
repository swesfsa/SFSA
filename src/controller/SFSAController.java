package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import misc.StageHandler;
import model.IModel;
import view.SFSAView;

public class SFSAController extends ControllerTemplate implements IController {

   private SFSAView _view;

   public SFSAController(IModel model) throws Exception{

       _model = model;
       _view = new SFSAView(model);

       try {
           IController controller = TargetSpecificationController.getController(_model);
           _view.getTargetSpecification().setContent(controller.getAnchorPane());
           System.out.println(controller.toString());
       } catch (Exception e) {
           System.out.println(e);
       }

       _view.getTargetSpecification().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       _view.getEnvironment().setOnSelectionChanged(new EnvironmentTabEventHandler());
       _view.getProductUse().setOnSelectionChanged(new ProductUseTabEventHandler());
       _view.getFunctionalRequirements().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       _view.getProductData().setOnSelectionChanged(new ProductDataTabEventHandler());
       _view.getEstimationConfig().setOnSelectionChanged(new EstimationConfigTabEventHandler());
       _view.getEffortEstimation().setOnSelectionChanged(new EffortEstimationTabEventHandler());
       _view.getCloseItem().setOnAction(new CloseItemEventHandler());
       StageHandler.getInstance().getPrimaryStage().setOnCloseRequest(new CloseRequestEventHandler());
   }

   public void show() {
       _view.show(StageHandler.getInstance().getPrimaryStage());
   }

   class TargetSpecificationTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               IController controller = TargetSpecificationController.getController(_model);
               _view.getTargetSpecification().setContent(controller.getAnchorPane());
               System.out.println(controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class EnvironmentTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("environmentTab clicked");
       }
   }

   class ProductUseTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("productUseTab clicked");
       }
   }

   class FunctionalRequirementsTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               IController controller = FunctionalRequirementsController.getController(_model);
               _view.getFunctionalRequirements().setContent(controller.getAnchorPane());
               System.out.println(controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class ProductDataTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("productDataTab clicked");
       }
   }

   class EstimationConfigTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("estimationConfigTab clicked");
       }
   }

   class EffortEstimationTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("effortEstimationTab clicked");
       }
   }

   class CloseItemEventHandler implements EventHandler<ActionEvent> {

       @Override
       public void handle(ActionEvent event) {
           Platform.exit();
       }
   }

   class CloseRequestEventHandler implements EventHandler<WindowEvent> {
       @Override
       public void handle(WindowEvent event) {
           Platform.exit();
       }
   }

}
