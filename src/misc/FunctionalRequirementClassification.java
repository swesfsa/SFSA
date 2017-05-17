package misc;

/**
 * @author 1030129
 */
public enum FunctionalRequirementClassification {

    INPUT("Eingabe"),
    OUTPUT("Ausgabe"),
    QUERY("Abfrage");

    private final String classification;

    private FunctionalRequirementClassification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
}
