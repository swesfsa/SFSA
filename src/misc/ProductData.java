package misc;


/**
 * Created by 1030129 on 03.05.17.
 */
public class ProductData {

    private int id;
    private int ret;
    private int det;
    private String memoryContent;
    private String references;
    private String estimation;
    private ProductDataClassification classification;

    public ProductData(int id, int ret, int det, String memoryContent, String references, String estimation,
                       ProductDataClassification classification) {
        this.id = id;
        this.ret = ret;
        this.det = det;
        this.memoryContent = memoryContent;
        this.references = references;
        this.estimation = estimation;
        this.classification = classification;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("MemoryContent: " + memoryContent);
        System.out.println("Estimation: " + estimation);
        System.out.println("References: " + references);
        System.out.println("RET: " + ret);
        System.out.println("DET: " + det);
        System.out.println("Classification: " + classification);
    }
}
