package Day7;

public class CompletedTasksReport extends Report {

    private final Task[] tasks;

    public CompletedTasksReport(Task[] tasks) {
        this.tasks = tasks;
    }

    @Override
    public String buildBody() {
        StringBuilder report = new StringBuilder();
        report.append("Completed Tasks:\n");

        for (Task task : tasks) {
            if (Task.STATUS_DONE.equals(task.getStatus())) {
                report.append("- ")
                        .append(task.getTitle())
                        .append("\n");
            }
        }

        return report.toString();
    }
}