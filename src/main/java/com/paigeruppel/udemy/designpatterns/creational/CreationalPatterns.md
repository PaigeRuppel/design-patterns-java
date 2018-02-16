# Creational Patterns

## Builder
* Motivation  
  * Some objects are simple and can be created in a single constructor call
  * Other objects however require a lot of ceremony to create
  * Having an object with 10 constructor arguments is not productive/error prone
  * Instead, opt for piecewise construction
  * Builder provides an API for constructing an object step-by-step  

*Builder* = When piecewise object construction is complicated, provide an API for doing it succinctly.

* You can use fluent interfaces to improve the usability of builders
* You can also use fluent interface inheritance with recursive generics  
  * General reference on generics: http://www.baeldung.com/java-generics
  * Reference on recursive generics: https://www.sitepoint.com/self-types-with-javas-generics/

_____

## Factories 
* Motivation:  
  * Object creation logic becomes too convoluted
  * Constructor is not descriptive  
    * Name mandated by name of containing type
    * Cannot overload with same sets of arguments with different names
    * Can quickly turn into "overloading hell"
  * Wholesale Object Creation (non-piecewise, unlike builder) can be outsourced to:
    * A separate function (Factory Method)
    * That may exist in a separate class (Factory)
    * Can also create a hierarchy of factories (Abstract Factory)

*Factory* = A component responsible solely for the wholesale (not piecewise) creation of objects

## Factory Method 
* Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
## Abstract Factory
* Provide an interface for creating families of related or dependent objects without specifying their concrete classes

___

## Prototype
* Motivation:
  * Complicated objects (i.e. cars) are not designed from scratch - They reiterate existing designs
  * An existing (partially or fully constructed) design is a Prototype
  * You can make a copy (clone) the prototype and customize it - Requires *deep copy* support
  * The cloning must be made convenient (i.e. through a factory)

*Prototype* = A partially or fully initialized object that you copy (clone) and make use of
