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
import view.TargetSpecificationView;

public class SFSAController {

    TargetSpecificationView tsview;

    @FXML
    Tab targetSpecificationTab;

    @FXML
    public void tabPressed(ActionEvent event) throws Exception {
        tsview = new TargetSpecificationView();
    }
}
