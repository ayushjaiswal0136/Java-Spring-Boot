package Day10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        List<String> names = List.of("alice", "bob");

        // 1. Method of a specific object
        names.forEach(System.out::println);

        // 2. Static method
        Function<String, Integer> parse = Integer::parseInt;
        System.out.println("Parsed: " + parse.apply("42"));

        // 3. Instance method of "whatever object is passed in"
        Function<String, String> upper = String::toUpperCase;
        System.out.println("Upper: " + upper.apply("alice"));

        // 4. Constructor
        Supplier<List<String>> factory = ArrayList::new;
        System.out.println("New list: " + factory.get());
    }
}