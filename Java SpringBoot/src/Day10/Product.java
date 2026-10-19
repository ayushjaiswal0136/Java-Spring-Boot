package Day10;

public class Product implements Comparable<Product> {

    private final int id;
    private final String name;
    private final double price;
    private final String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    // Natural order: cheapest first
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + "(" + price + ")";
    }
}