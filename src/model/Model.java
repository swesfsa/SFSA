package model;

import misc.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 9459758
 */

public class Model implements IModel {

    private TargetSpecification targetSpecification;
    private ProductUse productUse;
    private Environment environment;
    private List<FunctionalRequirement> functionalRequirementList;
    private List<ProductData> productDataList;
    private Factors _factors;

    public Model() {
        targetSpecification = new TargetSpecification("");
        productUse = new ProductUse("");
        environment = new Environment("", "");
        functionalRequirementList = new ArrayList<>();
        productDataList = new ArrayList<>();
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
        for(FunctionalRequirement functionalRequirement : functionalRequirementList) {
            Complexity complexity = null;
            if(functionalRequirement.getClassification() == FunctionalRequirementClassification.INPUT)
                complexity = calculateEIComplexity(functionalRequirement.getDet(), functionalRequirement.getFtr());
            else if(functionalRequirement.getClassification() == FunctionalRequirementClassification.OUTPUT ||
                    functionalRequirement.getClassification() == FunctionalRequirementClassification.QUERY)
                complexity = calculateEOEQComplexity(functionalRequirement.getDet(), functionalRequirement.getFtr());
            unweightedFunctionPoints.add(calculateFunctionalRequirementsFunctionPoints(functionalRequirement.getClassification(), complexity));
        }
        for(ProductData productData : productDataList) {
            Complexity complexity = calculateProductDataComplexity(productData.getRet(), productData.getDet());
            unweightedFunctionPoints.add(calculateProductDataFunctionPoints(productData.getClassification(), complexity));
        }
        double factorSum = _factors.getFactorSum();
        FunctionPoints weightedFunctionPoints = new FunctionPoints(Math.round(unweightedFunctionPoints.getFunctionPoints() * (factorSum/100 + 0.7)));
        double developmentTime = Math.pow(weightedFunctionPoints.getFunctionPoints(), 0.4);
        int persons = (int) Math.ceil(weightedFunctionPoints.getFunctionPoints() / 150.0);
        double personMonths = developmentTime * persons;
        return new CostEstimation(unweightedFunctionPoints, factorSum, weightedFunctionPoints, developmentTime, persons, personMonths);
    }

    public void addFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        functionalRequirementList.add(functionalRequirement);
    }
    public List<FunctionalRequirement> getFunctionalRequirementList() {
        return functionalRequirementList;
    }

    public void addProductData(ProductData productData) {
        productDataList.add(productData);
    }

    public List<ProductData> getProductDataList() {
        return productDataList;
    }

    public TargetSpecification getTargetSpecification() {
        return targetSpecification;
    }

    public void setTargetSpecification(TargetSpecification targetSpecification) {
        this.targetSpecification = targetSpecification;
    }

    public ProductUse getProductUse() {
        return productUse;
    }

    public void setProductUse(ProductUse productUse) {
        this.productUse = productUse;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}