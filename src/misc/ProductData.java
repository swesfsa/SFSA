package misc;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 1030129 on 03.05.17.
 */
public class ProductData {

    private SimpleIntegerProperty _id;
    private int _ret;
    private int _det;
    private SimpleStringProperty _memoryContent;
    private String _references;
    private String _estimation;
    private ProductDataClassification _classification;

    public ProductData(int id, int ret, int det, String memoryContent, String references, String estimation,
                       ProductDataClassification classification) {
        _id = new SimpleIntegerProperty(id);
        _ret = ret;
        _det = det;
        _memoryContent = new SimpleStringProperty(memoryContent);
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

    public int getId() {
        return _id.get();
    }

    public int getRet() {
        return _ret;
    }

    public int getDet() {
        return _det;
    }

    public String getMemoryContent() {
        return _memoryContent.get();
    }

    public String getReferences() {
        return _references;
    }

    public String getEstimation() {
        return _estimation;
    }

    public ProductDataClassification getClassification() {
        return _classification;
    }

    public void setId(int id) {
        this._id.set(id);
    }

    public void setRet(int ret) {
        this._ret = ret;
    }

    public void setDet(int det) {
        this._det = det;
    }

    public void setMemoryContent(String memoryContent) {
        this._memoryContent.set(memoryContent);
    }

    public void setReferences(String references) {
        this._references = references;
    }

    public void setEstimation(String estimation) {
        this._estimation = estimation;
    }

    public void setClassification(ProductDataClassification classification) {
        this._classification = classification;
    }
}
