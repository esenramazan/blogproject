# Backend Blog Project
This is a Spring Boot Service Project, serving as an example of how to create a clean and organized project.

## Database
The project is configured to use PostgreSQL as its database. However, as this is a Spring JPA project, you can easily switch to a different database. Simply change the database connection information in the `application.properties` file.

## Packages
The project is organized into several packages:

- `controller`: Each POJO class has a corresponding Controller class. Additionally, there's a `GenericController` for managing connections to the frontend project. The Controllers function similarly to the Mediator pattern, handling HTTP requests.
- `domain`: This package contains POJO classes, enum classes, and factory classes for the POJO classes.
- `repository`: Contains Repository classes for each POJO class, utilizing Spring JPA.
- `service`: Contains Service Classes for each POJO class.
- `util`: Contains `GenericResponse` classes, which are custom response examples for your projects using the Factory pattern. You can switch to the AbstractFactory pattern, but then you would need to write an implementation for each POJO class. It's your choice, but the current design is not bad.
- `config`: Currently empty, but you can add bean definitions or security configurations here.
- `dao`: This project does not contain a DAO because it uses a POJO-based design (meaning a DAO class is not needed because the Repository already meets my needs). However, you can modify this to suit your needs and combine database operations in DAO classes.

This project provides a basic and clean design for Spring Boot projects. You can use this style in your projects and develop service projects.







