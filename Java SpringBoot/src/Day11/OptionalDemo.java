package Day11;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

    private static final Map<Integer, String> NICKNAMES = Map.of(1, "ally", 2, "bobby");

    // A method that might have no answer returns Optional instead of null
    static Optional<String> findNickname(int userId) {
        return Optional.ofNullable(NICKNAMES.get(userId));   // get() returns null when missing
    }

    static String expensiveDefault() {
        System.out.println("  (computing default...)");
        return "default";
    }

    public static void main(String[] args) {

        // Creating
        Optional<String> present = Optional.of("hello");
        Optional<String> empty = Optional.empty();
        Optional<String> maybe = Optional.ofNullable(null);
        System.out.println(present + " | " + empty + " | " + maybe);
        System.out.println("isPresent: " + present.isPresent() + ", isEmpty: " + empty.isEmpty());

        // Reading safely
        System.out.println("orElse: " + findNickname(1).orElse("anonymous"));
        System.out.println("orElse (missing): " + findNickname(9).orElse("anonymous"));
        System.out.println("map + orElse: "
                + findNickname(2).map(String::toUpperCase).orElse("ANONYMOUS"));
        System.out.println("filter: "
                + findNickname(1).filter(n -> n.length() > 4).orElse("too short"));

        findNickname(1).ifPresent(n -> System.out.println("ifPresent: " + n));
        findNickname(9).ifPresentOrElse(
                n -> System.out.println("found " + n),
                () -> System.out.println("ifPresentOrElse: no nickname"));

        // Turn "missing" into an exception
        try {
            findNickname(9).orElseThrow(() -> new IllegalArgumentException("No nickname for user 9"));
        } catch (IllegalArgumentException e) {
            System.out.println("orElseThrow: " + e.getMessage());
        }

        // orElse always evaluates its argument; orElseGet runs only when needed
        System.out.println("orElse:");
        Optional.of("value").orElse(expensiveDefault());
        System.out.println("orElseGet:");
        Optional.of("value").orElseGet(OptionalDemo::expensiveDefault);

        // The two classic mistakes
        try {
            Optional.empty().get();
        } catch (NoSuchElementException e) {
            System.out.println("get() on empty: " + e.getMessage());
        }
        try {
            Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("Optional.of(null) throws NullPointerException");
        }

        // Streams return Optional for "maybe there is one"
        Optional<String> firstZ = List.of("Amy", "Bob").stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst();
        System.out.println("findFirst: " + firstZ);
    }
}