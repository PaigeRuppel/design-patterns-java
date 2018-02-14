import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WebShoppingApp {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product firetruck = new Product("Firetruck", Color.RED, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.YUGE);

        List<Product> products = new ArrayList<>();
        products.add(apple);
        products.add(tree);
        products.add(firetruck);
        products.add(house);

        ProductFilter pf = new ProductFilter();

        System.out.println("Green products (old): ");
        pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.getName() + " is green"));
    }
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

    public Stream<Product> filterByColorAndSize(List<Product> productList, Color colorToFilterBy, Size sizeToFilterBy) {
        return productList.stream().filter(p -> p.getColor() == colorToFilterBy && p.getSize() == sizeToFilterBy);
    }

    //imagine how hairy this could get as more filters are added to product....
}
