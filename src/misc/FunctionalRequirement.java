package misc;

import exception.EmptyChoiceBoxException;
import exception.EmptyTextFieldException;
import exception.NumberSmallerOneException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import static misc.Log.LOGGER;

/**
 * @author 9459758
 */
public class FunctionalRequirement {

    private SimpleIntegerProperty _id;
    private int _ftr;
    private int _det;
    private SimpleObjectProperty<Date> _date;
    private SimpleObjectProperty<LocalDate> Test;

    private SimpleStringProperty _title;
    private String _function;
    private String _protagonist;
    private String _source;
    private String _references;
    private String _description;
    private EPriority _ePriority;
    private EFunctionalRequirementClassification _classification;

    public FunctionalRequirement() {
        _id = new SimpleIntegerProperty();
        _date = new SimpleObjectProperty<>();
        _title = new SimpleStringProperty();
        Test = new SimpleObjectProperty<>();
    }

    public FunctionalRequirement(int id, int ftr, int det, Date date, String title, String function, String protagonist,
                                 String source, String references, String description, EPriority ePriority,
                                 EFunctionalRequirementClassification classification) {
        _id = new SimpleIntegerProperty(id);
        _ftr = ftr;
        _det = det;
        _date = new SimpleObjectProperty<>(date);
        _title = new SimpleStringProperty(title);
        _function = function;
        _protagonist = protagonist;
        _source = source;
        _references = references;
        _description = description;
        _ePriority = ePriority;
        _classification = classification;
    }

    public LocalDate getTest() {
        //return _date.get().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return null;
    }

    public void setTest() {
    }
    public void check() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException {
        if (/*_date == null ||*/ _title.getValue().equals("") || _function.equals("")
                || _protagonist.equals("") || _description.equals("")) {
            throw new EmptyTextFieldException();
        }
        if (_ePriority == null || _classification == null) {
            throw new EmptyChoiceBoxException();
        }
        if (_id.getValue() < 1 || _ftr < 1 || _det < 1) {
            throw new NumberSmallerOneException();
        }
    }

    public void print() {
        LOGGER.finer("ID: " + _id);
        LOGGER.finer("FTR: " + _ftr);
        LOGGER.finer("DET: " + _det);
        //LOGGER.finer("Date: " + _date);
        LOGGER.finer("Title: " + _title);
        LOGGER.finer("Function: " + _function);
        LOGGER.finer("Protagonist: " + _protagonist);
        LOGGER.finer("Source: " + _source);
        LOGGER.finer("References: " + _references);
        LOGGER.finer("Description: " + _description);
        LOGGER.finer("EPriority: " + _ePriority);
        LOGGER.finer("Classification: " + _classification);
    }

    public int getId() {
        return _id.get();
    }

    public int getFtr() {
        return _ftr;
    }

    public int getDet() {
        return _det;
    }

    public Date getDate() {
        return _date.get();
    }

    public String getTitle() {
        return _title.get();
    }

    public String getFunction() {
        return _function;
    }

    public String getProtagonist() {
        return _protagonist;
    }

    public String getSource() {
        return _source;
    }

    public String getReferences() {
        return _references;
    }

    public String getDescription() {
        return _description;
    }

    public EPriority getPriority() {
        return _ePriority;
    }

    public EFunctionalRequirementClassification getClassification() {
        return _classification;
    }

    public void setId(int id) {
        this._id.set(id);
    }

    public void setFtr(int ftr) {
        this._ftr = ftr;
    }

    public void setDet(int det) {
        this._det = det;
    }

    public void setDate(Date date) {
        _date.set(date);
    }

    public void setTitle(String title) {
        this._title.set(title);
    }

    public void setFunction(String function) {
        this._function = function;
    }

    public void setProtagonist(String protagonist) {
        this._protagonist = protagonist;
    }

    public void setSource(String source) {
        this._source = source;
    }

    public void setReferences(String references) {
        this._references = references;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public void setPriority(EPriority ePriority) {
        this._ePriority = ePriority;
    }

    public void setClassification(EFunctionalRequirementClassification classification) {
        this._classification = classification;
    }


    public int get_id() {
        return _id.get();
    }

    public SimpleIntegerProperty _idProperty() {
        return _id;
    }

    public void set_id(int _id) {
        this._id.set(_id);
    }

    public int get_ftr() {
        return _ftr;
    }

    public void set_ftr(int _ftr) {
        this._ftr = _ftr;
    }

    public int get_det() {
        return _det;
    }

    public void set_det(int _det) {
        this._det = _det;
    }

    public String get_title() {
        return _title.get();
    }

    public SimpleStringProperty _titleProperty() {
        return _title;
    }

    public void set_title(String _title) {
        this._title.set(_title);
    }

    public String get_function() {
        return _function;
    }

    public void set_function(String _function) {
        this._function = _function;
    }

    public String get_protagonist() {
        return _protagonist;
    }

    public void set_protagonist(String _protagonist) {
        this._protagonist = _protagonist;
    }

    public String get_source() {
        return _source;
    }

    public void set_source(String _source) {
        this._source = _source;
    }

    public String get_references() {
        return _references;
    }

    public void set_references(String _references) {
        this._references = _references;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public EPriority get_ePriority() {
        return _ePriority;
    }

    public void set_ePriority(EPriority _ePriority) {
        this._ePriority = _ePriority;
    }

    public EFunctionalRequirementClassification get_classification() {
        return _classification;
    }

    public void set_classification(EFunctionalRequirementClassification _classification) {
        this._classification = _classification;
    }
}
