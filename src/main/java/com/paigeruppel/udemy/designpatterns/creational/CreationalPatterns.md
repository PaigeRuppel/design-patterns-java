# Creational Patterns

### Builder
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

### Factory Method 
### Abstract Factory
