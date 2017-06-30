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

    CostEstimation(FunctionPoints unweightedFunctionPoints, double factorSum, FunctionPoints weightedFunctionPoints,
                          double developmentTime, int persons, double personMonths) {
        _unweightedFunctionPoints = new FunctionPoints(unweightedFunctionPoints);
        _factorSum = factorSum;
        _weightedFunctionPoints = new FunctionPoints(weightedFunctionPoints);
        _developmentTime = developmentTime;
        _persons = persons;
        _personMonths = personMonths;
    }

    public FunctionPoints getUnweightedFunctionPoints() {
        return _unweightedFunctionPoints;
    }

    public double getFactorSum() {
        return _factorSum;
    }

    public FunctionPoints getWeightedFunctionPoints() {
        return _weightedFunctionPoints;
    }

    public double getDevelopmentTime() {
        return _developmentTime;
    }

    public int getPersons() {
        return _persons;
    }

    public double getPersonMonths() {
        return _personMonths;
    }
}
