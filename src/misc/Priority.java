package misc;

/**
 * @author 9459758
 */
public enum Priority {
    LOW("Niedrig"),
    MIDDLE("Mittel"),
    HIGH("Hoch");

    public final String priority;

    private Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}