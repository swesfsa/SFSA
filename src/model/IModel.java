package model;

import javafx.collections.ObservableList;
import misc.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Observer;

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
    ObservableList<FunctionalRequirement> getFunctionalRequirementList();
    ObservableList<ProductData> getProductDataList();
    void addFunctionalRequirement(FunctionalRequirement functionalRequirement);
    void addProductData(ProductData productData);
    EstimationConfiguration getEstimationConfiguration();
    void setEstimationConfiguration(EstimationConfiguration estimationConfiguration);
    CostEstimation getCostEstimation();
    void setCostEstimation(CostEstimation costEstimation);
    File getFile();
    void setFile(File file);
    void xmlImport(File file) throws JAXBException, SAXException;
    void xmlExport(File file) throws JAXBException;
    void reset();
    void addObserver(Observer observer);
    CostEstimation costEstimationCalculation();
}