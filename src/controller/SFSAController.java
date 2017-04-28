package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.SFSAView;

public class SFSAController {

   private SFSAView view;

   public SFSAController() throws Exception{

       view = new SFSAView();
       view.getTargetSpecification().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       view.getProductUse().setOnSelectionChanged(new ProductUseTabEventHandler());
       view.getFunctionalRequirements().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       view.getProductData().setOnSelectionChanged(new ProductDataTabEventHandler());
   }

   public void show(Stage stage) {
       view.show(stage);
   }

   class TargetSpecificationTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           System.out.println("targetSpecificationTab clicked");
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
