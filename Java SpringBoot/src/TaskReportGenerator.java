public class TaskReportGenerator {
    public static void main(String[] args){
        // 1 - Create String Array
        String[] tasks = {
                "Design API",
                "Write Tests",
                "Fix Bug #42",
                "Deploy to Staging",
                "code Review"
        };

        // 2 - Create StringBuilder
        StringBuilder report = new StringBuilder();

        // Add Heading
        report.append("Task Reports:\n");

        // Use a for loop to add numbered task to the report
        for(int i=0;i<tasks.length;i++){
            report.append(i+1)
                    .append(". ")
                    .append(tasks[i])
                    .append("\n");
        }

        // Print the final report task
        System.out.println(report.toString());

        // CLean the task  by removing spaces and capitalizing the first letter
        String task = " fix bug #42 ";
        System.out.println("Before: \"" + task + "\"");

        String cleanedTask = task.trim();
        cleanedTask = cleanedTask.substring(0, 1).toUpperCase()
                + cleanedTask.substring(1);
        System.out.println("After: \"" + cleanedTask + "\"");
    }
}