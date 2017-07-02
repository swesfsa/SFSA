package misc;

import exception.EmptyTextFieldException;

/**
 * Created by 1030129 on 03.05.17.
 */
public class ProductUse {

    private String _productUse;

    public ProductUse() {}

    public ProductUse(String productUse) {
        this._productUse = productUse;
    }

    public void check() throws EmptyTextFieldException {
        if (_productUse.equals("")) {
            throw new EmptyTextFieldException();
        }
    }
    public void print() {
        System.out.println("ProductUse:\n" + _productUse);
    }

    public String getProductUse() {
        return _productUse;
    }

    public void setProductUse(String productUse) {
        this._productUse = productUse;
    }
}
