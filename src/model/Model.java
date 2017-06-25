package model;

import misc.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 9459758
 */
public class Model implements IModel {

    private TargetSpecification _targetSpecification;
    private ProductUse _productUse;
    private Environment _environment;
    private List<FunctionalRequirement> _functionalRequirementList;
    private List<ProductData> _productDataList;
    private Factors _factors;

    public Model() {
        _targetSpecification = new TargetSpecification("");
        _productUse = new ProductUse("");
        _environment = new Environment("", "");
        _functionalRequirementList = new ArrayList<>();
        _productDataList = new ArrayList<>();
    }

    private Complexity calculateEIComplexity(int frFTR, int frDET) {
        Complexity complexity = null;
        if(frFTR >= 0 && frFTR <= 1) {
            if(frDET >= 1 && frDET <= 15)
                complexity = Complexity.LOW;
            else if(frDET > 15)
                complexity = Complexity.MIDDLE;
        } else if(frFTR == 2) {
            if(frDET >= 1 && frDET <= 4)
                complexity = Complexity.LOW;
            else if(frDET >= 5 && frDET <= 15)
                complexity = Complexity.MIDDLE;
            else if(frDET > 15)
                complexity = Complexity.HIGH;
        } else if(frFTR > 2){
            if(frDET >= 1 && frDET <= 4)
                complexity = Complexity.MIDDLE;
            else if(frDET > 4)
                complexity = Complexity.HIGH;
        }
        return complexity;
    }

    private Complexity calculateEOEQComplexity(int frFTR, int frDET) {
        Complexity complexity = null;
        if(frFTR >= 0 && frFTR <= 1) {
            if(frDET >= 1 && frDET <= 19)
                complexity = Complexity.LOW;
            else if(frDET > 19)
                complexity = Complexity.MIDDLE;
        } else if(frFTR >= 2 && frFTR <= 3) {
            if(frDET >= 1 && frDET <= 5)
                complexity = Complexity.LOW;
            else if(frDET >= 6 && frDET <= 19)
                complexity = Complexity.MIDDLE;
            else if(frDET > 19)
                complexity = Complexity.HIGH;
        } else if(frFTR > 3){
            if(frDET >= 1 && frDET <= 5)
                complexity = Complexity.MIDDLE;
            else if(frDET > 5)
                complexity = Complexity.HIGH;
        }
        return complexity;
    }

    private FunctionPoints calculateFunctionalRequirementsFunctionPoints(FunctionalRequirementClassification functionalRequirementClassification, Complexity complexity) {
        FunctionPoints functionPoints = new FunctionPoints(0);
        if(complexity == Complexity.LOW)
            functionPoints.setFunctionPoints(3);
        if(complexity == Complexity.MIDDLE)
            functionPoints.setFunctionPoints(4);
        if(complexity == Complexity.HIGH)
            functionPoints.setFunctionPoints(6);
        if(functionalRequirementClassification == FunctionalRequirementClassification.OUTPUT)
            functionPoints.increment(); // for type output one more function point
        return functionPoints;
    }
    private Complexity calculateProductDataComplexity(int productDataRET, int productDataDET) {
        Complexity complexity;
        if(productDataRET == 1) {
            if(productDataDET > 50)
                complexity = Complexity.LOW;
            else
                complexity = Complexity.MIDDLE;
        } else if(productDataRET <= 5) {
            if(productDataDET <= 19)
                complexity = Complexity.LOW;
            else if(productDataDET <= 50)
                complexity = Complexity.MIDDLE;
            else
                complexity = Complexity.HIGH;
        } else {
            if(productDataDET <= 19)
                complexity = Complexity.MIDDLE;
            else
                complexity = Complexity.HIGH;
        }
        return complexity;
    }

    private FunctionPoints calculateProductDataFunctionPoints(ProductDataClassification productDataClassification, Complexity complexity) {
        FunctionPoints functionPoints = new FunctionPoints(0);
        if(productDataClassification == ProductDataClassification.ILF && complexity == Complexity.LOW)
            functionPoints.setFunctionPoints(7);
        else if(productDataClassification == ProductDataClassification.ILF && complexity == Complexity.MIDDLE)
            functionPoints.setFunctionPoints(10);
        else if(productDataClassification == ProductDataClassification.ILF && complexity == Complexity.HIGH)
            functionPoints.setFunctionPoints(15);
        else if(productDataClassification == ProductDataClassification.EIF && complexity == Complexity.LOW)
            functionPoints.setFunctionPoints(5);
        else if(productDataClassification == ProductDataClassification.EIF && complexity == Complexity.MIDDLE)
            functionPoints.setFunctionPoints(7);
        else if(productDataClassification == ProductDataClassification.EIF && complexity == Complexity.HIGH)
            functionPoints.setFunctionPoints(10);
        return functionPoints;
    }

    public CostEstimation costEstimationCalculation() {
        FunctionPoints unweightedFunctionPoints = new FunctionPoints(0);
        for(FunctionalRequirement functionalRequirement : _functionalRequirementList) {
            Complexity complexity = null;
            if(functionalRequirement.get_classification() == FunctionalRequirementClassification.INPUT)
                complexity = calculateEIComplexity(functionalRequirement.get_det(), functionalRequirement.get_ftr());
            else if(functionalRequirement.get_classification() == FunctionalRequirementClassification.OUTPUT ||
                    functionalRequirement.get_classification() == FunctionalRequirementClassification.QUERY)
                complexity = calculateEOEQComplexity(functionalRequirement.get_det(), functionalRequirement.get_ftr());
            unweightedFunctionPoints.add(calculateFunctionalRequirementsFunctionPoints(functionalRequirement.get_classification(), complexity));
        }
        for(ProductData productData : _productDataList) {
            Complexity complexity = calculateProductDataComplexity(productData.get_ret(), productData.get_det());
            unweightedFunctionPoints.add(calculateProductDataFunctionPoints(productData.get_classification(), complexity));
        }
        double factorSum = _factors.getFactorSum();
        FunctionPoints weightedFunctionPoints = new FunctionPoints(Math.round(unweightedFunctionPoints.getFunctionPoints() * (factorSum/100 + 0.7)));
        double developmentTime = Math.pow(weightedFunctionPoints.getFunctionPoints(), 0.4);
        int persons = (int) Math.ceil(weightedFunctionPoints.getFunctionPoints() / 150.0);
        double personMonths = developmentTime * persons;
        return new CostEstimation(unweightedFunctionPoints, factorSum, weightedFunctionPoints, developmentTime, persons, personMonths);
    }

    public void addFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        _functionalRequirementList.add(functionalRequirement);
    }
    public List<FunctionalRequirement> get_functionalRequirementList() {
        return _functionalRequirementList;
    }

    public void addProductData(ProductData productData) {
        _productDataList.add(productData);
    }

    public List<ProductData> get_productDataList() {
        return _productDataList;
    }

    public TargetSpecification get_targetSpecification() {
        return _targetSpecification;
    }

    public void set_targetSpecification(TargetSpecification _targetSpecification) {
        this._targetSpecification = _targetSpecification;
    }

    public ProductUse get_productUse() {
        return _productUse;
    }

    public void set_productUse(ProductUse _productUse) {
        this._productUse = _productUse;
    }

    public Environment get_environment() {
        return _environment;
    }

    public void set_environment(Environment _environment) {
        this._environment = _environment;
    }
}