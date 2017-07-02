package view;

import controller.ICreateItemController;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import misc.EProductDataClassification;
import misc.ProductData;

import java.util.Map;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface ICreateProductDataView extends ICreateItemView {

    ProductData getProductData();
    void setProductData(ProductData productData);

}
