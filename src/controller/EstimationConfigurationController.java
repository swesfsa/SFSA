package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import misc.EstimationConfiguration;
import model.IModel;
import view.IEstimationConfigurationView;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 30.06.17.
 */
public class EstimationConfigurationController extends TabController {

    private IEstimationConfigurationView _iView;

    EstimationConfigurationController(IModel iModel, IEstimationConfigurationView iView) {

        _iModel = iModel;
        _iView = iView;
        _anchorPane = _iView.getAnchorPane();

        _iView.getSaveButton().setOnAction(new SaveButtonEventHandler());
    }

    private class SaveButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            EstimationConfiguration estimationConfiguration = _iView.getEstimationConfiguration();

            //estimationConfiguration.check();
            _iModel.setEstimationConfiguration(estimationConfiguration);
            LOGGER.info("Estimation Configuration saved in Model");
        }
    }
}
