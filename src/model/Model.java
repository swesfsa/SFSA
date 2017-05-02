package model;

import misc.FunctionalRequirement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 9459758
 */
public class Model implements IModel {

    private List<FunctionalRequirement> functionalRequirementList;

    public Model() {
        functionalRequirementList = new ArrayList<>();
    }

    public void addFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        functionalRequirementList.add(functionalRequirement);
    }
    public List<FunctionalRequirement> getFunctionalRequirementList() {
        return functionalRequirementList;
    }
}