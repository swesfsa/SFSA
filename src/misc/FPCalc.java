package misc;

import java.util.List;

import static misc.Complexity.*;
import static misc.ProductDataClassification.EIF;
import static misc.ProductDataClassification.ILF;

/**
 * Created by tmonn on 27.06.2017.
 */
public class FPCalc {

    public static CostEstimation costEstimationCalculation(List<FunctionalRequirement> functionalRequirementList,
                                                           List<ProductData> productDataList, Factors factors) {
        FunctionPoints unweightedFP = new FunctionPoints(0);
        unweightedFP.add(FPCalc.rateFunctionalRequirements(functionalRequirementList));
        unweightedFP.add(FPCalc.rateProductData(productDataList));
        double factorSum = factors.getFactorSum();
        long weightedFP = Math.round(unweightedFP.getFunctionPoints() * (factorSum/100 + 0.7));
        FunctionPoints weightedFunctionPoints = new FunctionPoints(weightedFP);
        double developmentTime = Math.pow(weightedFunctionPoints.getFunctionPoints(), 0.4);
        int persons = (int) Math.ceil(weightedFunctionPoints.getFunctionPoints() / 150.0);
        double personMonths = developmentTime * persons;
        return new CostEstimation(unweightedFP, factorSum,
                weightedFunctionPoints, developmentTime, persons, personMonths);
    }

    private static FunctionPoints rateFunctionalRequirements(List<FunctionalRequirement> functionalRequirementList) {
        FunctionPoints functionalRequirementFP = new FunctionPoints(0);
        for(FunctionalRequirement functionalRequirement : functionalRequirementList) {
            Complexity complexity = null;
            if(functionalRequirement.getClassification() == FunctionalRequirementClassification.INPUT)
                complexity = calculateEIComplexity(functionalRequirement.getDet(), functionalRequirement.getFtr());
            else if(functionalRequirement.getClassification() == FunctionalRequirementClassification.OUTPUT ||
                    functionalRequirement.getClassification() == FunctionalRequirementClassification.QUERY)
                complexity = calculateEOEQComplexity(functionalRequirement.getDet(), functionalRequirement.getFtr());
            functionalRequirementFP.add(calculateFunctionalRequirementsFP
                    (functionalRequirement.getClassification(), complexity));
        }
        return functionalRequirementFP;
    }

    private static FunctionPoints rateProductData(List<ProductData> productDataList) {
        FunctionPoints productDataFP = new FunctionPoints(0);
        for(ProductData productData : productDataList) {
            Complexity complexity = calculateProductDataComplexity(productData.getRet(), productData.getDet());
            productDataFP.add(calculateProductDataFunctionPoints(productData.getClassification(), complexity));
        }
        return productDataFP;
    }

    private static Complexity calculateEIComplexity(int frDET, int frFTR) {
        Complexity complexity = null;
        if(frFTR >= 0 && frFTR <= 1) {
            if(frDET >= 1 && frDET <= 15)
                complexity = LOW;
            else if(frDET > 15)
                complexity = MIDDLE;
        } else if(frFTR == 2) {
            if(frDET >= 1 && frDET <= 4)
                complexity = LOW;
            else if(frDET >= 5 && frDET <= 15)
                complexity = MIDDLE;
            else if(frDET > 15)
                complexity = HIGH;
        } else if(frFTR > 2){
            if(frDET >= 1 && frDET <= 4)
                complexity = MIDDLE;
            else if(frDET > 4)
                complexity = HIGH;
        }
        return complexity;
    }

    private static Complexity calculateEOEQComplexity(int frDET, int frFTR) {
        Complexity complexity = null;
        if(frFTR >= 0 && frFTR <= 1) {
            if(frDET >= 1 && frDET <= 19)
                complexity = LOW;
            else if(frDET > 19)
                complexity = MIDDLE;
        } else if(frFTR >= 2 && frFTR <= 3) {
            if(frDET >= 1 && frDET <= 5)
                complexity = LOW;
            else if(frDET >= 6 && frDET <= 19)
                complexity = MIDDLE;
            else if(frDET > 19)
                complexity = HIGH;
        } else if(frFTR > 3){
            if(frDET >= 1 && frDET <= 5)
                complexity = MIDDLE;
            else if(frDET > 5)
                complexity = HIGH;
        }
        return complexity;
    }

    private static FunctionPoints calculateFunctionalRequirementsFP
            (FunctionalRequirementClassification functionalRequirementClassification, Complexity complexity) {
        FunctionPoints functionPoints = new FunctionPoints(0);
        if(complexity == LOW)
            functionPoints.setFunctionPoints(3);
        else if(complexity == MIDDLE)
            functionPoints.setFunctionPoints(4);
        else if(complexity == HIGH)
            functionPoints.setFunctionPoints(6);
        if(functionalRequirementClassification == FunctionalRequirementClassification.OUTPUT)
            functionPoints.increment(); // for type output one more function point
        return functionPoints;
    }

    private static Complexity calculateProductDataComplexity(int productDataRET, int productDataDET) {
        Complexity complexity;
        if(productDataRET == 1) {
            if(productDataDET > 50)
                complexity = LOW;
            else
                complexity = MIDDLE;
        } else if(productDataRET <= 5) {
            if(productDataDET <= 19)
                complexity = LOW;
            else if(productDataDET <= 50)
                complexity = MIDDLE;
            else
                complexity = HIGH;
        } else {
            if(productDataDET <= 19)
                complexity = MIDDLE;
            else
                complexity = HIGH;
        }
        return complexity;
    }

    private static FunctionPoints calculateProductDataFunctionPoints
            (ProductDataClassification productDataClassification, Complexity complexity) {
        FunctionPoints functionPoints = new FunctionPoints(0);
        if(productDataClassification == ILF && complexity == LOW)
            functionPoints.setFunctionPoints(7);
        else if(productDataClassification == ILF && complexity == MIDDLE)
            functionPoints.setFunctionPoints(10);
        else if(productDataClassification == ILF && complexity == HIGH)
            functionPoints.setFunctionPoints(15);
        else if(productDataClassification == EIF && complexity == LOW)
            functionPoints.setFunctionPoints(5);
        else if(productDataClassification == EIF && complexity == MIDDLE)
            functionPoints.setFunctionPoints(7);
        else if(productDataClassification == EIF && complexity == HIGH)
            functionPoints.setFunctionPoints(10);
        return functionPoints;
    }
}
