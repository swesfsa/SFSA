package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.IModel;

/**
 * Created by 1030129 on 28.04.17.
 */
public class ProductUseView extends TabView implements IProductUseView{

    private IModel model;

    private Button deleteButton;
    private Button editButton;
    private Button saveButton;

    private TextArea productUse;

    /**
     * @author 1030129
     * @throws Exception
     */
    public ProductUseView(IModel model) throws Exception{

        this.model = model;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/ProductUse.fxml"));

        deleteButton = (Button) root.lookup("#deleteButton");
        editButton = (Button) root.lookup("#editButton");
        saveButton = (Button) root.lookup("#saveButton");
        productUse = (TextArea) root.lookup("#textArea");
        anchorPane = (AnchorPane) root.lookup("#AnchorPane");
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
     * @return editButton
     */
    public Button getEditButton() {
        return editButton;
    }

    /**
     * @author 1030129
     * @return saveButton
     */
    public Button getSaveButton() {
        return saveButton;
    }

    /**
     * @author 1030129
     * @return productUse
     */
    public TextArea getProductUse() {
        return productUse;
    }
}
