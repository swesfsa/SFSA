package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import misc.ProductData;
import misc.ProductUse;

/**
 * Created by 1030129 on 02.05.17.
 */
public interface IProductDataView extends ITableView {

    Button getNewButton();
    Button getEditButton();
    Button getDeleteButton();

    TableColumn getIdColumn();
    TableColumn getMemoryContentColumn();

    void loadDetailView(ProductData productData);
}
