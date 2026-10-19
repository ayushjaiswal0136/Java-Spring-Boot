package Day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>(List.of(
                new Product(1, "Laptop", 75000, "Electronics"),
                new Product(2, "Mouse", 800, "Electronics"),
                new Product(3, "Desk", 12000, "Furniture"),
                new Product(4, "Chair", 6000, "Furniture")));

        System.out.println("Before: " + products);
        System.out.println("Mouse vs Laptop: " + products.get(1).compareTo(products.get(0)));

        Collections.sort(products);          // uses Product.compareTo
        System.out.println("After natural sort (price): " + products);

        // Strings are Comparable already
        List<String> words = new ArrayList<>(List.of("banana", "Cherry", "apple"));
        Collections.sort(words);
        System.out.println("Strings natural: " + words);

        words.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Strings ignoring case: " + words);
    }
}