package view;

import javafx.stage.Stage;
import misc.IObserver;
import misc.IState;
import misc.StageHandler;
import model.IModel;

import java.util.Observer;

/**
 * @author 9459758
 */
public abstract class ViewTemplate {

    protected IModel _model;

    ViewTemplate() {}

    public void setModel(IModel _model) {
        this._model = _model;
    }
}
