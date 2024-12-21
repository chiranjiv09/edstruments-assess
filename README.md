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

1.  Clone the Repository -->
2.  -- [https://github.com/chiranjiv09/edstruments-assess.git]

    -- cd edstruments-assess

3.  Configure Database --> Update the application.properties file located in src/main/resources to match your database configuration:

    spring.datasource.url=jdbc:mysql://localhost:3306/edstruments_db

    spring.datasource.username=your_username

    spring.datasource.password=your_password

4.  Build the Applicationv--> Use Maven to build the project : mvn clean install
5.  Run the Application
6.  Test the Endpoints --> Use tools like curl, Postman, or any API testing tool to test the endpoints.

API Endpoints and Example curl Commands -->

1. Get All Products
   Retrieve a list of all products.
   curl -X GET http://localhost:9999/api/products

2. Get a Product by ID
   Retrieve a product by its unique ID.

Example Case 1 (ID: 1):
curl -X GET http://localhost:9999/api/products/1

Example Case 2 (ID: 2):
curl -X GET http://localhost:9999/api/products/2

3. Create a New Product

Create a new product with a specified name, price, and description.

Example Case 1 (Product A):

curl -X POST http://localhost:9999/api/products -H "Content-Type: application/json" -d "{\"name\": \"Product A\", \"price\": 100.00, \"description\": \"First product description\"}"

Example Case 2 (Product B):

curl -X POST http://localhost:9999/api/products -H "Content-Type: application/json" -d "{\"name\": \"Product B\", \"price\": 200.00, \"description\": \"Second product description\"}"

4. Update a Product

Update an existing product's details (name, price, description) by its ID.

Example Case 1 (Update Product A):

curl -X PUT http://localhost:9999/api/products/1 -H "Content-Type: application/json" -d "{\"name\": \"Updated Product A\", \"price\": 120.00, \"description\": \"Updated description for Product A\"}"

Example Case 2 (Update Product B):

curl -X PUT http://localhost:9999/api/products/2 -H "Content-Type: application/json" -d "{\"name\": \"Updated Product B\", \"price\": 250.00, \"description\": \"Updated description for Product B\"}"

5. Delete a Product

Delete a product by its ID.

Example Case 1 (Delete Product A with ID 1):

curl -X DELETE http://localhost:9999/api/products/1

Example Case 2 (Delete Product B with ID 2):

curl -X DELETE http://localhost:9999/api/products/2
