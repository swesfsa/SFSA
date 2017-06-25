package misc;

/**
 * Created by tmonn on 17.05.2017.
 */
public class Factors {
    private int _integration;
    private int _decentralData;
    private int _transactionRate;
    private int _calculation;
    private int _control;
    private int _exception;
    private int _logic;
    private int _reusability;
    private int _conversion;
    private int _customization;

    public Factors(int integration, int decentralData, int transactionRate, int calculation, int control,
            int exception, int logic, int reusability, int conversion, int customization) {
        _integration = integration;
        _decentralData = decentralData;
        _transactionRate = transactionRate;
        _calculation = calculation;
        _control = control;
        _exception = exception;
        _logic = logic;
        _reusability = reusability;
        _conversion = conversion;
        _customization = customization;
    }

    public int getFactorSum() {
        return _integration + _decentralData + _transactionRate + _calculation + _control +
                _exception + _logic + _reusability + _conversion + _customization;
    }
}
