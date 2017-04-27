package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.scene.text.TextFlow;

public class SFSAController {

    @FXML
    private TextField targetDefinitionTextField;

    @FXML
    private TextField productUseTextField;

    @FXML
    private Button targetDefinitionFinishButton;

    @FXML
    private Button productUseFinishButton;

    @FXML
    private Button targetDefinitionEditButton;

    @FXML
    private Button productUseEditButton;

    @FXML
    private Button targetDefinitionDeleteButton;

    @FXML
    private Button productUseDeleteButton;

    @FXML
    void targetDefinitionSaveButtonPressed(ActionEvent event) {
        targetDefinitionTextField.setEditable(false);
    }

    @FXML
    void targetDefinitonEditButtonPressed(ActionEvent event) {
        targetDefinitionEditButton.setDisable(true);
        targetDefinitionEditButton.setVisible(false);
        targetDefinitionFinishButton.setDisable(false);
        targetDefinitionFinishButton.setVisible(true);
        targetDefinitionTextField.setEditable(true);
    }

    @FXML
    void targetDefinitionDeleteButtonPressed(ActionEvent event) {
        targetDefinitionTextField.deleteText(0, targetDefinitionTextField.getLength());
    }

    @FXML
    void targetDefinitionFinishButtonPressed(ActionEvent event) {
        targetDefinitionEditButton.setDisable(false);
        targetDefinitionEditButton.setVisible(true);
        targetDefinitionTextField.setEditable(false);
        targetDefinitionFinishButton.setDisable(true);
        targetDefinitionFinishButton.setVisible(false);
    }

    @FXML
    void productUseFinishButtonPressed(ActionEvent event) {
        productUseEditButton.setDisable(false);
        productUseEditButton.setVisible(true);
        productUseTextField.setEditable(false);
        productUseFinishButton.setDisable(true);
        productUseFinishButton.setVisible(false);
    }

    @FXML
    void productUseEditButtonPressed(ActionEvent event) {
        productUseEditButton.setDisable(true);
        productUseEditButton.setVisible(false);
        productUseFinishButton.setDisable(false);
        productUseFinishButton.setVisible(true);
        productUseTextField.setEditable(true);
    }

    @FXML
    void productUseDeleteButtonPressed(ActionEvent event) {
        productUseTextField.deleteText(0, productUseTextField.getLength());
    }

    @FXML
    private ListView<TextFlow> list;

    @FXML
    private Button updateListButton;

    @FXML
    void updateListButtonPressed(ActionEvent event) {

        ObservableList<TextFlow> items = FXCollections.<TextFlow>observableArrayList();

        Text text1 = new Text("Hallo Tim\n");
        text1.setStyle("-fx-font-size: 20; -fx-fill: darkred;");
        Text text2 = new Text("Hallo Thomas");
        text2.setStyle("-fx-font-size: 30; -fx-fill: goldenrod;");
        TextFlow textFlow = new TextFlow(text1, text2);
        items.add(textFlow);

        list.setItems(items);
    }

}
