package misc;

/**
 * @author 1030129
 */
public enum EFunctionalRequirementClassification {

    INPUT("Eingabe"),
    OUTPUT("Ausgabe"),
    QUERY("Abfrage");

    private final String _classification;

    EFunctionalRequirementClassification(String classification) {
        this._classification = classification;
    }

    public String getClassification() {
        return _classification;
    }
}
