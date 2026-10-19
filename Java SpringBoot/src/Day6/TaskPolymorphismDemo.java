package Day6;



public class TaskPolymorphismDemo {
    public static void main(String[] args) {

        // Store different task types in a parent-type array
        Task[] tasks = {
                new Task(1, "Design API"),
                new BugTask(2, "Fix login bug", "HIGH"),
                new FeatureTask(3, "Add user profile", 5)
        };

        // Polymorphism: each object calls its own displayTask()
        for (Task task : tasks) {
            task.displayTask();
            System.out.println("--------------------");
        }

        // Test title validation
        try {
            new Task(9, "   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}