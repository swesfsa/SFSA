package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import misc.Classification;
import misc.FunctionalRequirement;
import misc.Priority;
import misc.StageHandler;
import model.IModel;
import view.CreateFunctionalRequirementView;
import view.EmptyTextfieldException;

import java.time.LocalDate;

/**
 * Created by 1030129 on 02.05.17.
 */
public class CreateFunctionalRequirementController implements IController {

    private IModel model;

    private CreateFunctionalRequirementView view;

    private FunctionalRequirement functionalRequirement;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CreateFunctionalRequirementController(IModel model) throws Exception {

        this.model = model;
        this.view = new CreateFunctionalRequirementView(model);

        view.getSaveButton().setOnAction(new SaveButtonEventHandler());
        view.getCancelButton().setOnAction(new CancelButtonEventHandler());
    }

    /**
     * @author 1030129
     */
    public void show() {
        view.show(StageHandler.getInstance().getPrimaryStage());
    }

    public class CancelButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            view.close(StageHandler.getInstance().getPrimaryStage());
        }
    }

    public class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        /**
         * @author 1030129
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {

            try {
                LocalDate date = view.getDate().getValue();
                String title = view.getTitle().getText();
                String function = view.getFunction().getText();
                String protagonist = view.getProtagonist().getText();
                String source = view.getSource().getText();
                String references = view.getReferences().getText();
                String description = view.getDescription().getText();
                Priority priority = view.getPriority().getValue();
                Classification classification = view.getClassification().getValue();

                if (date == null || title.equals("") || function.equals("") || protagonist.equals("")
                        || source.equals("") || references.equals("") || description.equals("")) {
                    throw new EmptyTextfieldException();
                }

                int id = Integer.parseInt(view.getId().getText());
                int ftr = Integer.parseInt(view.getFtr().getText());
                int det = Integer.parseInt(view.getDet().getText());

                functionalRequirement = new FunctionalRequirement(id, ftr, det, date, title, function, protagonist,
                        source, references, description, priority, classification);

                model.addFunctionalRequirement(functionalRequirement);
                view.close(StageHandler.getInstance().getPrimaryStage());

                model.getFunctionalRequirementList().iterator().forEachRemaining(FunctionalRequirement::print);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warnung");
                alert.setHeaderText("Falsches Eingabeformat");
                alert.setContentText("Die Textfelder 'ID', 'FTR' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
                alert.showAndWait();
            }
            catch (EmptyTextfieldException e) {
                System.out.println("Error: " + e);
                Alert alert = new Alert((Alert.AlertType.WARNING));
                alert.setTitle("Warnung");
                alert.setHeaderText("Leeres Textfeld");
                alert.setContentText("Bitte füllen Sie alle Textfelder aus.");
                alert.showAndWait();
            }

        }
    }
}
