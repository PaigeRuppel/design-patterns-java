# Creational Patterns

## Builder
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