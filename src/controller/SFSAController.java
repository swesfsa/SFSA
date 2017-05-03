package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import misc.StageHandler;
import model.IModel;
import view.SFSAView;

public class SFSAController implements IController {

   private IModel model;

   private SFSAView view;

   public SFSAController(IModel model) throws Exception{

       this.model = model;
       this.view = new SFSAView(model);

       view.getTargetSpecification().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       view.getProductUse().setOnSelectionChanged(new ProductUseTabEventHandler());
       view.getFunctionalRequirements().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       view.getProductData().setOnSelectionChanged(new ProductDataTabEventHandler());
   }

   public void show() {
       view.show(StageHandler.getInstance().getPrimaryStage());
   }

   class TargetSpecificationTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("targetSpecificationTab clicked");
       }
   }

   class EnvironmentTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {

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
           System.out.println("functionaleRequirementsTab clicked");
       }
   }

   class ProductDataTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("productDataTab clicked");
       }
   }

}
