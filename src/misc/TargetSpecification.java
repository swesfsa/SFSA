package misc;

import exception.EmptyTextFieldException;

/**
 * Created by 1030129 on 03.05.17.
 */

public class TargetSpecification {

    private String _targetSpecification;

    public TargetSpecification() {}
    public TargetSpecification(String targetSpecification) {
        this._targetSpecification = targetSpecification;
    }

    public void check() throws EmptyTextFieldException {
        if (_targetSpecification.equals("")) {
            throw new EmptyTextFieldException();
        }
    }
    public void print() {
        System.out.println("TargetSpecification:\n" + _targetSpecification);
    }

    public String getTargetSpecification() {
        return _targetSpecification;
    }

    public void setTargetSpecification(String targetSpecification) {
        this._targetSpecification = targetSpecification;
    }
}
