package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import misc.EstimationConfiguration;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 30.06.17.
 */
public class EstimationConfigurationView extends TabView implements IEstimationConfigurationView {

    private Button _saveButton;

    private Slider _integrationSlider;
    private Slider _decentralDataSlider;
    private Slider _transactionRateSlider;
    private Slider _calculationSlider;
    private Slider _controlSlider;
    private Slider _exceptionSlider;
    private Slider _logicSlider;
    private Slider _reusabilitySlider;
    private Slider _conversionSlider;
    private Slider _customizationSlider;

    /**
     * @author 1030129
     * @throws Exception
     */
    public EstimationConfigurationView(IModel iModel) throws IOException {

        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/EstimationConfiguration.fxml"));

        _saveButton = (Button) root.lookup("#saveButton");
        _integrationSlider = (Slider) root.lookup("#integration");
        _decentralDataSlider = (Slider) root.lookup("#decentralData");
        _transactionRateSlider = (Slider) root.lookup("#transactionRate");
        _calculationSlider = (Slider) root.lookup("#calculation");
        _controlSlider = (Slider) root.lookup("#control");
        _exceptionSlider = (Slider) root.lookup("#exception");
        _logicSlider = (Slider) root.lookup("#logic");
        _reusabilitySlider = (Slider) root.lookup("#reusability");
        _conversionSlider = (Slider) root.lookup("#conversion");
        _customizationSlider = (Slider) root.lookup("#customization");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");

        update(null, null);
    }

    public EstimationConfiguration getEstimationConfiguration() {

        EstimationConfiguration estimationConfiguration = new EstimationConfiguration();

        estimationConfiguration.setIntegration((int) _integrationSlider.getValue());
        estimationConfiguration.setDecentralData((int) _decentralDataSlider.getValue());
        estimationConfiguration.setTransactionRate((int) _transactionRateSlider.getValue());
        estimationConfiguration.setCalculation((int) _calculationSlider.getValue());
        estimationConfiguration.setControl((int) _controlSlider.getValue());
        estimationConfiguration.setException((int) _exceptionSlider.getValue());
        estimationConfiguration.setLogic((int) _logicSlider.getValue());
        estimationConfiguration.setReusability((int) _reusabilitySlider.getValue());
        estimationConfiguration.setConversion((int) _conversionSlider.getValue());
        estimationConfiguration.setCustomization((int) _customizationSlider.getValue());

        return estimationConfiguration;

    }

    public void setEstimationConfiguration(EstimationConfiguration estimationConfiguration) {
        double integration = estimationConfiguration.getIntegration();
        double decentralData = estimationConfiguration.getDecentralData();
        double transactionRate = estimationConfiguration.getTransactionRate();
        double calculation = estimationConfiguration.getCalculation();
        double control = estimationConfiguration.getControl();
        double exception = estimationConfiguration.getException();
        double logic = estimationConfiguration.getLogic();
        double reusability = estimationConfiguration.getReusability();
        double conversion = estimationConfiguration.getConversion();
        double customization = estimationConfiguration.getCustomization();
        _integrationSlider.setValue(integration);
        _decentralDataSlider.setValue(decentralData);
        _transactionRateSlider.setValue(transactionRate);
        _calculationSlider.setValue(calculation);
        _controlSlider.setValue(control);
        _exceptionSlider.setValue(exception);
        _logicSlider.setValue(logic);
        _reusabilitySlider.setValue(reusability);
        _conversionSlider.setValue(conversion);
        _customizationSlider.setValue(customization);
    }

    public AnchorPane getAnchorPane() {
        return _anchorPane;
    }

    public Button getSaveButton() {
        return _saveButton;
    }



    public void update(Observable o, Object arg) {
        if(_iModel.getEstimationConfiguration() != null)
            setEstimationConfiguration(_iModel.getEstimationConfiguration());
        else
            LOGGER.severe("Estimation Configuration null");
    }

    public void setEditable(boolean editable) {

    }
}
