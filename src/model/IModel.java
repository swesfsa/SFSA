package model;

import misc.FunctionalRequirement;
import java.util.List;

/**
 * @author 9459758
 */
public interface IModel {
    List<FunctionalRequirement> getFunctionalRequirementList();
    void addFunctionalRequirement(FunctionalRequirement functionalRequirement);
}