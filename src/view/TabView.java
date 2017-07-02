package view;

import javafx.scene.layout.AnchorPane;

import java.util.Observer;

/**
 * Created by 1030129 on 12.05.17.
 */
public abstract class TabView extends ViewTemplate implements Observer {

    protected AnchorPane _anchorPane;

    public AnchorPane getAnchorPane() {
        return _anchorPane;
    }
}
