package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public class Environment {

    private String _hardwareEnvironment;
    private String _softwareEnvironment;

    public Environment(String hardwareEnvironment, String softwareEnvironment) {
        _hardwareEnvironment = hardwareEnvironment;
        _softwareEnvironment = softwareEnvironment;
    }

    public String get_hardwareEnvironment() {
        return _hardwareEnvironment;
    }

    public String get_softwareEnvironment() {
        return _softwareEnvironment;
    }

    public void print() {
        System.out.println("HardwareEnvironment:\n" + _hardwareEnvironment);
        System.out.println("SoftwareEnvironment:\n" + _softwareEnvironment);
    }
}
