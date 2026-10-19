package Day7;

public class Task implements Auditable {

    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_DONE = "DONE";

    private final int id;
    private String title;
    private String status;
    private final String createdBy;

    public Task(int id, String title, String createdBy) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Task title cannot be blank"
            );
        }

        this.id = id;
        this.title = title;
        this.createdBy = createdBy;
        this.status = STATUS_PENDING;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Task title cannot be blank"
            );
        }
        this.title = title;
    }

    public void markCompleted() {
        status = STATUS_DONE;
    }
}