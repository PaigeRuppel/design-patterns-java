package com.paigeruppel.udemy.designpatterns.creational.singleton;

public class LazySingletonDemo {
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing a lazy singleton");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}