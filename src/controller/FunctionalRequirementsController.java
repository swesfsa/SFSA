package controller;

import exception.EmptyListException;
import exception.NoListViewRowSelectedException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import misc.FunctionalRequirement;
import model.IModel;
import view.IFunctionalRequirementsView;

import static controller.EStageController.CREATE_FUNCTIONAL_REQUIREMENT_CONTROLLER;
import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 02.05.17.
 */
class FunctionalRequirementsController extends TabController {

    private IFunctionalRequirementsView _iView;
    private FunctionalRequirement _selectedTableViewItem;

    FunctionalRequirementsController(IModel iModel, IFunctionalRequirementsView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getNewButton().setOnAction(new NewButtonEventHandler());
        _iView.getEditButton().setOnAction(new EditButtonEventHandler());
        _iView.getDeleteButton().setOnAction(new DeleteButtonEventHandler());

        _iView.getIdColumn().setCellValueFactory(new PropertyValueFactory<>("Id"));
        _iView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("Title"));
        _iView.getDateColumn().setCellValueFactory(new PropertyValueFactory<>("Test"));
        _iView.getTableView().setItems(_iModel.getFunctionalRequirementList());
        _iView.getTableView().setOnMouseClicked(new TableViewClickedHandler());
    }

    private FunctionalRequirement getFunctionalRequirementFromTableViewItem(FunctionalRequirement itemToLoad) {
        int index = _iModel.getFunctionalRequirementList().indexOf(itemToLoad);
        return _iModel.getFunctionalRequirementList().get(index);
    }

    private void checkForEmptyList(IModel iModel) throws EmptyListException {
        if (iModel.getFunctionalRequirementList().isEmpty()) {
            throw new EmptyListException();
        }
    }

    private void checkForSelection() throws NoListViewRowSelectedException {
        if (_iView.getTableView().getSelectionModel().getSelectedItem() == null) {
            throw new NoListViewRowSelectedException();
        }
    }

    private class NewButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            IStageController controller = StageControllerFactory.create(
                    CREATE_FUNCTIONAL_REQUIREMENT_CONTROLLER, _iModel);
            controller.show();
        }
    }

    private class EditButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                checkForEmptyList(_iModel);
                checkForSelection();
                IStageController controller = StageControllerFactory.createWArg(
                        CREATE_FUNCTIONAL_REQUIREMENT_CONTROLLER, _iModel,
                        getFunctionalRequirementFromTableViewItem(_selectedTableViewItem));
                controller.show();
            } catch (EmptyListException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openEmptyListWarning("bearbeiten");
            } catch (NoListViewRowSelectedException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openNoListViewRowSelectedWarning("bearbeiten");
            }
            _iView.clearDetailView();
        }
    }

    private class DeleteButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {
                checkForEmptyList(_iModel);
                checkForSelection();
                Boolean delete;
                delete = openDeleteQuery();
                if (delete) {
                    _iModel.getFunctionalRequirementList().remove(_selectedTableViewItem);
                    LOGGER.info("Functional Requirement deleted from Model");
                    _iView.clearDetailView();
                }
            } catch (EmptyListException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openEmptyListWarning("löschen");
            } catch (NoListViewRowSelectedException e) {
                LOGGER.severe(e.toString() + " in " + getClass());
                openNoListViewRowSelectedWarning("löschen");
            }
        }
    }

    private class TableViewClickedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            _selectedTableViewItem = (FunctionalRequirement) _iView.getTableView().getSelectionModel().getSelectedItem();
            _iView.loadDetailView(_selectedTableViewItem);
        }
    }

}
