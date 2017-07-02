package misc;

import exception.EmptyTextFieldException;

/**
 * Created by 1030129 on 03.05.17.
 */
public class Environment {

    private String _hardwareEnvironment;
    private String _softwareEnvironment;

    public Environment() {}

    public Environment(String hardwareEnvironment, String softwareEnvironment) {
        this._hardwareEnvironment = hardwareEnvironment;
        this._softwareEnvironment = softwareEnvironment;
    }

    public void check() throws EmptyTextFieldException {
        if (_hardwareEnvironment.equals("") || _softwareEnvironment.equals("")) {
            throw new EmptyTextFieldException();
        }
    }
    public String getHardwareEnvironment() {
        return _hardwareEnvironment;
    }

    public String getSoftwareEnvironment() {
        return _softwareEnvironment;
    }

    public void setHardwareEnvironment(String hardwareEnvironment) {
        this._hardwareEnvironment = hardwareEnvironment;
    }

    public void setSoftwareEnvironment(String softwareEnvironment) {
        this._softwareEnvironment = softwareEnvironment;
    }

    public void print() {
        System.out.println("HardwareEnvironment:\n" + _hardwareEnvironment);
        System.out.println("SoftwareEnvironment:\n" + _softwareEnvironment);
    }
}
