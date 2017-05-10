package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import misc.StageHandler;
import model.IModel;
import view.SFSAView;

public class SFSAController extends ControllerTemplate implements IController {

   private SFSAView _view;

   public SFSAController(IModel model) throws Exception{

       _model = model;
       _view = new SFSAView(model);

       _view.getTargetSpecification().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       _view.getEnvironment().setOnSelectionChanged(new EnvironmentTabEventHandler());
       _view.getProductUse().setOnSelectionChanged(new ProductUseTabEventHandler());
       _view.getFunctionalRequirements().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       _view.getProductData().setOnSelectionChanged(new ProductDataTabEventHandler());
       _view.getEstimationConfig().setOnSelectionChanged(new EstimationConfigTabEventHandler());
       _view.getEffortEstimation().setOnSelectionChanged(new EffortEstimationTabEventHandler());
   }

   public void show() {
       _view.show(StageHandler.getInstance().getPrimaryStage());
   }

   class TargetSpecificationTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("targetSpecificationTab clicked");
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
               IController controller = new FunctionalRequirementsController(_model);
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

}
