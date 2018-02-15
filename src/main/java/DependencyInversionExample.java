import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DependencyInversionExample {
    public static void main(String[] args) {
        Person john = new Person("John");
        Person chris = new Person("Chris");
        Person matt = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(john, chris);
        relationships.addParentAndChild(john, matt);

        new Research(relationships);

        //even by commenting out all of the DIP violating code, you don't have to change anything here
    }
}

enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name); // here we can introduce an abstraction
}

class Relationships implements RelationshipBrowser{ // low-level module - simply acting as data storage, no business logic - only data maniuplation (SRP == allow manipulations of the list relations)
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    // DIP says that low-level modules i.e. details should depend on abstractions
    // Why? What if you want to change the implementation? You are going to have to rewrite a lot of code
    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(p -> Objects.equals(p.getValue0().name, name) && p.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

class Research { // high-level module - allows us to perform operations on a low-level module - has business logic
    // but high-level modules should not depend on low-level modules, and that's exactly what this constructor does - violation of DIP
    // instead, this class should depend on abstractions
//    public Research(Relationships relationships) {
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//        relations.stream()
//                .filter(p -> p.getValue0().name.equals("John") && p.getValue1() == Relationship.PARENT)
//                .forEach( ch -> System.out.println("John has a child called " + ch.getValue2().name));
//    }

    // By moving the core funtionality to the low-level module, you no longer have a direct dependency - you can depend on the abstraction
    public Research(RelationshipBrowser browser) {
        List<Person> johnsChildren = browser.findAllChildrenOf("John");
        for (Person child : johnsChildren) {
            System.out.println("John has a child named: " + child.name);
        }
    }
}



class Triplet<U, V, T>
{
    public final U first;   	// first field of a Triplet
    public final V second;  	// second field of a Triplet
    public final T third;   	// third field of a Triplet

    // Constructs a new Triplet with the given values
    public Triplet(U first, V second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o)
    {
		/* Checks specified object is "equal to" current object or not */

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Triplet triplet = (Triplet) o;

        // call equals() method of the underlying objects
        if (!first.equals(triplet.first) ||
                !second.equals(triplet.second) ||
                !third.equals(triplet.third))
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
		/* Computes hash code for an object by using hash codes of
		the underlying objects */

        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        result = 31 * result + third.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    // Factory method for creating a Typed immutable instance of Triplet
    public static <U, V, T> Triplet <U, V, T> of(U a, V b, T c)
    {
        return new Triplet <>(a, b, c);
    }

    public U getValue0() {
        return first;
    }

    public V getValue1() {
        return second;
    }

    public T getValue2() {
        return third;
    }
}