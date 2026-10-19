package Day6;

public class Task {
    private final int id;
    private String title;
    private String status;

    // For Day 8 Exercise
    public void reopen() {
        this.status = STATUS_TODO;
    }

    // Constants for task status
    public static final String STATUS_TODO = "TODO";
    public static final String STATUS_DONE = "DONE";

    public Task(int id, String title) {
        this.id = id;
        setTitle(title); // Validate title through setter
        this.status = STATUS_TODO;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    // Validate and set title
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        this.title = title.trim();
    }

    // Mark task as completed
    public void markCompleted() {
        status = STATUS_DONE;
    }

    // Display task details
    public void displayTask() {
        System.out.println("Task ID: " + id
                + " | Title: " + title
                + " | Status: " + status);
    }
}