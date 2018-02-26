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

* Shallow Copying = assigning a reference to one object to another object - the two objects share the same reference, so changing one object will automatically affect the other object
* Deep Copying = can be achieved through the .clone() method - by assigning every data field to a new instance of that object
    * You can accomplish this through the Cloneable interface, but this is not the best approach
    * A copy constructor is a more palatable approach

___

## Singleton
* The design pattern everyone loves to hate
    * *When discussing which patterns to drop, we found that we still love them all. (Not really - I'm in favor of dropping Singleton. Its use is almost always a design smell.)* -Erich Gamma
* For systems that are supposed to be extensible and testable, Singleton is often a smell.
* Motivation: 
    * For some components it makes sense to only have one instance in the system
        * Database repository
        * Object factory
    * E.g., the constructor call is **expensive**
        * We only do it once
        * We provide everyone with the same instance
    * Want to prevent anyone creating additional copies 

*Singleton* = A component which is instantiated only once

##### Problems
1. You can use reflection to get around the singleton mechanism
2. Serialization - this will also violate the singleton mechanism