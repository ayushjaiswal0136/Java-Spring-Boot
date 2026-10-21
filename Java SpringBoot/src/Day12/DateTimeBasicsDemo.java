package Day12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeBasicsDemo {
    public static void main(String[] args) {

        // Months are 1-12 (not 0-11 like the old Date class)
        LocalDate date = LocalDate.of(2026, 10, 20);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime meeting = LocalDateTime.of(2026, 10, 20, 14, 30);
        LocalDate parsed = LocalDate.parse("2026-12-25");      // ISO format only: yyyy-MM-dd

        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + meeting);
        System.out.println("Parsed: " + parsed);

        System.out.println("Year: " + date.getYear() + ", Month: " + date.getMonth()
                + " (" + date.getMonthValue() + "), Day: " + date.getDayOfMonth());
        System.out.println("Day of week: " + date.getDayOfWeek());
        System.out.println("Leap year: " + date.isLeapYear());
        System.out.println("Days in month: " + date.lengthOfMonth());

        // Immutable: plusDays returns a NEW object, 'date' itself never changes
        LocalDate later = date.plusDays(15);
        System.out.println("Original: " + date);
        System.out.println("Plus 15 days: " + later);
        System.out.println("Minus 1 month: " + date.minusMonths(1));
        System.out.println("First of month: " + date.withDayOfMonth(1));

        // Month-end clamping: there is no Feb 31, so Java picks the last valid day
        System.out.println("Jan 31 + 1 month: " + LocalDate.of(2026, 1, 31).plusMonths(1));

        // Comparing
        LocalDate deadline = LocalDate.of(2026, 10, 25);
        System.out.println("Deadline after date: " + deadline.isAfter(date));
        System.out.println("Same day: " + date.isEqual(LocalDate.of(2026, 10, 20)));

        DayOfWeek day = date.getDayOfWeek();
        boolean weekend = day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
        System.out.println("Weekend: " + weekend);

        // Depends on your clock, so the output differs every run
        System.out.println("Today (will differ): " + LocalDate.now());
    }
}