package misc;

import javafx.scene.text.Text;

/**
 * Created by 1030129 on 03.05.17.
 */
public class ProductUse {

    private String productUse;

    public ProductUse(String productUse) {
        this.productUse = productUse;
    }

    public void print() {
        System.out.println("ProductUse:\n" + productUse);
    }
}
