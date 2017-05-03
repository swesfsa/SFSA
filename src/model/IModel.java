package model;

import misc.*;

import java.util.List;

/**
 * @author 9459758
 */
public interface IModel {
    TargetSpecification getTargetSpecification();
    void setTargetSpecification(TargetSpecification targetSpecification);
    ProductUse getProductUse();
    void setProductUse(ProductUse productUse);
    Environment getEnvironment();
    void setEnvironment(Environment environment);
    List<FunctionalRequirement> getFunctionalRequirementList();
    List<ProductData> getProductDataList();
    void addFunctionalRequirement(FunctionalRequirement functionalRequirement);
    void addProductData(ProductData productData);
}