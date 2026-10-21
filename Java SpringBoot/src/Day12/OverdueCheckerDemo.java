package Day12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OverdueCheckerDemo {

    // 'today' is a PARAMETER, not LocalDate.now() inside the method,
    // so any test can pass any date and get a predictable answer
    static boolean isOverdue(LocalDate dueDate, LocalDate today) {
        return today.isAfter(dueDate);
    }

    static long daysOverdue(LocalDate dueDate, LocalDate today) {
        return isOverdue(dueDate, today) ? ChronoUnit.DAYS.between(dueDate, today) : 0;
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 10, 20);

        LocalDate dueYesterday = LocalDate.of(2026, 10, 19);
        LocalDate dueToday = LocalDate.of(2026, 10, 20);
        LocalDate dueNextWeek = LocalDate.of(2026, 10, 27);

        System.out.println("Due yesterday -> overdue: " + isOverdue(dueYesterday, today)
                + ", days: " + daysOverdue(dueYesterday, today));
        System.out.println("Due today -> overdue: " + isOverdue(dueToday, today)
                + ", days: " + daysOverdue(dueToday, today));
        System.out.println("Due next week -> overdue: " + isOverdue(dueNextWeek, today)
                + ", days: " + daysOverdue(dueNextWeek, today));
    }
}