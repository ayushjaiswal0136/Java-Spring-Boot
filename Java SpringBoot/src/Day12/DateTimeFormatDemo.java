package Day12;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeFormatDemo {
    public static void main(String[] args) {

        // ---- Formatting and parsing ----
        LocalDateTime meeting = LocalDateTime.of(2026, 10, 20, 14, 30);
        DateTimeFormatter pretty = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a", Locale.ENGLISH);
        DateTimeFormatter indian = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Pretty: " + meeting.format(pretty));
        System.out.println("Indian style: " + meeting.toLocalDate().format(indian));
        System.out.println("Parsed with pattern: " + LocalDate.parse("25/12/2026", indian));

        try {
            LocalDate.parse("25/12/2026");           // plain parse() expects yyyy-MM-dd
        } catch (DateTimeParseException e) {
            System.out.println("Plain parse failed: " + e.getClass().getSimpleName());
        }

        // SMART (default for ofPattern) silently "repairs" impossible dates. STRICT rejects them.
        DateTimeFormatter smart = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter strict = DateTimeFormatter.ofPattern("dd-MM-uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        System.out.println("SMART 31-02-2026 -> " + LocalDate.parse("31-02-2026", smart));
        try {
            LocalDate.parse("31-02-2026", strict);
        } catch (DateTimeParseException e) {
            System.out.println("STRICT 31-02-2026 -> rejected");
        }

        try {
            LocalDate.of(2026, 2, 30);
        } catch (DateTimeException e) {
            System.out.println("LocalDate.of: " + e.getMessage());
        }

        // ---- Period, ChronoUnit, Duration ----
        LocalDate birthDate = LocalDate.of(2000, 5, 15);
        LocalDate today = LocalDate.of(2026, 10, 20);
        Period age = Period.between(birthDate, today);
        System.out.println("Age: " + age.getYears() + " years, "
                + age.getMonths() + " months, " + age.getDays() + " days");
        System.out.println("Days until Christmas: "
                + ChronoUnit.DAYS.between(today, LocalDate.of(2026, 12, 25)));

        Duration shift = Duration.between(LocalTime.of(9, 0), LocalTime.of(17, 30));
        System.out.println("Shift: " + shift + " = " + shift.toHours() + "h "
                + shift.toMinutesPart() + "m");
        System.out.println("Total minutes: " + shift.toMinutes());

        // ---- Time zones ----
        ZonedDateTime india = ZonedDateTime.of(
                LocalDateTime.of(2026, 10, 20, 10, 0), ZoneId.of("Asia/Kolkata"));
        System.out.println("India: " + india);
        System.out.println("UTC: " + india.withZoneSameInstant(ZoneId.of("UTC")));
        System.out.println("New York: " + india.withZoneSameInstant(ZoneId.of("America/New_York")));

        // ---- Instant: one exact moment, zone-free ----
        Instant epoch = Instant.ofEpochSecond(0);
        System.out.println("Epoch: " + epoch);
        System.out.println("Epoch in India: " + epoch.atZone(ZoneId.of("Asia/Kolkata")));
    }
}