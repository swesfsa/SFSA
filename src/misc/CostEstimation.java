package misc;

/**
 * Created by tmonn on 17.05.2017.
 */
public class CostEstimation {
    private FunctionPoints unweightedFunctionPoints;
    private double factorSum;
    private FunctionPoints weightedFunctionPoints;
    private double developmentTime;
    private int persons;
    private double personMonths;

    public CostEstimation(FunctionPoints unweightedFunctionPoints, double factorSum, FunctionPoints weightedFunctionPoints,
                          double developmentTime, int persons, double personMonths) {
        this.unweightedFunctionPoints = new FunctionPoints(unweightedFunctionPoints);
        this.factorSum = factorSum;
        this.weightedFunctionPoints = new FunctionPoints(weightedFunctionPoints);
        this.developmentTime = developmentTime;
        this.persons = persons;
        this.personMonths = personMonths;
    }
}
