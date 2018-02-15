package com.paigeruppel.udemy.solid;

public class InterfaceSegregationExample {
}

class Document {

}

interface Machine {
    void print(Document document);
    void fax(Document document);
    void scan(Document document);
}

interface Printer {
    void print(Document document);
}

interface FaxMachine {
    void fax(Document document);
}

interface Scanner {
    void scan(Document document);
}

class MultiFunctionPrinter implements Printer, FaxMachine, Scanner {

    @Override
    public void print(Document document) {
        //meaningful code
    }

    @Override
    public void fax(Document document) {
        //meaningful code
    }

    @Override
    public void scan(Document document) {
        //meaningful code
    }
}

class Photocopier implements Printer, Scanner {

    @Override
    public void print(Document document) {

    }

    @Override
    public void scan(Document document) {

    }
}

// problem here = only have one option for implementation
class OldFashionedPrinter implements Printer {

    @Override
    public void print(Document document) {

    }

    // we don't need these methods - so leave them empty? This will still give the user
    // the impression that faxing and scanning are still supported
//    @Override
//    public void fax(com.paigeruppel.udemy.solid.Document document) {
//        throw new Exception(); You could throw an exception, but then it will need to be propagated up to the interface
//    }
//
//    @Override
//    public void scan(com.paigeruppel.udemy.solid.Document document) {
//
//    }
}
