# Structural Patterns

## Adapter
* Motivation  
  * Just like electrical devices may have different power (interface) requirements, so does software
  * A special device (an adapter) can give us the interface we require from the interface we have

*Adapter* = A construct which adapts an existing interface X to conform to the required interface Y.

_____


## Bridge
* Motivation
  * Bridge prevents a 'Cartesian product' complexity explosion
  * Example:
    * Base class ThreadScheduler
    * Can be preemptive or cooperative
    * Can run on Windows or Unix
    * End up with a 2x2 scenario: WindowsPts, WindowsCts, UnixPts, UnixCts
  * Bridge pattern allows you to avoid entity explosion

*Bridge* = A mechanism that decouples an interface (hierarchy) from an implementation (hierarchy).

___

## Composite
* Motivation
  * Objects use other objects' fields/methods through inheritance and composition
  * Composition lets us make compound objects
    * E.g., a mathematical expression composed of simple expresions; or
    * A shape group made of several different shapes
  * Composite design pattern is used to treat both single (scalar) and composite objects uniformly
    * I.e., Foo and List<Foo> have common APIs

*Composite* + A mechanism for treating individual (scalar) objects and compositions of objects in a uniform manner.

___

## Decorator
* Motivation
  * Want to augment an object with additional functionality
  * Do not want to rewrite or alter existing code - this would violate OCP
  * Want to keep new functionality separate - to uphold SRP
  * Need to be able to interact with existing structures
  * Two options:
    * Inherit from required object if possible; some classes are final
    * For classes that are final - Build a Decorator - which simply references the decorated object(s) and adds needed functionality

*Decorator* = Facilitates the addition of behaviors to individual objects without inheriting from them