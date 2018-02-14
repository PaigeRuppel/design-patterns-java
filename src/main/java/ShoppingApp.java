import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShoppingApp {
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
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.getName() + " is green"));

        ImprovedFilter improvedFilter = new ImprovedFilter();

        System.out.println("Green products (new):");
        improvedFilter.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.getName() + " is green"));

        System.out.println("Large red items:");
        improvedFilter.filter(products, new AndSpecification<>(
                new ColorSpecification(Color.RED),
                new SizeSpecification(Size.LARGE)
        )).forEach(p -> System.out.println(" - " + p.getName() + " is large and red"));
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

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}

class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getColor() == color;
    }
}

class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize() == size;
    }
}

class AndSpecification<T> implements Specification<T> {

    private Specification<T> first, second;

    AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}


class ImprovedFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(p -> specification.isSatisfied(p));
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
