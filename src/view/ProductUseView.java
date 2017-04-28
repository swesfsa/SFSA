package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

/**
 * Created by 1030129 on 28.04.17.
 */
public class ProductUseView {

    Button deleteButton;
    Button editButton;
    Button saveButton;

    TextArea textArea;

    /**
     * @author 1030129
     * @throws Exception
     */
    public ProductUseView() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/ProductUse.fxml"));

            deleteButton = (Button) root.lookup("deleteButton");
            editButton = (Button) root.lookup("editButton");
            saveButton = (Button) root.lookup("saveButton");
            textArea = (TextArea) root.lookup("textArea");
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
}
