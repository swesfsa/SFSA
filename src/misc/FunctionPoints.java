package misc;

/**
 * Created by tmonn on 22.06.2017.
 */
public class FunctionPoints {
    private long functionPoints;

    public FunctionPoints(long functionPoints) {
        this.functionPoints = functionPoints;
    }

    public FunctionPoints(FunctionPoints functionPoints) {
        this.functionPoints = functionPoints.functionPoints;
    }

    public long getFunctionPoints() {
        return functionPoints;
    }

    public void setFunctionPoints(long functionPoints) {
        this.functionPoints = functionPoints;
    }

    public void increment() {
        ++functionPoints;
    }

    public void add(FunctionPoints functionPoints) {
        this.functionPoints += functionPoints.getFunctionPoints();
    }
}
