package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.IModel;

/**
 * Created by 1030129 on 28.04.17.
 */
public class ProductDataView extends TabView implements IProductDataView{

    private IModel model;

    private Button newButton;
    private Button editButton;
    private Button deleteButton;

    private ListView dataList;

    /**
     * @author 1030129
     * @throws Exception
     */
    public ProductDataView(IModel model) throws Exception {

        this.model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/ProductData.fxml"));

        newButton = (Button) root.lookup("#newButton");
        editButton = (Button) root.lookup("#editButton");
        deleteButton = (Button) root.lookup("#deleteButton");
        dataList = (ListView) root.lookup("#dataList");
    }

    /**
     * @author 1030129
     * @return newButton
     */
    public Button getNewButton() {
        return newButton;
    }

    /**
     * @author 1030129
     * @return editButton
     */
    public Button getEditButton() {
        return editButton;
    }

    /**
     * @author 1030129
     * @return deleteButton
     */
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * @author 1030129
     * @return dataList
     */
    public ListView getDataList() {
        return dataList;
    }
}
