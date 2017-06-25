package misc;

/**
 * @author 1030129
 */
public enum FunctionalRequirementClassification {

    INPUT("Eingabe"),
    OUTPUT("Ausgabe"),
    QUERY("Abfrage");

    private final String _classification;

    private FunctionalRequirementClassification(String classification) {
        _classification = classification;
    }

    public String get_classification() {
        return _classification;
    }
}
