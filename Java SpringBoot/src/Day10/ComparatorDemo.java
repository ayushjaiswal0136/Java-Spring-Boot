package Day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    private static List<Product> sample() {
        return new ArrayList<>(List.of(
                new Product(1, "Laptop", 75000, "Electronics"),
                new Product(2, "Mouse", 800, "Electronics"),
                new Product(3, "Desk", 12000, "Furniture"),
                new Product(4, "Chair", 6000, "Furniture")));
    }

    public static void main(String[] args) {

        List<Product> list = sample();
        list.sort(Comparator.comparing(Product::getName));
        System.out.println("By name: " + list);

        list = sample();
        list.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("By price desc: " + list);

        list = sample();
        list.sort(Comparator.comparing(Product::getCategory)
                .thenComparing(Product::getPrice, Comparator.reverseOrder()));
        System.out.println("By category, then price desc: " + list);

        // The same thing written by hand with a lambda
        list = sample();
        list.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        System.out.println("By price asc (lambda): " + list);
    }
}