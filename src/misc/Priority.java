package misc;

/**
 * @author 9459758
 */
public enum Priority {
    LOW("Niedrig"),
    MIDDLE("Mittel"),
    HIGH("Hoch");

    public final String _priority;

    private Priority(String priority) {
        _priority = priority;
    }

    public String get_priority() {
        return _priority;
    }
}