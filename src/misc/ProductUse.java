package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public class ProductUse {

    private String _productUse;

    public ProductUse(String productUse) {
        this._productUse = productUse;
    }

    public void print() {
        System.out.println("ProductUse:\n" + _productUse);
    }
}
