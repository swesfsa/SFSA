package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import misc.ProductUse;
import model.IModel;

import java.io.IOException;
import java.util.Observable;

import static misc.Log.LOGGER;

/**
 * Created by 1030129 on 28.04.17.
 */
public class ProductUseView extends TabView implements IProductUseView{

    private Button _deleteButton;
    private Button _editButton;
    private Button _saveButton;

    private TextArea _productUse;

    /**
     * @author 1030129
     * @throws Exception
     */
    public ProductUseView(IModel iModel) throws IOException {

        _iModel = iModel;

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/ProductUse.fxml"));

        _deleteButton = (Button) root.lookup("#deleteButton");
        _editButton = (Button) root.lookup("#editButton");
        _saveButton = (Button) root.lookup("#saveButton");
        _productUse = (TextArea) root.lookup("#textArea");
        _anchorPane = (AnchorPane) root.lookup("#AnchorPane");

        update(null, null);
        setEditable(false);
    }

    public void setEditable(boolean editable) {
        _productUse.setEditable(editable);
        if (editable) {
            _editButton.setText("Abbrechen");
        } else {
            _editButton.setText("Bearbeiten");
        }
    }

    public ProductUse getProductUse() {
        ProductUse productUse = new ProductUse();
        productUse.setProductUse(_productUse.getText());
        return productUse;
    }

    public void setProductUse(ProductUse productUse) {
        _productUse.setText(productUse.getProductUse());
    }

    @Override
    public void update(Observable o, Object arg) {

        if(_iModel.getProductUse() != null)
            setProductUse(_iModel.getProductUse());
        else
            LOGGER.severe("Product Use null");
    }

    /**
     * @author 1030129
     * @return _deleteButton
     */
    public Button getDeleteButton() {
        return _deleteButton;
    }

    /**
     * @author 1030129
     * @return _editButton
     */
    public Button getEditButton() {
        return _editButton;
    }

    /**
     * @author 1030129
     * @return _saveButton
     */
    public Button getSaveButton() {
        return _saveButton;
    }

}
