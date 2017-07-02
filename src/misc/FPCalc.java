package misc;

import java.util.List;

import static misc.EComplexity.*;
import static misc.EProductDataClassification.EIF;
import static misc.EProductDataClassification.ILF;

/**
 * Created by tmonn on 27.06.2017.
 */
public class FPCalc {

    private FPCalc() {}

    public static CostEstimation costEstimationCalculation(List<FunctionalRequirement> functionalRequirementList,
                                                           List<ProductData> productDataList, EstimationConfiguration estimationConfiguration) {
        FunctionPoints unweightedFP = new FunctionPoints(0);
        unweightedFP.add(FPCalc.rateFunctionalRequirements(functionalRequirementList));
        unweightedFP.add(FPCalc.rateProductData(productDataList));
        double factorSum = estimationConfiguration.getSum();
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
           EComplexity eComplexity = null;
            if(functionalRequirement.getClassification() == EFunctionalRequirementClassification.INPUT)
                eComplexity = calculateEIComplexity(functionalRequirement.getDet(), functionalRequirement.getFtr());
            else if(functionalRequirement.getClassification() == EFunctionalRequirementClassification.OUTPUT ||
                    functionalRequirement.getClassification() == EFunctionalRequirementClassification.QUERY)
                eComplexity = calculateEOEQComplexity(functionalRequirement.getDet(), functionalRequirement.getFtr());
            functionalRequirementFP.add(calculateFunctionalRequirementsFP
                    (functionalRequirement.getClassification(), eComplexity));
        }
        return functionalRequirementFP;
    }

    private static FunctionPoints rateProductData(List<ProductData> productDataList) {
        FunctionPoints productDataFP = new FunctionPoints(0);
        for(ProductData productData : productDataList) {
           EComplexity eComplexity = calculateProductDataComplexity(productData.getRet(), productData.getDet());
            productDataFP.add(calculateProductDataFunctionPoints(productData.getClassification(), eComplexity));
        }
        return productDataFP;
    }

    private static EComplexity calculateEIComplexity(int frDET, int frFTR) {
       EComplexity eComplexity = null;
        if(frFTR >= 0 && frFTR <= 1) {
            if(frDET >= 1 && frDET <= 15)
                eComplexity = LOW;
            else if(frDET > 15)
                eComplexity = MIDDLE;
        } else if(frFTR == 2) {
            if(frDET >= 1 && frDET <= 4)
                eComplexity = LOW;
            else if(frDET >= 5 && frDET <= 15)
                eComplexity = MIDDLE;
            else if(frDET > 15)
                eComplexity = HIGH;
        } else if(frFTR > 2){
            if(frDET >= 1 && frDET <= 4)
                eComplexity = MIDDLE;
            else if(frDET > 4)
                eComplexity = HIGH;
        }
        return eComplexity;
    }

    private static EComplexity calculateEOEQComplexity(int frDET, int frFTR) {
       EComplexity eComplexity = null;
        if(frFTR >= 0 && frFTR <= 1) {
            if(frDET >= 1 && frDET <= 19)
                eComplexity = LOW;
            else if(frDET > 19)
                eComplexity = MIDDLE;
        } else if(frFTR >= 2 && frFTR <= 3) {
            if(frDET >= 1 && frDET <= 5)
                eComplexity = LOW;
            else if(frDET >= 6 && frDET <= 19)
                eComplexity = MIDDLE;
            else if(frDET > 19)
                eComplexity = HIGH;
        } else if(frFTR > 3){
            if(frDET >= 1 && frDET <= 5)
                eComplexity = MIDDLE;
            else if(frDET > 5)
                eComplexity = HIGH;
        }
        return eComplexity;
    }

    private static FunctionPoints calculateFunctionalRequirementsFP
            (EFunctionalRequirementClassification eFunctionalRequirementClassification,EComplexity eComplexity) {
        FunctionPoints functionPoints = new FunctionPoints(0);
        if(eComplexity == LOW)
            functionPoints.setFunctionPoints(3);
        else if(eComplexity == MIDDLE)
            functionPoints.setFunctionPoints(4);
        else if(eComplexity == HIGH)
            functionPoints.setFunctionPoints(6);
        if(eFunctionalRequirementClassification == EFunctionalRequirementClassification.OUTPUT)
            functionPoints.increment(); // for type output one more function point
        return functionPoints;
    }

    private static EComplexity calculateProductDataComplexity(int productDataRET, int productDataDET) {
       EComplexity eComplexity;
        if(productDataRET == 1) {
            if(productDataDET > 50)
                eComplexity = LOW;
            else
                eComplexity = MIDDLE;
        } else if(productDataRET <= 5) {
            if(productDataDET <= 19)
                eComplexity = LOW;
            else if(productDataDET <= 50)
                eComplexity = MIDDLE;
            else
                eComplexity = HIGH;
        } else {
            if(productDataDET <= 19)
                eComplexity = MIDDLE;
            else
                eComplexity = HIGH;
        }
        return eComplexity;
    }

    private static FunctionPoints calculateProductDataFunctionPoints
            (EProductDataClassification eProductDataClassification,EComplexity eComplexity) {
        FunctionPoints functionPoints = new FunctionPoints(0);
        if(eProductDataClassification == ILF && eComplexity == LOW)
            functionPoints.setFunctionPoints(7);
        else if(eProductDataClassification == ILF && eComplexity == MIDDLE)
            functionPoints.setFunctionPoints(10);
        else if(eProductDataClassification == ILF && eComplexity == HIGH)
            functionPoints.setFunctionPoints(15);
        else if(eProductDataClassification == EIF && eComplexity == LOW)
            functionPoints.setFunctionPoints(5);
        else if(eProductDataClassification == EIF && eComplexity == MIDDLE)
            functionPoints.setFunctionPoints(7);
        else if(eProductDataClassification == EIF && eComplexity == HIGH)
            functionPoints.setFunctionPoints(10);
        return functionPoints;
    }
}
