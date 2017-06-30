package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import misc.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;

/**
 * @author 9459758
 */
@XmlRootElement
public class Model extends Subject implements IModel {
    private TargetSpecification _targetSpecification;
    private ProductUse _productUse;
    private Environment _environment;
    private ObservableList<FunctionalRequirement> _functionalRequirementList;
    private ObservableList<ProductData> _productDataList;
    private Factors _factors;
    private File _file;


    public Model() {
        reset();
    }

    public void notifyObservers() {
        for(IObserver observer : observerList)
            observer.update(this);
    }

    public CostEstimation costEstimationCalculation() {
        return FPCalc.costEstimationCalculation(_functionalRequirementList, _productDataList, _factors);
    }

    public void xmlExport(File file) throws JAXBException {
        XML.xmlExport(this, file);
    }

    public void reset() {
        if(observerList == null) // creating new project holds observer
            observerList = new ArrayList<>();
        _targetSpecification = new TargetSpecification("");
        _productUse = new ProductUse("");
        _environment = new Environment("", "");
        _functionalRequirementList = FXCollections.observableArrayList();
        _productDataList = FXCollections.observableArrayList();
        _factors = new Factors();
        _file = null;
    }

    public void xmlImport(File file) throws JAXBException, SAXException {
        IModel model = XML.xmlImport(file);
        _targetSpecification = model.getTargetSpecification();
        _productUse = model.getProductUse();
        _environment = model.getEnvironment();
        _functionalRequirementList = model.getFunctionalRequirementList();
        _productDataList = model.getProductDataList();
        _factors = model.getFactors();
        _file = null; // set working _file to null, XML import isn't saved as .sfsa
        notifyObservers();
    }

    public ObservableList<FunctionalRequirement> getFunctionalRequirementList() {
        return _functionalRequirementList;
    }

    public void addFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        _functionalRequirementList.add(functionalRequirement);
        notifyObservers();
    }

    public ObservableList<ProductData> getProductDataList() {
        return _productDataList;
    }

    public void addProductData(ProductData productData) {
        _productDataList.add(productData);
        notifyObservers();
    }

    public TargetSpecification getTargetSpecification() {
        return _targetSpecification;
    }

    public void setTargetSpecification(TargetSpecification targetSpecification) {
        this._targetSpecification = targetSpecification;
        notifyObservers();
    }

    public ProductUse getProductUse() {
        return _productUse;
    }

    public void setProductUse(ProductUse productUse) {
        this._productUse = productUse;
        notifyObservers();
    }

    public Environment getEnvironment() {
        return _environment;
    }

    public void setEnvironment(Environment environment) {
        this._environment = environment;
        notifyObservers();
    }

    public Factors getFactors() {
        return _factors;
    }

    public void setFactors(Factors factors) {
        this._factors = factors;
        notifyObservers();
    }

    public File getFile() {
        return _file;
    }

    public void setFile(File file) {
        this._file = file;
        notifyObservers();
    }

    @Override
    public IModel getState() {
        return this;
    }
}