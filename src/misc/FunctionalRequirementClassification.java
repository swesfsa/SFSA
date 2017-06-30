package misc;

/**
 * @author 1030129
 */
public enum FunctionalRequirementClassification {

    INPUT("Eingabe"),
    OUTPUT("Ausgabe"),
    QUERY("Abfrage");

    private final String _classification;

    FunctionalRequirementClassification(String classification) {
        this._classification = classification;
    }

    public String getClassification() {
        return _classification;
    }
}
