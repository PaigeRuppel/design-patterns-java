# SOLID  

## Single Responsibility Principle (SRP)
* A class should only have one reason to change
* If you have to use "and" or "or" when describing a class, that is a sign you might be violating SRP
* Separate your concerns
* Avoid creating "god objects" - they become difficult to maintain

## Open Closed Principle (OCP)
* Classes should be open for extension but closed for modification

## Liskov Substitution Principle (LSP)
* You should be able to substitute a subclass for a base class
* i.e. if you have an API that uses a base class, swapping in the subclass should not change the correctness of the API


## Interface Segregation Principle (ISP)
* Recommendation on how to split interfaces into smaller interfaces
* Don't put any additional implementation into an interface than what the client will need
* YAGNI => You Ain't Going to Need It
* By splitting interfaces into as small of pieces as possible, you have added flexibility  
  * You can either implement multiple interfaces in your class as needed
  * Or you can make additional interfaces that extend the smaller interfaces as needed

## Dependency Inversion Principle (DIP)
* Does not connect directly to Dependency Injection  
1. High-level modules should not depend on low-level modules  
   Both should depend on abstractions
2. Abstractions should not depend on details  
   Details should depend on abstractions
* Abstractions - typically this means either interfaces or abstract classes
* If possible, use interfaces and abstract classes
* Breaking strong dependencies between low- and high-level modules greatly increases the flexibility of your code



### Other Notes/Thoughts
* All of these principles allow for greater flexibility and reuse.
* SOLID is a catchy but unfortunate acronym (I think that it evokes images of an impenetrable or unbreakable object). FLUID or ADAPT would be a more descriptive acronym. Sticking to SOLID is like breaking a cinder block down into lego blocks.