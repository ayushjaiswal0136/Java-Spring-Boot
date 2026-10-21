package Day12;

public enum TaskStatus {

    TODO("To Do", false),
    IN_PROGRESS("In Progress", false),
    DONE("Done", true);

    private final String label;
    private final boolean finished;

    // Enum constructors are always private; Java calls them once per constant
    TaskStatus(String label, boolean finished) {
        this.label = label;
        this.finished = finished;
    }

    public String getLabel() { return label; }
    public boolean isFinished() { return finished; }

    public TaskStatus next() {
        return switch (this) {
            case TODO -> IN_PROGRESS;
            case IN_PROGRESS -> DONE;
            case DONE -> throw new IllegalStateException("Task is already done");
        };
    }
}