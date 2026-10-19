package Day9;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {

        Set<String> skills = new HashSet<>();
        System.out.println("Added Java: " + skills.add("Java"));
        System.out.println("Added Spring: " + skills.add("Spring"));
        System.out.println("Added Java again: " + skills.add("Java"));   // false
        System.out.println("Size: " + skills.size());
        System.out.println("Has Spring: " + skills.contains("Spring"));

        // Remove duplicates from a list, keeping the original order
        List<Integer> withDuplicates = List.of(3, 1, 3, 2, 1);
        Set<Integer> unique = new LinkedHashSet<>(withDuplicates);
        System.out.println("Unique (insertion order): " + unique);

        // TreeSet keeps items sorted
        Set<String> sorted = new TreeSet<>(List.of("Zebra", "Apple", "Mango"));
        System.out.println("Sorted: " + sorted);
    }
}