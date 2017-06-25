package misc;

/**
 * Created by tmonn on 17.05.2017.
 */
public class CostEstimation {
    private FunctionPoints _unweightedFunctionPoints;
    private double _factorSum;
    private FunctionPoints _weightedFunctionPoints;
    private double _developmentTime;
    private int _persons;
    private double _personMonths;

    public CostEstimation(FunctionPoints unweightedFunctionPoints, double factorSum, FunctionPoints weightedFunctionPoints,
                          double developmentTime, int persons, double personMonths) {
        _unweightedFunctionPoints = new FunctionPoints(unweightedFunctionPoints);
        _factorSum = factorSum;
        _weightedFunctionPoints = new FunctionPoints(weightedFunctionPoints);
        _developmentTime = developmentTime;
        _persons = persons;
        _personMonths = personMonths;
    }
}
