package Day9;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add("Bob");                       // duplicates are allowed

        System.out.println("List: " + names);
        System.out.println("Size: " + names.size());
        System.out.println("First: " + names.getFirst());
        System.out.println("Last: " + names.getLast());
        System.out.println("Index 1: " + names.get(1));
        System.out.println("Contains Carol: " + names.contains("Carol"));
        System.out.println("First index of Bob: " + names.indexOf("Bob"));

        names.set(0, "Alicia");                 // replace item at index 0
        names.remove("Bob");                    // removes the FIRST match only
        System.out.println("After changes: " + names);

        for (String name : names) {
            System.out.println("Hello " + name);
        }

        // Immutable list: cannot be modified
        List<Integer> fixed = List.of(1, 2, 3);
        try {
            fixed.add(4);
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of is immutable");
        }

        // remove(int index) vs remove(Object value)
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        numbers.remove(Integer.valueOf(20));    // by VALUE
        numbers.remove(0);                      // by INDEX
        System.out.println("Numbers: " + numbers);
    }
}