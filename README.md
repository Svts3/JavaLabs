# JavaLabs
# Lab2
Office equipment store.
- Implement the hierarchy of equipment present in the store.
- Really look for equipment of a certain type in the specified price range.
- Implement the ability to sort the found equipment by two types of parameters (optional, implemented as two separate methods)
- Implementation of sorting should provide the ability to sort both in descending and ascending order
# Lab3
- Create a class - Manager that will contain logic
- The implementation of sorting should provide the ability to sort both in descending and ascending order
- Use the built-in sorting methods available in Java to sort
- Sorting should be implemented in a separate method
- The code does not contain static methods / attributes. Only one static method is allowed - void
- Code must use enum type (if necessary)
# Lab4
Convert a project with 2-3 work code so that its build can be done with maven.
At the same time it is necessary to make the merge command of previous works in master
# Lab 5
- write modular tests for laboratory work code №4 and achieve 80% test coverage
# Lab 6
Two methods should be implemented for each Device-derived class and in the Crocodile class itself:
- getHeaders - returns a string of attributes present in this class, separated by commas
- toCSV - returns the value of attributes (field values) of this object, separated by commas.The implementation of the toCSV method in child classes should also call this method from the parent class. Fields declared in the parent class must be converted to a comma-separated tape in the parent class
- The challenge of this method should be implemented from the tests
The code must match the code convention
- Also, you should add checkstyle and spotbugs plugins to pom.xml and test the code with these parsers
You should also fix any errors that spotbugs will find and reduce the number of errors that checkstyle points out.

