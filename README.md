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
# Lab 7
Find and replace phone numbers in the text with numbers written in reverse order (for example, 222-15-75 should be written as 57-51-222). The phone number can be in the format ХХХ-ХХ-ХХ, ХХХХХХХ, ХХ-ХХ-ХХ-Х, where Х is a digit. The text should be entered from the console
- When writing a program, you need to use the arrangements for the design of the java code convention.
- The validity of the code should be done through tests
- Performing operations on the text should be done with the help of objects (the use of static methods is prohibited)
- The code has been added to a repository with 2-6 labs
- The code should receive the necessary parameters and return the expected results

# Lab 8
- create a REST service for one of the classes created in laboratory work 2, which implements CRUD-operations (Get / Post / Put / Delete) on the resource and the return operation of all objects.
- The get operation must use the id in the url: / aligator / 20
- The get without id operation in the url should return a list of all available objects
- implement the REST service, the base class from the 8th laboratory should be expanded with the id field (type Integer), and add set / get methods
- Сode should be checked due to Findbugs / checkstyle / pmd plugins
- The controller code and the RestApplication class must be placed in separate packages
- Saving Alligator objects should be done in a Map object
- This lab also involves modifying an existing pom.xml file by adding the necessary dependencies to it.
- Implement the preservation of the object of one of the classes of laboratory work №2 in a table in the database using Spring boot and Spring data. Important: you need to understand how to save the child class and save both parent and child class data. Thus, the child-child class from the 2nd work must have additional attributes
- Data should be stored and read using a database
- The code must match the code convention
- The code should be checked by plug-ins and bug fixes
- The code must contain a separate class * Controller, * Service and * Repository interface
- Configuring access to the database must be implemented through a property file

