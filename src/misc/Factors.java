package misc;

/**
 * Created by tmonn on 17.05.2017.
 */
public class Factors {
    private int integration;
    private int decentralData;
    private int transactionRate;
    private int calculation;
    private int control;
    private int exception;
    private int logic;
    private int reusability;
    private int conversion;
    private int customization;

    public Factors(int integration, int decentralData, int transactionRate, int calculation, int control,
            int exception, int logic, int reusability, int conversion, int customization) {
        this.integration = integration;
        this.decentralData = decentralData;
        this.transactionRate = transactionRate;
        this.calculation = calculation;
        this.control = control;
        this.exception = exception;
        this.logic = logic;
        this.reusability = reusability;
        this.conversion = conversion;
        this.customization = customization;
    }

    public int getFactorSum() {
        return integration + decentralData + transactionRate + calculation + control +
                exception + logic + reusability + conversion + customization;
    }
}
