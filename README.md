# JavaLabs
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
