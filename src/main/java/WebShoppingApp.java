import java.util.List;
import java.util.stream.Stream;

public class WebShoppingApp {
}

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, YUGE
}

class Product {
    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> productList, Color colorToFilterBy) {
        return productList.stream().filter(p -> p.getColor() == colorToFilterBy);
    }

    public Stream<Product> filterBySize(List<Product> productList, Size sizeToFilterBy) {
        return productList.stream().filter(p -> p.getSize() == sizeToFilterBy);
    }
}
