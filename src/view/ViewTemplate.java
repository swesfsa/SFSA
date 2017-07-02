package view;

import model.IModel;

/**
 * @author 9459758
 */
public abstract class ViewTemplate {

    protected IModel _iModel;

    ViewTemplate() {}

    public void setModel(IModel _iModel) {
        this._iModel = _iModel;
    }
}
