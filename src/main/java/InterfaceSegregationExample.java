public class InterfaceSegregationExample {
}

class Document {

}

interface Machine {
    void print(Document document);
    void fax(Document document);
    void scan(Document document);
}

class MultiFunctionPrinter implements Machine {

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

// problem here = only have one option for implementation
class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document document) {

    }

    // we don't need these methods - so leave them empty? This will still give the user
    // the impression that faxing and scanning are still supported
    @Override
    public void fax(Document document) {
//        throw new Exception(); You could throw an exception, but then it will need to be propagated up to the interface
    }

    @Override
    public void scan(Document document) {

    }
}
