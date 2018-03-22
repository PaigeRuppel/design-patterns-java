# Behavioral Patterns

## Command
* Motivation  
    * Ordinary Java statements are perishable
        * Cannot undo a field assignment
        * Cannot directly serialize a sequence of actions (calls)
    * Want an object that represents an operation
        * X should change its field Y to value Z
        * X should now call its member method w()
    * Uses: GUI commands, multi-level undo/redo, macro recording, etc.  
    
*Command* = An object which represents an instruction to perform a particular action. Contains all the information necessary for the action to be taken


_____