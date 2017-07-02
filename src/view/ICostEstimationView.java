package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import misc.CostEstimation;
import misc.FunctionPoints;

import java.util.Observable;

/**
 * Created by 1030129 on 30.06.17.
 */
public interface ICostEstimationView extends ITabView {

    Button getSaveButton();
    Button getEditButton();
    Button getExecuteButton();

    CostEstimation getCostEstimation();

    void setEditable(boolean editable);
    void update(Observable o, Object arg);
}
