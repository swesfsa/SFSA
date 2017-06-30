package misc;

/**
 * Created by tmonn on 22.06.2017.
 */
class FunctionPoints {
    private long _functionPoints;

    FunctionPoints(long functionPoints) {
        _functionPoints = functionPoints;
    }

    FunctionPoints(FunctionPoints functionPoints) {
        _functionPoints = functionPoints._functionPoints;
    }

    long getFunctionPoints() {
        return _functionPoints;
    }

    void setFunctionPoints(long functionPoints) {
        _functionPoints = functionPoints;
    }

    void increment() {
        ++_functionPoints;
    }

    void add(FunctionPoints functionPoints) {
        _functionPoints += functionPoints.getFunctionPoints();
    }
}
