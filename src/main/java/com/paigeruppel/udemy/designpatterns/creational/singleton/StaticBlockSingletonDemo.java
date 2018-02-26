package com.paigeruppel.udemy.designpatterns.creational.singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingletonDemo {
}

class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    // when your constructor throws something, you have to include a static block
    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    // static block approach allows more customization with initialization
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("failed to create singleton");
        }
    }

    // object pooling is possible with this approach
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
