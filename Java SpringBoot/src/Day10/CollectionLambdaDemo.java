package Day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CollectionLambdaDemo {
    public static void main(String[] args) {

        // removeIf / replaceAll / forEach
        List<Integer> scores = new ArrayList<>(List.of(40, 85, 30, 92, 55));
        scores.removeIf(s -> s < 50);
        System.out.println("After removeIf: " + scores);

        scores.replaceAll(s -> s + 5);
        System.out.println("After replaceAll: " + scores);

        scores.forEach(s -> System.out.println("Score: " + s));

        // Sort by length, then alphabetically
        List<String> words = new ArrayList<>(List.of("pear", "fig", "banana", "kiwi", "apple"));
        words.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("Sorted by length then alphabet: " + words);

        // Map.merge: counting without the if/else
        Map<String, Integer> counts = new TreeMap<>();
        for (String word : "to be or not to be".split(" ")) {
            counts.merge(word, 1, Integer::sum);
        }
        System.out.println("Word counts: " + counts);

        // Map.computeIfAbsent: grouping without the containsKey check
        Map<Integer, List<String>> byLength = new TreeMap<>();
        for (String word : List.of("java", "go", "spring", "rust")) {
            byLength.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }
        System.out.println("By length: " + byLength);

        counts.forEach((word, count) -> System.out.println(word + " -> " + count));
    }
}