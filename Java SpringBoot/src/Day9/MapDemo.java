package Day9;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {

        Map<String, Integer> stock = new HashMap<>();
        stock.put("Laptop", 5);
        stock.put("Mouse", 20);
        stock.put("Keyboard", 10);
        stock.put("Mouse", 25);                 // same key: value is overwritten

        System.out.println("Laptop: " + stock.get("Laptop"));
        System.out.println("Mouse: " + stock.get("Mouse"));
        System.out.println("Monitor (missing): " + stock.get("Monitor"));
        System.out.println("Monitor with default: " + stock.getOrDefault("Monitor", 0));
        System.out.println("Has Laptop: " + stock.containsKey("Laptop"));

        stock.putIfAbsent("Laptop", 99);        // key exists, so no change
        System.out.println("Laptop after putIfAbsent: " + stock.get("Laptop"));

        // Word frequency: the most common Map pattern
        String text = "to be or not to be";
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : text.split(" ")) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        System.out.println("Counts: " + counts);

        // Iterating over key/value pairs
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // TreeMap sorts by key
        Map<String, Integer> sortedCounts = new TreeMap<>(counts);
        System.out.println("Sorted by key: " + sortedCounts);
    }
}