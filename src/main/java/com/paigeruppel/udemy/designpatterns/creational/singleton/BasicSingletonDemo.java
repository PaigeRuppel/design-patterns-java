package com.paigeruppel.udemy.designpatterns.creational.singleton;

import java.io.*;

public class BasicSingletonDemo {
    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println("After direct creation:");
        System.out.println(singleton);

        String filename = "singleton.bin";
        saveToFile(singleton, filename);
        System.out.println("Set value to 555");
        singleton.setValue(555);

        BasicSingleton deserialized = readFromFile(filename);
        System.out.println("After deserialization:");
        System.out.println(deserialized);

        System.out.println(singleton == deserialized);
        System.out.println("Value of singleton: " + singleton.getValue());
        System.out.println("Value of deserialized singleton: " + deserialized.getValue());
    }
}

class BasicSingleton implements Serializable {

    private int value = 0;

    private BasicSingleton() {}

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BasicSingleton{" +
                "value=" + value +
                '}';
    }
}
