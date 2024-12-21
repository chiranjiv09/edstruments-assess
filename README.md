
Edstruments-Assessment


Overview

This project is a Spring Boot application that provides a RESTful API for managing products. It includes CRUD (Create, Read, Update, Delete) operations for products and validates input data.

Features :-

1.Retrieve all products
2.Retrieve a single product by ID
3.Create a new product
4.Update an existing product
5.Delete a product
6.Input validation to ensure product data integrity

Prerequisites :-

1.Java 8 or later
2.Maven
3.MySQL (or any other configured database)

Setup Instructions :
1. Clone the Repository -->
   -- [git clone https://github.com/your-repo/spring-boot-product-api.git](https://github.com/chiranjiv09/edstruments-assess.git)
   -- cd edstruments-assess

2. Configure Database --> Update the application.properties file located in src/main/resources to match your database configuration:
   spring.datasource.url=jdbc:mysql://localhost:3306/edstruments_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

3.  Build the Applicationv--> Use Maven to build the project : mvn clean install
4.  Run the Application
5. Test the Endpoints --> Use tools like curl, Postman, or any API testing tool to test the endpoints.
