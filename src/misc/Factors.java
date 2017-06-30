package misc;

import exception.FactorAttributeRangeException;

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

    public Factors() {
        integration = 0;
        decentralData = 0;
        transactionRate = 0;
        calculation = 0;
        control = 0;
        exception = 0;
        logic = 0;
        reusability = 0;
        conversion = 0;
        customization = 0;
    }

    // Constructor with setters to assert value ranges
    public Factors(int integration, int decentralData, int transactionRate, int calculation, int control,
                   int exception, int logic, int reusability, int conversion, int customization)
            throws FactorAttributeRangeException {
        setIntegration(integration);
        setDecentralData(decentralData);
        setTransactionRate(transactionRate);
        setCalculation(calculation);
        setControl(control);
        setException(exception);
        setLogic(logic);
        setReusability(reusability);
        setConversion(conversion);
        setCustomization(customization);
    }

    public int getFactorSum() {
        return integration + decentralData + transactionRate + calculation + control +
                exception + logic + reusability + conversion + customization;
    }

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) throws FactorAttributeRangeException {
        if(integration >= 0 && integration <= 5)
            this.integration = integration;
        else
            throw new FactorAttributeRangeException();
    }

    public int getDecentralData() throws FactorAttributeRangeException {
        return decentralData;
    }

    public void setDecentralData(int decentralData) throws FactorAttributeRangeException {
        if(decentralData >= 0 && decentralData <= 5)
            this.decentralData = decentralData;
        else
            throw new FactorAttributeRangeException();
    }

    public int getTransactionRate() {
        return transactionRate;
    }

    public void setTransactionRate(int transactionRate) throws FactorAttributeRangeException {
        if(transactionRate >= 0 && transactionRate <= 5)
            this.transactionRate = transactionRate;
        else
            throw new FactorAttributeRangeException();
    }

    public int getCalculation() {
        return calculation;
    }

    public void setCalculation(int calculation) throws FactorAttributeRangeException {
        if(calculation >= 0 && calculation <= 10)
            this.calculation = calculation;
        else
            throw new FactorAttributeRangeException();
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) throws FactorAttributeRangeException {
        if(control >= 0 && control <= 5)
            this.control = control;
        else
            throw new FactorAttributeRangeException();
    }

    public int getException() {
        return exception;
    }

    public void setException(int exception) throws FactorAttributeRangeException {
        if(exception >= 0 && exception <= 10)
            this.exception = exception;
        else
            throw new FactorAttributeRangeException();
    }

    public int getLogic() {
        return logic;
    }

    public void setLogic(int logic) throws FactorAttributeRangeException {
        if(logic >= 0 && logic <= 5)
            this.logic = logic;
        else
            throw new FactorAttributeRangeException();
    }

    public int getReusability() {
        return reusability;
    }

    public void setReusability(int reusability) throws FactorAttributeRangeException {
        if(reusability >= 0 && reusability <= 5)
            this.reusability = reusability;
        else
            throw new FactorAttributeRangeException();
    }

    public int getConversion() {
        return conversion;
    }

    public void setConversion(int conversion) throws FactorAttributeRangeException {
        if(conversion >= 0 && conversion <= 5)
            this.conversion = conversion;
        else
            throw new FactorAttributeRangeException();
    }

    public int getCustomization() {
        return customization;
    }

    public void setCustomization(int customization) throws FactorAttributeRangeException {
        if(customization >= 0 && customization <= 5)
            this.customization = customization;
        else
            throw new FactorAttributeRangeException();
    }
}
