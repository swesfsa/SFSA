package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import misc.FunctionalRequirement;
import model.IModel;
import view.FunctionalRequirementsView;
import view.IFunctionalRequirementsView;

/**
 * Created by 1030129 on 02.05.17.
 */
class FunctionalRequirementsController extends TabController {

    private IFunctionalRequirementsView _view;
    private FunctionalRequirement _selectedTableViewItem;

    FunctionalRequirementsController(IModel model) throws Exception {

        _model = model;
        _view = new FunctionalRequirementsView(_model);
        _anchorPane = _view.getAnchorPane();

        _view.getNewButton().setOnAction(new NewButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

        _view.getIdColumn().setCellValueFactory(new PropertyValueFactory<>("Id"));
        _view.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("Title"));
        _view.getDateColumn().setCellValueFactory(new PropertyValueFactory<>("Date"));
        _view.getTableView().setItems(_model.getFunctionalRequirementList());
        _view.getTableView().setOnMouseClicked(new TableViewClickedHandler());
    }

    private void loadDetailView(FunctionalRequirement itemToLoad) {
        FunctionalRequirement functionalRequirementToLoad;
        functionalRequirementToLoad = getFunctionalRequirementFromTableViewItem(itemToLoad);
        _view.getIdLabel().setText(Integer.toString(functionalRequirementToLoad.getId()));
        _view.getDateLabel().setText(functionalRequirementToLoad.getDate().getDayOfMonth() + "."
                + functionalRequirementToLoad.getDate().getMonthValue() + "."
                + functionalRequirementToLoad.getDate().getYear());
        _view.getTitleLabel().setText(functionalRequirementToLoad.getTitle());
        _view.getFunctionLabel().setText(functionalRequirementToLoad.getFunction());
        _view.getDescriptionArea().setText(functionalRequirementToLoad.getDescription());
        _view.getProtagonistLabel().setText(functionalRequirementToLoad.getProtagonist());
        _view.getSourceLabel().setText(functionalRequirementToLoad.getSource());
        _view.getReferencesLabel().setText(functionalRequirementToLoad.getReferences());
        _view.getPriorityLabel().setText(functionalRequirementToLoad.getPriority().getPriority());
        _view.getFtrLabel().setText(Integer.toString(functionalRequirementToLoad.getFtr()));
        _view.getDetLabel().setText(Integer.toString(functionalRequirementToLoad.getDet()));
        _view.getClassificationLabel().setText(functionalRequirementToLoad.getClassification().getClassification());
    }

    private void clearDetailView() {
        _view.getIdLabel().setText("");
        _view.getDateLabel().setText("");
        _view.getTitleLabel().setText("");
        _view.getFunctionLabel().setText("");
        _view.getDescriptionArea().setText("");
        _view.getProtagonistLabel().setText("");
        _view.getSourceLabel().setText("");
        _view.getReferencesLabel().setText("");
        _view.getPriorityLabel().setText("");
        _view.getFtrLabel().setText("");
        _view.getDetLabel().setText("");
        _view.getClassificationLabel().setText("");
    }

    private FunctionalRequirement getFunctionalRequirementFromTableViewItem(FunctionalRequirement itemToLoad) {
        FunctionalRequirement functionalRequirement;
        Integer index;
        index = _model.getFunctionalRequirementList().indexOf(itemToLoad);
        functionalRequirement = _model.getFunctionalRequirementList().get(index);

        return functionalRequirement;
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                IStageController controller = new CreateFunctionalRequirementController(_model);
                controller.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("EditButtonClicked");
            try {
                CreateFunctionalRequirementController controller = new CreateFunctionalRequirementController(_model,
                        getFunctionalRequirementFromTableViewItem(_selectedTableViewItem));
                controller.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Boolean delete;
            delete = openDeleteQuery();
            if (delete) {
                _model.getFunctionalRequirementList().remove(_selectedTableViewItem);
                clearDetailView();
            }
        }
    }

    private class TableViewClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            _selectedTableViewItem = (FunctionalRequirement) _view.getTableView().getSelectionModel().getSelectedItem();
            loadDetailView(_selectedTableViewItem);
        }
    }

}
