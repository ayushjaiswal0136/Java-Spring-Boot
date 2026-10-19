package Day10;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaBasicsDemo {
    public static void main(String[] args) {

        // Old way: anonymous class
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class says hi");
            }
        };

        // New way: lambda
        Runnable lambda = () -> System.out.println("Lambda says hi");

        anonymous.run();
        lambda.run();

        // Lambda forms
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = n -> n * n;
        Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());

        Function<Integer, String> sign = n -> {          // multi-line body needs { } and return
            if (n > 0) {
                return "positive";
            } else if (n < 0) {
                return "negative";
            }
            return "zero";
        };

        System.out.println("Sum: " + add.apply(5, 3));
        System.out.println("Square of 7: " + square.apply(7));
        System.out.println("Compare hi vs hello: " + byLength.compare("hi", "hello"));
        System.out.println("Sign of -4: " + sign.apply(-4));

        // A lambda can use a local variable only if it never changes afterwards
        String greeting = "Hello";
        Consumer<String> greeter = name -> System.out.println(greeting + ", " + name);
        greeter.accept("Ayush");
        // greeting = "Hi";   // uncomment: compile error, greeting must be effectively final
    }
}