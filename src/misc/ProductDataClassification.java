package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public enum ProductDataClassification {
    ILF("ILF"),
    EIF("EIF");

    private final String _classification;

    private ProductDataClassification(String classification) {
        this._classification = classification;
    }

    public String getClassification() {
        return _classification;
    }
}
