package misc;


/**
 * Created by 1030129 on 03.05.17.
 */
public class ProductData {

    private int _id;
    private int _ret;
    private int _det;
    private String _memoryContent;
    private String _references;
    private String _estimation;
    private ProductDataClassification _classification;

    public ProductData(int id, int ret, int det, String memoryContent, String references, String estimation,
                       ProductDataClassification classification) {
        _id = id;
        _ret = ret;
        _det = det;
        _memoryContent = memoryContent;
        _references = references;
        _estimation = estimation;
        _classification = classification;
    }

    public void print() {
        System.out.println("ID: " + _id);
        System.out.println("MemoryContent: " + _memoryContent);
        System.out.println("Estimation: " + _estimation);
        System.out.println("References: " + _references);
        System.out.println("RET: " + _ret);
        System.out.println("DET: " + _det);
        System.out.println("Classification: " + _classification);
    }

    public int get_id() {
        return _id;
    }

    public int get_ret() {
        return _ret;
    }

    public int get_det() {
        return _det;
    }

    public String get_memoryContent() {
        return _memoryContent;
    }

    public String get_references() {
        return _references;
    }

    public String get_estimation() {
        return _estimation;
    }

    public ProductDataClassification get_classification() {
        return _classification;
    }
}
