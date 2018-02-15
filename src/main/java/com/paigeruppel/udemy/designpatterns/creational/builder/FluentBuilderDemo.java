package com.paigeruppel.udemy.designpatterns.creational.builder;

public class FluentBuilderDemo {
    public static void main(String[] args) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Person paige = employeeBuilder.withName("Paige").worksAt("Developer").build();
        System.out.println(paige);
    }
}

class Person {
    private String name;
    private String position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + "\'" + ", position='" + position + "\'" + "}";
    }
}

//This type argument expects a type to be passed to PersonBuilder, but that type must extend PersonBuilder
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.setName(name);
        return self();
    }

    public Person build() {
        return person;
    }
// this will allow you to override this behavior in derived classes
    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    // this is a problem - you can not use polymorphism with the current configuration
    // You can use recursive generics to overcome this problem
    public EmployeeBuilder worksAt(String position) {
        person.setPosition(position);
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }

}
