package view;

import javafx.scene.control.Button;
import misc.EstimationConfiguration;

/**
 * Created by 1030129 on 30.06.17.
 */
public interface IEstimationConfigurationView extends ITabView {

    Button getSaveButton();

    EstimationConfiguration getEstimationConfiguration();
    void setEstimationConfiguration(EstimationConfiguration estimationConfiguration);
}
