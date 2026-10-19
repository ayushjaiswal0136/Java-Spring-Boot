package Day6;

public class BugTask extends Task {
    private String severity;

    public BugTask(int id, String title, String severity) {
        super(id, title); // Call the parent constructor
        this.severity = severity;
    }

    @Override
    public void displayTask() {
        super.displayTask(); // Display parent task details
        System.out.println("Severity: " + severity);
    }
}
