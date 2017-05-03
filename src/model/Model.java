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

    public Model() {
        targetSpecification = new TargetSpecification("");
        productUse = new ProductUse("");
        environment = new Environment("", "");
        functionalRequirementList = new ArrayList<>();
        productDataList = new ArrayList<>();
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