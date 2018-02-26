package com.paigeruppel.udemy.designpatterns.creational.singleton;

public class LazySingletonDemo {
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing a lazy singleton");
    }

    // performance implication with using synchronized for thread safety
/*    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }*/

    // double-checked locking (this is out of date, but good to be aware of)
    // check for null instance twice
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}