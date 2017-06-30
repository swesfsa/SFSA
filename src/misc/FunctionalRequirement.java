package misc;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * @author 9459758
 */
public class FunctionalRequirement {

    private SimpleIntegerProperty _id;
    private int _ftr;
    private int _det;
    private SimpleObjectProperty<LocalDate> _date;
    private SimpleStringProperty _title;
    private String _function;
    private String _protagonist;
    private String _source;
    private String _references;
    private String _description;
    private Priority _priority;
    private FunctionalRequirementClassification _classification;

    public FunctionalRequirement() {}

    public FunctionalRequirement(int id, int ftr, int det, LocalDate date, String title, String function, String protagonist,
                                 String source, String references, String description, Priority priority,
                                 FunctionalRequirementClassification classification) {
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
        _priority = priority;
        _classification = classification;
    }

    public void print() {
        System.out.println("ID: " + _id);
        System.out.println("FTR: " + _ftr);
        System.out.println("DET: " + _det);
        System.out.println("Date: " + _date);
        System.out.println("Title: " + _title);
        System.out.println("Function: " + _function);
        System.out.println("Protagonist: " + _protagonist);
        System.out.println("Source: " + _source);
        System.out.println("References: " + _references);
        System.out.println("Description: " + _description);
        System.out.println("Priority: " + _priority);
        System.out.println("Classification: " + _classification);
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

    public LocalDate getDate() {
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

    public Priority getPriority() {
        return _priority;
    }

    public FunctionalRequirementClassification getClassification() {
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

    public void setDate(LocalDate date) {
        this._date.set(date);
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

    public void setPriority(Priority priority) {
        this._priority = priority;
    }

    public void setClassification(FunctionalRequirementClassification classification) {
        this._classification = classification;
    }
}
