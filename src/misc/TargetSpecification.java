package misc;

/**
 * Created by 1030129 on 03.05.17.
 */
public class TargetSpecification {

    private String _targetSpecification;

    public TargetSpecification(String targetSpecification) {
        _targetSpecification = targetSpecification;
    }

    public void print() {
        System.out.println("TargetSpecification:\n" + _targetSpecification);
    }
}
