# Hexagonal architecture demo

This project is an example of implementing a hexagonal architecture.

By accessing a GET REST endpoint, the application allows to run an access to a database to get the price information of a product.
If any of the data is wrong, it will be indicated in the output.

JUnit and integration tests are provided with several use cases for testing purposes

To install the application, execute the maven clean install command to load the libraries needed to run the demo.
When launching the application with Spring Boot, the needed schema and example data will be loaded into a H2 database.

The endpoint to access the application is located on this url:

http://localhost:8080/prices/get-price

This additional info must be provided to properly get a return value:
* idBrand
* idProduct
* eventDate (yyyy-MM-dd HH:mm:ss pattern)

```Example
http://localhost:8080/prices/get-price?idBrand=1&idProduct=35455&eventDate=2020-06-14 10:00:00
```
