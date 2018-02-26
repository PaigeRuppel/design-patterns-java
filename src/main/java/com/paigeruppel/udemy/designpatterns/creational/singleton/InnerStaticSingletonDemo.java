package com.paigeruppel.udemy.designpatterns.creational.singleton;

public class InnerStaticSingletonDemo {
}


//this solution avoids the problem associated with synchronization and thread safety - you only ever get one instance
class InnerStaticSingleton {
    private InnerStaticSingleton() {}

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}
