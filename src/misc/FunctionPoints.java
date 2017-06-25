package misc;

/**
 * Created by tmonn on 22.06.2017.
 */
public class FunctionPoints {
    private long _functionPoints;

    public FunctionPoints(long functionPoints) {
        _functionPoints = functionPoints;
    }

    public FunctionPoints(FunctionPoints functionPoints) {
        _functionPoints = functionPoints._functionPoints;
    }

    public long getFunctionPoints() {
        return _functionPoints;
    }

    public void setFunctionPoints(long functionPoints) {
        _functionPoints = functionPoints;
    }

    public void increment() {
        ++_functionPoints;
    }

    public void add(FunctionPoints functionPoints) {
        _functionPoints += functionPoints.getFunctionPoints();
    }
}
