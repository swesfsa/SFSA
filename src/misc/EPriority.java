package misc;

/**
 * @author 9459758
 */
public enum EPriority {
    LOW("Niedrig"),
    MIDDLE("Mittel"),
    HIGH("Hoch");

    public final String _priority;

    private EPriority(String priority) {
        _priority = priority;
    }

    public String getPriority() {
        return _priority;
    }
}