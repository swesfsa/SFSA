package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public class Environment {

    private String hardwareEnvironment;
    private String softwareEnvironment;

    public Environment(String hardwareEnvironment, String softwareEnvironment) {
        this.hardwareEnvironment = hardwareEnvironment;
        this.softwareEnvironment = softwareEnvironment;
    }

    public String getHardwareEnvironment() {
        return hardwareEnvironment;
    }

    public String getSoftwareEnvironment() {
        return softwareEnvironment;
    }

    public void print() {
        System.out.println("HardwareEnvironment:\n" + hardwareEnvironment);
        System.out.println("SoftwareEnvironment:\n" + softwareEnvironment);
    }
}
