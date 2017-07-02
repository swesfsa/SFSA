package misc;

/**
 * Created by tmonn on 22.06.2017.
 */
public class FunctionPoints {
    private long _functionPoints;

    public FunctionPoints() {}

    public FunctionPoints(long functionPoints) {
        _functionPoints = functionPoints;
    }

    FunctionPoints(FunctionPoints functionPoints) {
        _functionPoints = functionPoints._functionPoints;
    }

    public long getFunctionPoints() {
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

    public long get_functionPoints() {
        return _functionPoints;
    }

    public void set_functionPoints(long _functionPoints) {
        this._functionPoints = _functionPoints;
    }
}
