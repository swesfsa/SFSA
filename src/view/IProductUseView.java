package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import misc.ProductUse;

import java.util.Observable;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IProductUseView extends ITabView {

    Button getSaveButton();
    Button getEditButton();
    Button getDeleteButton();

    ProductUse getProductUse();
    void setProductUse(ProductUse productUse);

    void setEditable(boolean editable);
    void update(Observable o, Object arg);
}
