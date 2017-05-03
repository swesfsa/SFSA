package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import misc.FunctionalRequirement;
import misc.FunctionalRequirementClassification;
import misc.Priority;
import misc.StageHandler;
import model.IModel;
import view.CreateFunctionalRequirementView;
import view.EmptyTextfieldException;

import java.time.LocalDate;

import static misc.FunctionalRequirementClassification.INPUT;
import static misc.FunctionalRequirementClassification.OUTPUT;
import static misc.FunctionalRequirementClassification.QUERY;
import static misc.Priority.HIGH;
import static misc.Priority.LOW;
import static misc.Priority.MIDDLE;

/**
 * Created by 1030129 on 02.05.17.
 */
public class CreateFunctionalRequirementController extends CreateController implements IController {

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

                Priority priority = null;
                switch (view.getPriority().getValue()) {
                    case "Niedrig": priority = LOW;
                        break;
                    case "Mittel": priority = MIDDLE;
                        break;
                    case "Hoch": priority = HIGH;
                        break;
                }

                FunctionalRequirementClassification classification = null;
                switch (view.getClassification().getValue()) {
                    case "Eingabe": classification = INPUT;
                        break;
                    case "Ausgabe": classification = OUTPUT;
                        break;
                    case "Abfrage": classification = QUERY;
                        break;
                }

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

                // DEBUG
                model.getFunctionalRequirementList().iterator().forEachRemaining(FunctionalRequirement::print);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: " + e);
                openNumberFormatWarning("Die Textfelder 'ID', 'FTR' und 'DET' erlauben nur Ganzzahlen als Eingabe!");
            }
            catch (EmptyTextfieldException e) {
                System.out.println("Error: " + e);
                openEmptyTextFieldWarning();
            }

        }
    }
}
