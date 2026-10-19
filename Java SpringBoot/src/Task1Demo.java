public class Task1Demo {
    public  static void main(String[] args){

        // Create 3 tasks
        Task1 task1 = new Task1(1,"Design API");
        Task1 task2 = new Task1(2, "Write Tests", "IN_PROGRESS");
        Task1 task3 = new Task1(3, "Fix Bug");

        // Complete 1 task
        task1.markCompleted();

        // Display all task
        task1.displayTask();
        task2.displayTask();
        task3.displayTask();

        // Print total number of tasks
        System.out.println("Total tasks: " + Task1.getTaskCount());
    }
}
