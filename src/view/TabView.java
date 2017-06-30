package view;

import javafx.scene.layout.AnchorPane;
import misc.IObserver;
import misc.IState;
import model.IModel;

/**
 * Created by 1030129 on 12.05.17.
 */
public class TabView extends ViewTemplate implements IObserver {

    protected AnchorPane _anchorPane;

    public AnchorPane getAnchorPane() {
        return _anchorPane;
    }

    public void update(IState state) {
        if(state.getClass() == IModel.class)
            this._model = (IModel) state.getState();
        else
            System.out.println("Wrong state class received");
    }
}
