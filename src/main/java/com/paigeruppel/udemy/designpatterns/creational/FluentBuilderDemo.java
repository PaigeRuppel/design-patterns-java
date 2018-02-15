package com.paigeruppel.udemy.designpatterns.creational;

public class FluentBuilderDemo {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person paige = personBuilder.withName("Paige").build();
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

    public PersonBuilder withName(String name) {
        person.setName(name);
        return this;
    }

    public Person build() {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder {
    // this is a problem - you can not use polymorphism with the current configuration
    // You can use recursive generics to overcome this problem
    public EmployeeBuilder worksAt(String position) {
        person.setPosition(position);
        return this;
    }

}
