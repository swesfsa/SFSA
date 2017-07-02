package view;

import controller.ControllerTemplate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import misc.CostEstimation;
import misc.FunctionPoints;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 30.06.17.
 */
public class CostEstimationView extends TabView implements ICostEstimationView {

    private Button _saveButton;
    private Button _editButton;
    private Button _executeButton;

    private TextField _unweightedFunctionPoints;
    private TextField _factorSum;
    private TextField _weightedFunctionPoints;
    private TextField _developmentTime;
    private TextField _persons;
    private TextField _personMonths;

    /**
     * @author 1030129
     * @throws Exception
     */
    public CostEstimationView(IModel iModel) throws IOException {

        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/CostEstimation.fxml"));

        _saveButton = (Button) root.lookup("#saveButton");
        _editButton = (Button) root.lookup("#editButton");
        _executeButton = (Button) root.lookup("#executeButton");
        _unweightedFunctionPoints = (TextField) root.lookup("#unweighted");
        _factorSum = (TextField) root.lookup("#factorSum");
        _weightedFunctionPoints = (TextField) root.lookup("#weighted");
        _developmentTime = (TextField) root.lookup("#developmentTime");
        _persons = (TextField) root.lookup("#persons");
        _personMonths = (TextField) root.lookup("#personMonths");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");

        update(null, null);
        setEditable(false);
    }

    public void setEditable(boolean editable) {
        _unweightedFunctionPoints.setEditable(editable);
        _weightedFunctionPoints.setEditable(editable);
        _factorSum.setEditable(editable);
        _developmentTime.setEditable(editable);
        _persons.setEditable(editable);
        _personMonths.setEditable(editable);
        if (editable) {
            _editButton.setText("Abbrechen");
        } else {
            _editButton.setText("Bearbeiten");
        }
    }

    public CostEstimation getCostEstimation() {

        CostEstimation costEstimation = new CostEstimation();
        costEstimation.setUnweightedFunctionPoints(new FunctionPoints(Long.parseLong(_unweightedFunctionPoints.getText())));
        costEstimation.setFactorSum(Double.parseDouble(_factorSum.getText()));
        costEstimation.setWeightedFunctionPoints(new FunctionPoints(Long.parseLong(_weightedFunctionPoints.getText())));
        costEstimation.setDevelopmentTime(Double.parseDouble(_developmentTime.getText()));
        costEstimation.setPersons(Integer.parseInt(_persons.getText()));
        costEstimation.setPersonMonths(Double.parseDouble(_personMonths.getText()));
        return costEstimation;

    }

    public void setCostEstimation(CostEstimation costEstimation) {

        long unweightedFunctionPoints = costEstimation.getUnweightedFunctionPoints().getFunctionPoints();
        long weightedFunctionPoints = costEstimation.getWeightedFunctionPoints().getFunctionPoints();
        int persons = costEstimation.getPersons();
        double developmentTime = costEstimation.getDevelopmentTime();
        double personMonths = costEstimation.getPersonMonths();
        double factorSum = costEstimation.getFactorSum();
        _unweightedFunctionPoints.setText(Long.toString(unweightedFunctionPoints));
        _weightedFunctionPoints.setText(Long.toString(weightedFunctionPoints));
        _persons.setText(Integer.toString(persons));
        _developmentTime.setText(Double.toString(developmentTime));
        _personMonths.setText(Double.toString(personMonths));
        _factorSum.setText(Double.toString(factorSum));

    }

    public Button getSaveButton() {
        return _saveButton;
    }
    public Button getEditButton() {
        return _editButton;
    }
    public Button getExecuteButton() {
        return _executeButton;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(_iModel.getCostEstimation() != null)
            setCostEstimation(_iModel.getCostEstimation());
        else
            LOGGER.severe("Cost Estimation null");
    }
}
