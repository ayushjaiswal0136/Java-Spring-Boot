package Day9;

import java.util.List;

public class GenericsDemo {

    // Generic method: works with a list of ANY type
    static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.println("Item: " + item);
        }
    }

    // Bounded type: T must be a Number (Integer, Double, ...)
    static <T extends Number> double sum(List<T> numbers) {
        double total = 0;
        for (T number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Box<String> nameBox = new Box<>("Alice");
        Box<Integer> ageBox = new Box<>(30);

        String name = nameBox.getValue();       // no cast needed
        int age = ageBox.getValue();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        // Box<Integer> wrong = new Box<>("text");   // compile error: caught early

        Pair<String, Integer> pair = new Pair<>("Laptop", 5);
        System.out.println("Pair: " + pair);

        printAll(List.of("a", "b"));
        System.out.println("Sum of ints: " + sum(List.of(1, 2, 3)));
        System.out.println("Sum of doubles: " + sum(List.of(1.5, 2.5)));
    }
}