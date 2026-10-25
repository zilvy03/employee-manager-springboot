# Employee Management System

A Spring Boot web application for managing employee records using MySQL, Spring Data JPA, Lombok, and Thymeleaf.

## Features

- Add new employees
- View all employees in a table
- Edit and update employee details
- Delete employee records
- Store employee data in MySQL

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL / XAMPP
- Lombok
- Thymeleaf
- Maven

## Database Setup

1. Start MySQL using XAMPP.
2. Create the database named `employee_db` in phpMyAdmin if it does not already exist.
3. Configure the database username and password in `secrets.properties` in the project root.

Use `secrets.properties.example` as a reference for the required configuration keys. Do not commit your real database credentials.

## Run the Application

1. Open the project in VS Code or another Java IDE.
2. Ensure MySQL is running.
3. Open a terminal in the project root.
4. Run:

   ```bash
   .\mvnw.cmd spring-boot:run
   ```

5. Open `http://localhost:8081` in your browser.

The application uses port `8081` as configured in `application.properties`.

## GitHub

Repository: https://github.com/zilvy03/employee-manager-springboot.git