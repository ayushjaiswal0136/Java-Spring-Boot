package Day12;

public class EnumDemo {
    public static void main(String[] args) {

        TaskStatus status = TaskStatus.TODO;
        System.out.println("Status: " + status);
        System.out.println("Label: " + status.getLabel());

        status = status.next();
        System.out.println("After next(): " + status);

        for (TaskStatus s : TaskStatus.values()) {
            System.out.println(s + " | " + s.getLabel()
                    + " | finished=" + s.isFinished() + " | ordinal=" + s.ordinal());
        }

        TaskStatus parsed = TaskStatus.valueOf("DONE");
        System.out.println("Parsed: " + parsed + ", == works: " + (parsed == TaskStatus.DONE));

        try {
            TaskStatus.valueOf("done");
        } catch (IllegalArgumentException e) {
            System.out.println("valueOf is case-sensitive: " + e.getMessage());
        }

        try {
            TaskStatus.DONE.next();
        } catch (IllegalStateException e) {
            System.out.println("Business rule: " + e.getMessage());
        }

        // switch over an enum: no default needed, the compiler checks every constant is covered
        String message = switch (status) {
            case TODO -> "Not started";
            case IN_PROGRESS -> "Work in progress";
            case DONE -> "Finished";
        };
        System.out.println("Message: " + message);
    }
}