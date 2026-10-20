package Day11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBasicsDemo {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 12, 8, 3, 20, 15, 8);

        // source -> filter -> map -> terminal
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("Even squares: " + evenSquares);

        System.out.println("Sorted: " + numbers.stream().sorted().toList());
        System.out.println("Distinct sorted: " + numbers.stream().distinct().sorted().toList());
        System.out.println("Skip 1, limit 3: " + numbers.stream().sorted().skip(1).limit(3).toList());

        // Terminal operations that return a single result
        System.out.println("Count > 10: " + numbers.stream().filter(n -> n > 10).count());
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Max: " + numbers.stream().max(Integer::compare).orElse(0));
        System.out.println("Reduce sum: " + numbers.stream().reduce(0, Integer::sum));

        // Yes/no questions
        System.out.println("Any > 19: " + numbers.stream().anyMatch(n -> n > 19));
        System.out.println("All > 0: " + numbers.stream().allMatch(n -> n > 0));
        System.out.println("None < 0: " + numbers.stream().noneMatch(n -> n < 0));

        // Strings
        List<String> words = List.of("java", "spring", "boot", "jpa");
        System.out.println("Upper: "
                + words.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
        System.out.println("Lengths: " + words.stream().map(String::length).toList());
        System.out.println("First longer than 4: "
                + words.stream().filter(w -> w.length() > 4).findFirst().orElse("none"));

        // Number ranges without a loop
        System.out.println("Sum 1 to 5: " + IntStream.rangeClosed(1, 5).sum());
        System.out.println("Squares 1 to 5: "
                + IntStream.rangeClosed(1, 5).map(n -> n * n).boxed().toList());

        // flatMap: flatten a list of lists into one stream
        List<List<String>> skillSets = List.of(
                List.of("Java", "SQL"),
                List.of("Java", "Spring"),
                List.of("Docker", "SQL"));
        System.out.println("All skills: "
                + skillSets.stream().flatMap(List::stream).distinct().sorted().toList());
    }
}