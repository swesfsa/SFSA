package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.WindowEvent;
import misc.EFileExtension;
import misc.FileIO;
import misc.StageHandler;
import model.IModel;
import org.xml.sax.SAXException;
import view.ISFSAView;

import javax.xml.bind.JAXBException;
import java.io.File;

import static controller.ETabController.*;
import static misc.Log.LOGGER;

public class SFSAController extends ControllerTemplate implements IStageController {

   private ISFSAView _iView;
   private ITabController _iController;

   public SFSAController(IModel iModel, ISFSAView iView) {

       _iModel = iModel;
       _iView = iView;

       _iView.getTargetSpecificationTab().setOnSelectionChanged(new TargetSpecificationTabEventHandler());
       _iView.getEnvironmentTab().setOnSelectionChanged(new EnvironmentTabEventHandler());
       _iView.getProductUseTab().setOnSelectionChanged(new ProductUseTabEventHandler());
       _iView.getFunctionalRequirementsTab().setOnSelectionChanged(new FunctionalRequirementsTabEventHandler());
       _iView.getProductDataTab().setOnSelectionChanged(new ProductDataTabEventHandler());
       _iView.getEstimationConfigTab().setOnSelectionChanged(new EstimationConfigTabEventHandler());
       _iView.getCostEstimationTab().setOnSelectionChanged(new CostEstimationTabEventHandler());
       _iView.getCloseItem().setOnAction(new CloseItemEventHandler());
       _iView.getXMLImportItem().setOnAction(new XMLImportItemEventHandler());
       _iView.getXMLExportItem().setOnAction(new XMLExportItemEventHandler());
       _iView.getNewItem().setOnAction(new NewItemEventHandler());
       _iView.getOpenItem().setOnAction(new OpenItemEventHandler());
       _iView.getSaveItem().setOnAction(new SaveItemEventHandler());
       _iView.getSaveAsItem().setOnAction(new SaveAsItemEventHandler());
       _iView.getAboutItem().setOnAction(new AboutItemEventHandler());

       StageHandler.getInstance().getPrimaryStage().setOnCloseRequest(new CloseRequestEventHandler());

       new TargetSpecificationTabEventHandler().handle(null);
   }

   public void show() {
       _iView.show(StageHandler.getInstance().getPrimaryStage());
   }

   class TargetSpecificationTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(TARGET_SPECIFICATION_CONTROLLER, _iModel);
               _iView.getTargetSpecificationTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
       }
   }

   class EnvironmentTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(ENVIRONMENT_CONTROLLER, _iModel);
               _iView.getEnvironmentTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
       }
   }

   class ProductUseTabEventHandler implements  EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(PRODUCT_USE_CONTROLLER, _iModel);
               _iView.getProductUseTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
       }
   }

   class FunctionalRequirementsTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(FUNCTIONAL_REQUIREMENTS_CONTROLLER, _iModel);
               _iView.getFunctionalRequirementsTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
       }
   }

   class ProductDataTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(PRODUCT_DATA_CONTROLLER, _iModel);
               _iView.getProductDataTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
       }
   }

   class EstimationConfigTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(ESTIMATION_CONFIGURATION_CONTROLLER, _iModel);
               _iView.getEstimationConfigTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
       }
   }

   class CostEstimationTabEventHandler implements EventHandler<Event> {

       @Override
       public void handle(Event event) {
           try {
               _iController = TabControllerFactory.create(COST_ESTIMATION_CONTROLLER, _iModel);
               _iView.getCostEstimationTab().setContent(_iController.getAnchorPane());
           } catch (Exception e) {
               LOGGER.severe(e.toString() + " in " + getClass());
           }
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
                File file = FileIO.openFileChooser(EFileExtension.XML);
                if(file != null)
                    _iModel.xmlImport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                LOGGER.severe(e.toString() + " in " + getClass());
                openXMLErrorWarning("XML Import fehlgeschlagen - JAXBException");
            } catch (SAXException e) {
                e.printStackTrace();
                LOGGER.severe(e.toString() + " in " + getClass());
                openXMLErrorWarning("XML Import fehlgeschlagen - SAXException");
            }
        }
    }

    class XMLExportItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                File file = FileIO.saveAsFileChooser(EFileExtension.XML);
                if(file != null)
                    _iModel.xmlExport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                LOGGER.severe(e.toString() + " in " + getClass());
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
            _iModel.reset();
        }
    }

    class OpenItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            File file = FileIO.openFileChooser(EFileExtension.SFSA);
        }
    }

    class SaveItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            File file = _iModel.getFile();
            if(file == null) {
                file = FileIO.saveAsFileChooser(EFileExtension.SFSA);
                _iModel.setFile(file);
            }
            try {
                _iModel.xmlExport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                LOGGER.severe(e.toString() + " in " + getClass());
                openXMLErrorWarning("XML Export fehlgeschlagen - JAXBException");
            }
        }
    }

    class SaveAsItemEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            File file = FileIO.saveAsFileChooser(EFileExtension.SFSA);
            _iModel.setFile(file);
            try {
                _iModel.xmlExport(file);
            } catch (JAXBException e) {
                e.printStackTrace();
                LOGGER.severe(e.toString() + " in " + getClass());
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
