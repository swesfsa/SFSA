package misc;

import exception.NumberSmallerOneException;

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

    public CostEstimation() {
        _unweightedFunctionPoints = new FunctionPoints();
        _weightedFunctionPoints = new FunctionPoints();
    }

    public CostEstimation(FunctionPoints unweightedFunctionPoints, double factorSum, FunctionPoints weightedFunctionPoints,
                          double developmentTime, int persons, double personMonths) {
        _unweightedFunctionPoints = new FunctionPoints(unweightedFunctionPoints);
        _factorSum = factorSum;
        _weightedFunctionPoints = new FunctionPoints(weightedFunctionPoints);
        _developmentTime = developmentTime;
        _persons = persons;
        _personMonths = personMonths;
    }

    public void check() throws NumberSmallerOneException {

        if (_unweightedFunctionPoints.getFunctionPoints() < 0 || _factorSum < 0
                || _weightedFunctionPoints.getFunctionPoints() < 0 || _developmentTime < 0
                || _persons < 0 || _personMonths < 0) {
            throw new NumberSmallerOneException();
        }

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

    public void setUnweightedFunctionPoints(FunctionPoints unweightedFunctionPoints) {
        this._unweightedFunctionPoints = unweightedFunctionPoints;
    }

    public void setFactorSum(double factorSum) {
        this._factorSum = factorSum;
    }

    public void setWeightedFunctionPoints(FunctionPoints weightedFunctionPoints) {
        this._weightedFunctionPoints = weightedFunctionPoints;
    }

    public void setDevelopmentTime(double developmentTime) {
        this._developmentTime = developmentTime;
    }

    public void setPersons(int persons) {
        this._persons = persons;
    }

    public void setPersonMonths(double personMonths) {
        this._personMonths = personMonths;
    }
}
