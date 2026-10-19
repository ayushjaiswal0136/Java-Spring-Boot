package Day7;

public class TaskAssigner {

    private final NotificationService notificationService;

    public TaskAssigner(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void assignTask(Task task, String employee) {
        notificationService.sendNotification(
                "Task '" + task.getTitle()
                        + "' assigned to " + employee
        );
    }
}