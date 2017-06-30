package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import misc.FunctionalRequirement;
import model.IModel;
import view.FunctionalRequirementsView;

/**
 * Created by 1030129 on 02.05.17.
 */
public class FunctionalRequirementsController extends TabController {

    private FunctionalRequirementsView _view;
    private Object _selectedTableViewItem;

    public FunctionalRequirementsController(IModel model) throws Exception {

        _model = model;
        _view = new FunctionalRequirementsView(_model);
        _anchorPane = _view.get_anchorPane();

        _view.getNewButton().setOnAction(new NewButtonEventHandler());
        _view.getEditButton().setOnAction(new EditButtonEventHandler());
        _view.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

        _view.get_idColumn().setCellValueFactory(new PropertyValueFactory<>("_id"));
        _view.get_titleColumn().setCellValueFactory(new PropertyValueFactory<>("_title"));
        _view.get_dateColumn().setCellValueFactory(new PropertyValueFactory<>("_date"));
        _view.get_tableView().setItems(_model.get_functionalRequirementList());
        _view.get_tableView().setOnMouseClicked(new TableViewClickedHandler());
    }

    private void loadDetailView(Object itemToLoad) {
        FunctionalRequirement functionalRequirementToLoad;
        functionalRequirementToLoad = getFunctionalRequirementFromTableViewItem(itemToLoad);
        _view.get_idLabel().setText(Integer.toString(functionalRequirementToLoad.get_id()));
        _view.get_dateLabel().setText(functionalRequirementToLoad.get_date().getDayOfMonth() + "."
            + functionalRequirementToLoad.get_date().getMonthValue() + "."
            + functionalRequirementToLoad.get_date().getYear());
        _view.get_titleLabel().setText(functionalRequirementToLoad.get_title());
        _view.get_functionLabel().setText(functionalRequirementToLoad.get_function());
        _view.get_descriptionArea().setText(functionalRequirementToLoad.get_description());
        _view.get_protagonistLabel().setText(functionalRequirementToLoad.get_protagonist());
        _view.get_sourceLabel().setText(functionalRequirementToLoad.get_source());
        _view.get_referencesLabel().setText(functionalRequirementToLoad.get_references());
        _view.get_priorityLabel().setText(functionalRequirementToLoad.get_priority().get_priority());
        _view.get_ftrLabel().setText(Integer.toString(functionalRequirementToLoad.get_ftr()));
        _view.get_detLabel().setText(Integer.toString(functionalRequirementToLoad.get_det()));
        _view.get_classificationLabel().setText(functionalRequirementToLoad.get_classification().get_classification());
    }

    private void clearDetailView() {
        _view.get_idLabel().setText("");
        _view.get_dateLabel().setText("");
        _view.get_titleLabel().setText("");
        _view.get_functionLabel().setText("");
        _view.get_descriptionArea().setText("");
        _view.get_protagonistLabel().setText("");
        _view.get_sourceLabel().setText("");
        _view.get_referencesLabel().setText("");
        _view.get_priorityLabel().setText("");
        _view.get_ftrLabel().setText("");
        _view.get_detLabel().setText("");
        _view.get_classificationLabel().setText("");
    }

    private FunctionalRequirement getFunctionalRequirementFromTableViewItem(Object itemToLoad) {
        FunctionalRequirement functionalRequirement;
        Integer index;
        index = _model.get_functionalRequirementList().indexOf(itemToLoad);
        functionalRequirement = _model.get_functionalRequirementList().get(index);

        return functionalRequirement;
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                IController controller = new CreateFunctionalRequirementController(_model);
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
                _model.get_functionalRequirementList().remove(_selectedTableViewItem);
                clearDetailView();
            }
        }
    }

    private class TableViewClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            _selectedTableViewItem = _view.get_tableView().getSelectionModel().getSelectedItem();
            loadDetailView(_selectedTableViewItem);
        }
    }

}
