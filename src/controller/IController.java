package controller;

import javafx.scene.layout.AnchorPane;
import view.EmptyTextFieldException;
import view.IView;

/**
 * @author 9459758
 */
public interface IController {
    void show();
    void getDataFromView() throws EmptyTextFieldException, EmptyChoiceBoxException, NumberSmallerOneException;
    AnchorPane getAnchorPane();
}
