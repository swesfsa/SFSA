package misc;
/**
 * @author 9459758
 */
public class FunctionalRequirement {

    private int id;
    private String author;
    private String description;
    private Priority priority;

    public FunctionalRequirement(int id, String author, String description, Priority priority) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }
}
