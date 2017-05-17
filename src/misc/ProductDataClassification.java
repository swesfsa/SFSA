package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public enum ProductDataClassification {
    ILF("ILF"),
    EIF("EIF");

    private final String classification;

    private ProductDataClassification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
}
