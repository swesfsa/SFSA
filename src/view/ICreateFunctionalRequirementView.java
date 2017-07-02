package view;

import javafx.scene.control.*;
import javafx.stage.Stage;
import misc.EFunctionalRequirementClassification;
import misc.EPriority;
import misc.FunctionalRequirement;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateFunctionalRequirementView extends ICreateItemView {

    FunctionalRequirement getFunctionalRequirement();
    void setFunctionalRequirement(FunctionalRequirement functionalRequirement);

}
