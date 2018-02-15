# SOLID  

## Single Responsibility Principle (SRP)
* A class should only have one reason to change
* If you have to use "and" or "or" when describing a class, that is a sign you might be violating SRP
* Separate your concerns
* Avoid creating "god objects" - they become difficult to maintain
* See Journal.java

## Open Closed Principle (OCP)
* Should be open for extension but closed for modification
* See ShoppingApp.java

## Liskov Substitution Principle (LSP)
* You should be able to substitute a subclass for a base class
* i.e. if you have an API that uses a base class, swapping in the subclass should not change the correctness of the API
* 