package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import misc.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static misc.Log.LOGGER;

/**
 * @author 9459758
 */
@XmlRootElement
public class Model extends Observable implements IModel {
    private TargetSpecification _targetSpecification;
    private ProductUse _productUse;
    private Environment _environment;
    private ObservableList<FunctionalRequirement> _functionalRequirementList;
    private ObservableList<ProductData> _productDataList;
    private EstimationConfiguration _estimationConfiguration;
    private CostEstimation _costEstimation;
    private File _file;

    public Model() {
        reset();
        _functionalRequirementList.add(new FunctionalRequirement(1,  1, 1, Date.valueOf(LocalDate.now()), "a", "2", "a", "g", "r", "g", EPriority.HIGH, EFunctionalRequirementClassification.INPUT));
    }

    public ObservableList<FunctionalRequirement> get_functionalRequirementList() {
        return _functionalRequirementList;
    }

    public void set_functionalRequirementList(ObservableList<FunctionalRequirement> _functionalRequirementList) {
        this._functionalRequirementList = _functionalRequirementList;
    }

    public ObservableList<ProductData> get_productDataList() {
        return _productDataList;
    }

    public void set_productDataList(ObservableList<ProductData> _productDataList) {
        this._productDataList = _productDataList;
    }

    public CostEstimation costEstimationCalculation() {
        return FPCalc.costEstimationCalculation(_functionalRequirementList, _productDataList, _estimationConfiguration);
    }

    public void xmlExport(File file) throws JAXBException {
        XML.xmlExport(this, file);
    }

    public void reset() {
        _targetSpecification = new TargetSpecification("");
        _productUse = new ProductUse("");
        _environment = new Environment("", "");
        _functionalRequirementList = FXCollections.observableArrayList();
        _productDataList = FXCollections.observableArrayList();
        _estimationConfiguration = new EstimationConfiguration();
        _costEstimation = new CostEstimation();
        _file = null;
    }

    public void xmlImport(File file) throws JAXBException, SAXException {
        LOGGER.info("XML Import started");
        IModel iModel = XML.xmlImport(file);
        LOGGER.info("XML Import successfull");
        _targetSpecification = iModel.getTargetSpecification();
        _productUse = iModel.getProductUse();
        _environment = iModel.getEnvironment();
        _functionalRequirementList = iModel.getFunctionalRequirementList();
        _productDataList = iModel.getProductDataList();
        _estimationConfiguration = iModel.getEstimationConfiguration();
        _file = null; // set working _file to null, XML import isn't saved as .sfsa
        setChanged();
        notifyObservers();
    }

    public ObservableList<FunctionalRequirement> getFunctionalRequirementList() {
        return _functionalRequirementList;
    }

    public void addFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        _functionalRequirementList.add(functionalRequirement);
        _functionalRequirementList.forEach(FunctionalRequirement::print);
        setChanged();
        notifyObservers();
    }

    public ObservableList<ProductData> getProductDataList() {
        return _productDataList;
    }

    public void addProductData(ProductData productData) {
        _productDataList.add(productData);
        setChanged();
        notifyObservers();    }

    public TargetSpecification getTargetSpecification() {
        return _targetSpecification;
    }

    public void setTargetSpecification(TargetSpecification targetSpecification) {
        this._targetSpecification = targetSpecification;
        setChanged();
        notifyObservers();    }

    public ProductUse getProductUse() {
        return _productUse;
    }

    public void setProductUse(ProductUse productUse) {
        this._productUse = productUse;
        setChanged();
        notifyObservers();
    }

    public Environment getEnvironment() {
        return _environment;
    }

    public void setEnvironment(Environment environment) {
        this._environment = environment;
        setChanged();
        notifyObservers();    }

    public EstimationConfiguration getEstimationConfiguration() {
        return _estimationConfiguration;
    }

    public void setEstimationConfiguration(EstimationConfiguration estimationConfiguration) {
        this._estimationConfiguration = estimationConfiguration;
        setChanged();
        notifyObservers();    }

    public CostEstimation getCostEstimation() {
        return _costEstimation;
    }

    public void setCostEstimation(CostEstimation costEstimation) {
        this._costEstimation = costEstimation;
        setChanged();
        notifyObservers();
    }

    public File getFile() {
        return _file;
    }

    public void setFile(File file) {
        this._file = file;
        setChanged();
        notifyObservers();    }
}