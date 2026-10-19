package Day10;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {

        // Predicate: yes/no question
        Predicate<String> isLong = s -> s.length() > 5;
        Predicate<String> startsWithJ = s -> s.startsWith("J");
        System.out.println("Is 'Spring' long: " + isLong.test("Spring"));
        System.out.println("Is 'Java' long: " + isLong.test("Java"));
        System.out.println("Long and starts with J ('JavaScript'): "
                + isLong.and(startsWithJ).test("JavaScript"));
        System.out.println("Not long ('Java'): " + isLong.negate().test("Java"));

        // Function: transform
        Function<String, Integer> length = String::length;
        Function<Integer, Integer> doubleIt = n -> n * 2;
        System.out.println("Length then double ('Java'): " + length.andThen(doubleIt).apply("Java"));

        // BiFunction: two inputs
        BiFunction<Double, Integer, Double> bonus = (salary, percent) -> salary * percent / 100;
        System.out.println("Bonus: " + bonus.apply(55000.0, 10));

        // Supplier: produce a value on demand
        Supplier<String> defaultName = () -> "Guest";
        System.out.println("Default name: " + defaultName.get());

        // UnaryOperator: same type in and out
        UnaryOperator<String> upper = String::toUpperCase;
        System.out.println("Upper: " + upper.apply("java"));

        // Our own functional interface
        Validator<String> notBlank = v -> v != null && !v.isBlank();
        Validator<String> maxTen = v -> v.length() <= 10;
        Validator<String> username = notBlank.and(maxTen);
        System.out.println("Username 'alice' valid: " + username.validate("alice"));
        System.out.println("Username '' valid: " + username.validate(""));
        System.out.println("Username 'averyveryverylongname' valid: "
                + username.validate("averyveryverylongname"));

        // Consumer: do something with a value, return nothing
        Consumer<String> printer = message -> System.out.println("Consumer prints: " + message);
        printer.accept("Hello consumer");
    }
}