package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.WindowEvent;
import misc.FileExtension;
import misc.FileIO;
import misc.StageHandler;
import model.IModel;
import org.xml.sax.SAXException;
import view.ISFSAView;
import view.SFSAView;

import javax.xml.bind.JAXBException;
import java.io.File;

public class SFSAController extends ControllerTemplate implements IStageController {

   private ISFSAView _view;
   private ITabController _controller;

   public SFSAController(IModel model) throws Exception{

       _model = model;
       _view = new SFSAView();

       loadTargetSpecification();

       _view.getTargetSpecificationTab().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       _view.getEnvironmentTab().setOnSelectionChanged(new EnvironmentTabEventHandler());
       _view.getProductUseTab().setOnSelectionChanged(new ProductUseTabEventHandler());
       _view.getFunctionalRequirementsTab().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       _view.getProductDataTab().setOnSelectionChanged(new ProductDataTabEventHandler());
       _view.getEstimationConfigTab().setOnSelectionChanged(new EstimationConfigTabEventHandler());
       _view.getCostEstimationTab().setOnSelectionChanged(new EffortEstimationTabEventHandler());
       _view.getCloseItem().setOnAction(new CloseItemEventHandler());
       _view.getXMLImportItem().setOnAction(new XMLImportItemEventHandler());
       _view.getXMLExportItem().setOnAction(new XMLExportItemEventHandler());
       _view.getNewItem().setOnAction(new NewItemEventHandler());
       _view.getOpenItem().setOnAction(new OpenItemEventHandler());
       _view.getSaveItem().setOnAction(new SaveItemEventHandler());
       _view.getSaveAsItem().setOnAction(new SaveAsItemEventHandler());
       _view.getAboutItem().setOnAction(new AboutItemEventHandler());

       StageHandler.getInstance().getPrimaryStage().setOnCloseRequest(new CloseRequestEventHandler());
   }

   public void show() {
       _view.show(StageHandler.getInstance().getPrimaryStage());
   }

   private void loadTargetSpecification() {
       try {
           _controller = ControllerFactory.create(TargetSpecificationController.class, _model);
           _view.getTargetSpecificationTab().setContent(_controller.getAnchorPane());
           System.out.println(_controller.toString());
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
               _controller = ControllerFactory.create(EnvironmentController.class, _model);
               _view.getEnvironmentTab().setContent(_controller.getAnchorPane());
               System.out.println(_controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class ProductUseTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _controller = ControllerFactory.create(ProductUseController.class, _model);
               _view.getProductUseTab().setContent(_controller.getAnchorPane());
               System.out.println(_controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class FunctionalRequirementsTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _controller = ControllerFactory.create(FunctionalRequirementsController.class, _model);
               _view.getFunctionalRequirementsTab().setContent(_controller.getAnchorPane());
               System.out.println(_controller.toString());
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }

   class ProductDataTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _controller = ControllerFactory.create(ProductDataController.class, _model);
               _view.getProductDataTab().setContent(_controller.getAnchorPane());
               System.out.println(_controller.toString());
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

    class XMLImportItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                File file = FileIO.openFileChooser(FileExtension.XML);
                _model.xmlImport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                openXMLErrorWarning("XML Import fehlgeschlagen - JAXBException");
            } catch (SAXException e) {
                e.printStackTrace();
                openXMLErrorWarning("XML Import fehlgeschlagen - SAXException");
            }
        }
    }

    class XMLExportItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                File file = FileIO.saveAsFileChooser(FileExtension.XML);
                _model.xmlExport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                openXMLErrorWarning("XML Export fehlgeschlagen - JAXBException");
            }
        }
    }

    class CloseRequestEventHandler implements EventHandler<WindowEvent> {
        @Override
        public void handle(WindowEvent event) {
            Platform.exit();
        }
    }

    class NewItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            _model.reset();
        }
    }

    class OpenItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            File file = FileIO.openFileChooser(FileExtension.SFSA);
        }
    }

    class SaveItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            File file = _model.getFile();
            if(file == null) {
                file = FileIO.saveAsFileChooser(FileExtension.SFSA);
                _model.setFile(file);
            }
            try {
                _model.xmlExport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                openXMLErrorWarning("XML Export fehlgeschlagen - JAXBException");
            }
        }
    }

    class SaveAsItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            File file = FileIO.saveAsFileChooser(FileExtension.SFSA);
            _model.setFile(file);
            try {
                _model.xmlExport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                openXMLErrorWarning("XML Export fehlgeschlagen - JAXBException");
            }
        }
    }

    class AboutItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            openAboutInformation();
        }
    }

    private void openXMLErrorWarning(String contentText) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warnung");
        alert.setHeaderText("XML Im-/Export fehlgeschlagen");
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private void openAboutInformation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Über");
        alert.setContentText("Entwickelt von 1030129, 4985749 und 9459758");
        alert.showAndWait();
    }
}
