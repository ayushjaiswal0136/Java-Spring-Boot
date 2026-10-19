public class Task1 {

    // Declare instance variable
    private final int id;
    private String title;
    private String status;

    // Count total no of tasks created
    private static int taskCount = 0;

    // Default status for tasks
    private static final String DEFAULT_STATUS = "TODO";

    // Constructor 1: Initialize all fields
    public Task1(int id, String title, String status){
        this.id = id;
        this.title = title;
        this.status = status;
        taskCount++;
    }

    // Constructor 2: Use default status through this()
    public Task1(int id, String title){
        this(id, title, DEFAULT_STATUS);
    }

    // Mark the task done
    public void markCompleted(){
        this.status = "DONE";
    }

    // Display task details
    public void displayTask() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Status: " + status);
        System.out.println("-------------------");
    }

    // Return the total number of tasks created
    public static int getTaskCount() {
        return taskCount;
    }
}
