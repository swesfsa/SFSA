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
    //private LocalDate _date;
    private SimpleObjectProperty<LocalDate> _date;
    private SimpleStringProperty _title;
    private String _function;
    private String _protagonist;
    private String _source;
    private String _references;
    private String _description;
    private Priority _priority;
    private FunctionalRequirementClassification _classification;

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

    public int get_id() {
        return _id.get();
    }

    public int get_ftr() {
        return _ftr;
    }

    public int get_det() {
        return _det;
    }

    public LocalDate get_date() {
        return _date.get();
    }

    public String get_title() {
        return _title.get();
    }

    public String get_function() {
        return _function;
    }

    public String get_protagonist() {
        return _protagonist;
    }

    public String get_source() {
        return _source;
    }

    public String get_references() {
        return _references;
    }

    public String get_description() {
        return _description;
    }

    public Priority get_priority() {
        return _priority;
    }

    public FunctionalRequirementClassification get_classification() {
        return _classification;
    }
}
