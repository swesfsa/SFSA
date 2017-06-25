package model;

import misc.*;

import java.util.List;

/**
 * @author 9459758
 */
public interface IModel {
    TargetSpecification get_targetSpecification();
    void set_targetSpecification(TargetSpecification _targetSpecification);
    ProductUse get_productUse();
    void set_productUse(ProductUse _productUse);
    Environment get_environment();
    void set_environment(Environment _environment);
    List<FunctionalRequirement> get_functionalRequirementList();
    List<ProductData> get_productDataList();
    void addFunctionalRequirement(FunctionalRequirement functionalRequirement);
    void addProductData(ProductData productData);
}