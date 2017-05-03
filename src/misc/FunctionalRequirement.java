package misc;

import java.time.LocalDate;

/**
 * @author 9459758
 */
public class FunctionalRequirement {

    private int id;
    private int ftr;
    private int det;
    private LocalDate date;
    private String title;
    private String function;
    private String protagonist;
    private String source;
    private String references;
    private String description;
    private Priority priority;
    private FunctionalRequirementClassification classification;

    public FunctionalRequirement(int id, int ftr, int det, LocalDate date, String title, String function, String protagonist,
                                 String source, String references, String description, Priority priority,
                                 FunctionalRequirementClassification classification) {
        this.id = id;
        this.ftr = ftr;
        this.det = det;
        this.date = date;
        this.title = title;
        this.function = function;
        this.protagonist = protagonist;
        this.source = source;
        this.references = references;
        this.description = description;
        this.priority = priority;
        this.classification = classification;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("FTR: " + ftr);
        System.out.println("DET: " + det);
        System.out.println("Date: " + date);
        System.out.println("Title: " + title);
        System.out.println("Function: " + function);
        System.out.println("Protagonist: " + protagonist);
        System.out.println("Source: " + source);
        System.out.println("References: " + references);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Classification: " + classification);
    }

}
