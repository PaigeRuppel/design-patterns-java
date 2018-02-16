package com.paigeruppel.udemy.designpatterns.creational.prototype;

import java.util.Arrays;

public class PrototypeDemo {
    public static void main(String[] args) throws Exception {
        Person john = new Person(new String[]{"John", "Doe"}, new Address("London Road", 123));

        // It would be nice to do this... but you can't
        Person jane = (Person) john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;


        System.out.println(john);
        System.out.println(jane);
    }
}

// Cloneable does not provide any hints as to whether it is a deep copy or a shallow copy
class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber); // this is a valid deep copy mechanic with String(immutable) and an int
    }
}

class Person implements Cloneable{
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
/*  You may be tempted to do this - but it is fundamentally incorrect because you are still copying references to objects
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(names, address);
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(
                names.clone(),
                (Address) address.clone());
    }
}