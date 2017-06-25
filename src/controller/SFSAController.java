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

       loadTargetSpecification();

       _view.get_targetSpecificationTab().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       _view.get_environmentTab().setOnSelectionChanged(new EnvironmentTabEventHandler());
       _view.get_productUseTab().setOnSelectionChanged(new ProductUseTabEventHandler());
       _view.get_functionalRequirementsTab().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       _view.get_productDataTab().setOnSelectionChanged(new ProductDataTabEventHandler());
       _view.get_estimationConfigTab().setOnSelectionChanged(new EstimationConfigTabEventHandler());
       _view.get_costEstimationTab().setOnSelectionChanged(new EffortEstimationTabEventHandler());
       _view.get_closeItem().setOnAction(new CloseItemEventHandler());
       _view.getImportItem().setOnAction(new ImportItemEventHandler());
       _view.getExportItem().setOnAction(new ExportItemEventHandler());
       StageHandler.get_instance().getPrimaryStage().setOnCloseRequest(new CloseRequestEventHandler());
   }

   public void show() {
       _view.show(StageHandler.get_instance().getPrimaryStage());
   }

   private void loadTargetSpecification() {
       try {
           IController controller = new TargetSpecificationController(_model);
           _view.get_targetSpecificationTab().setContent(controller.getAnchorPane());
           System.out.println(controller.toString());
       } catch (Exception e) {
           System.out.println(e);
       }
   }

   class TargetSpecificationTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           loadTargetSpecification();
       }
   }

   class EnvironmentTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               IController controller = new EnvironmentController(_model);
               _view.get_environmentTab().setContent(controller.getAnchorPane());
               System.out.println(controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class ProductUseTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               IController controller = new ProductUseController(_model);
               _view.get_productUseTab().setContent(controller.getAnchorPane());
               System.out.println(controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class FunctionalRequirementsTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               IController controller = new FunctionalRequirementsController(_model);
               _view.get_functionalRequirementsTab().setContent(controller.getAnchorPane());
               System.out.println(controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class ProductDataTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               IController controller = new ProductDataController(_model);
               _view.get_productDataTab().setContent(controller.getAnchorPane());
               System.out.println(controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
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

   class ImportItemEventHandler implements EventHandler<ActionEvent> {

       @Override
       public void handle(ActionEvent event) {
           System.out.println("import");
       }
   }

   class ExportItemEventHandler implements EventHandler<ActionEvent> {

       @Override
       public void handle(ActionEvent event) {
           System.out.println("export");
       }
   }

   class CloseRequestEventHandler implements EventHandler<WindowEvent> {
       @Override
       public void handle(WindowEvent event) {
           Platform.exit();
       }
   }

}
