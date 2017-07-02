package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public enum EProductDataClassification {
    ILF("ILF"),
    EIF("EIF");

    private final String _classification;

    private EProductDataClassification(String classification) {
        this._classification = classification;
    }

    public String getClassification() {
        return _classification;
    }
}
