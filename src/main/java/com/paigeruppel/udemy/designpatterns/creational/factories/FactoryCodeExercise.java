package com.paigeruppel.udemy.designpatterns.creational.factories;

public class FactoryCodeExercise {
    public static void main(String[] args) {
    PersonFactory pf = new PersonFactory();

        System.out.println(pf.createPerson("Bob"));
        System.out.println(pf.createPerson("Paige"));

    }


}

class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ", id: " + id;
    }
}

class PersonFactory {
    private int idSeq = 1;
    public Person createPerson(String name) {
        return new Person(idSeq++, name);
    }
}
