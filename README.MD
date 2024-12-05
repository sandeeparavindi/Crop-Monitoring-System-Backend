# ✅ Crop Monitoring System (SpringBoot)

This project is a robust and secure backend REST API for a Farm Management System. Developed with *Spring Boot, it provides endpoints for managing entities such as crops, fields, users, and more. It ensures data security with **JWT-based authentication* and *role-based access control* while following a clean and scalable layered architecture.

---

## Table of Contents
1. [Overview](#overview)
2. [Tech Stack](#tech-stack)
3. [Features](#features)
4. [System Architecture](#system-architecture)
5. [Installation](#installation)
6. [Database Design](#database-design)
7. [API Documentation](#api-documentation)
8. [Testing](#testing)
9. [Deployment](#deployment)
10. [License](#license)

---

## Overview
The *Farm Backend* simplifies farm management tasks with efficient RESTful APIs, enabling seamless integration with front-end systems. The architecture supports scalability and maintainability:
- *Controller Layer:* Manages HTTP requests and responses.
- *Service Layer:* Implements core business logic.
- *Repository Layer:* Interacts with the database via Spring Data JPA.
- *Entity Layer:* Defines database models.
- *Security Layer:* Ensures application security through JWT authentication.

---

## Tech Stack
- *Core Framework:* Spring Boot 3.3.5
- *Database:* MySQL
- *Security:* Spring Security, JWT (io.jsonwebtoken)
- *ORM:* Hibernate
- *Validation:* Hibernate Validator
- *Object Mapping:* ModelMapper
- *Build Tool:* Maven
- *Logging:* SLF4J with Logback
- *Testing:* JUnit 5, Mockito
- *Utilities:* Apache Commons Lang3
- *Optional:* Thymeleaf (for server-side rendering if required)

---

## Features
1. *Crop Management*
    - Add, view, update, and delete crop details.
    - Include crop images (Base64 encoded).

2. *Field Management*
    - Manage fields, including location and size.

3. *User Management*
    - User registration, login, and role-based access control.

4. *Security*
    - JWT authentication and secure password storage using BCrypt.

5. *Data Validation*
    - Validate entities and DTOs using Hibernate Validator.

6. *Search and Filtering*
    - Search crops and fields by various parameters such as name, type, or location.

---

## System Architecture
The system follows a *Layered Architecture*:
1. *Controller Layer*
    - Exposes endpoints for clients.
    - Converts responses into JSON.

2. *Service Layer*
    - Contains business logic.
    - Validates data before sending it to the repository.

3. *Repository Layer*
    - Uses Spring Data JPA for database interactions.

4. *Entity Layer*
    - Represents database tables as JPA entities.

5. *Security Layer*
    - Provides JWT-based authentication.
    - Role-based access ensures restricted data access.

---

## Installation

### Prerequisites
1. *Java 21:* Ensure JDK 17 is installed.
2. *Maven:* For building the project.
3. *MySQL Database:* Set up and configure MySQL.

### Steps
1. *Clone the repository*:
   ```bash
   https://github.com/sandeeparavindi/Crop-Monitoring-System-Backend.git
   cd CropMonitoringSystem-Backend
   
2. *Database Setup:*
   Create a MySQL database:
   sql
   CREATE DATABASE crop_monitoring_system;


3. *Configure Application Properties:*
   Update the application.properties file:
   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/crop_monitoring_system
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true


4. *Build and Run:*
   bash
   mvn clean install
   mvn spring-boot:run


---

## Database Design

### ER Diagram
Design your tables for clear relationships between entities like crops, fields, and users.

- *Crop Table*
    - Fields: id, cropCode, cropName, cropType, season, image, field_id.

- *Field Table*
    - Fields: id, fieldCode, fieldName, size, location.

- *User Table*
    - Fields: id, username, password, role.

---

## [API Documentation](https://documenter.getpostman.com/view/35385607/2sAYBbco3t)

## License

### [MIT](https://github.com/sandeeparavindi/Crop-Monitoring-System-Backend/blob/master/License.txt) License

## Copyright

Copyright (c) 2024 SANDEEPA RAVINDI. All rights reserved.