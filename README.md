#  Library Management System

##  Project Overview

The Library Management System is a Java-based web application developed using layered architecture principles.
It is designed to manage books and authors efficiently with proper separation of concerns.
The system allows users to:
* Add new books
* View book details using ISBN
* Manage author information
* Store and retrieve data from an Oracle database
This project demonstrates how to build a scalable and maintainable enterprise application using Java technologies.
---

#  Architecture
The application follows a **Layered Architecture** pattern:

### 1️ Bean Layer (Model Layer)
Contains Java classes representing database entities.
Examples:
* `BookBean`
* `AuthorBean`

Responsibilities:
* Store data
* Provide getters and setters
* Represent table structure in object form
---

### 2️ DAO Layer (Data Access Layer)
Classes:
* `BookDao`
* `AuthorDao`

Responsibilities:
* Perform database operations
* Execute SQL queries
* Insert and retrieve records
* Maintain database connectivity using `DBUtil`
This layer isolates database logic from business logic.
---

### 3️ Service Layer (Business Logic Layer)
Class:
* `Administrator`

Responsibilities:
* Apply business rules
* Validate data
* Communicate between DAO and Servlet layer
* Decide success, failure, or invalid cases
---

### 4️ Controller Layer (Servlet Layer)
Class:
* `MainServlet`
Responsibilities:
* Handle HTTP requests
* Process form data
* Call service methods
* Redirect or forward responses
---

#  Database Design
## AUTHOR_TBL

| Column Name | Data Type    | Description        |
| ----------- | ------------ | ------------------ |
| AUTHOR_CODE | NUMBER (PK)  | Unique author ID   |
| AUTHOR_NAME | VARCHAR2(50) | Name of the author |
| CONTACT_NO  | NUMBER(10)   | Contact number     |

## BOOK_TABLE

| Column Name | Data Type       | Description                |
| ----------- | --------------- | -------------------------- |
| ISBN        | VARCHAR2(20) PK | Unique Book ID             |
| BOOK_TITLE  | VARCHAR2(100)   | Title of the book          |
| BOOK_TYPE   | CHAR(1)         | G = General, T = Technical |
| AUTHOR_CODE | NUMBER (FK)     | References AUTHOR_TBL      |
| BOOK_COST   | NUMBER(8,2)     | Cost of the book           |

Relationship:
* One Author → Many Books (One-to-Many Relationship)
---

#  Technologies Used

* Java (JDK 8+)
* Servlets
* JDBC
* Oracle Database (XE)
* Apache Tomcat 9
* HTML
* Eclipse IDE
* Git & GitHub
---

#  Application Flow

1. User submits form from HTML page.
2. Servlet receives request.
3. Servlet calls Service layer.
4. Service layer calls DAO layer.
5. DAO executes SQL query.
6. Result is returned back through layers.
7. User receives response (Success / Invalid / Failure).
---

#  Key Concepts Demonstrated

* Layered Architecture
* MVC Design Pattern
* JDBC Connectivity
* Foreign Key Relationship
* Session Management
* Exception Handling
* Request Forwarding & Redirection
---

#  Learning Outcomes

Through this project, the following concepts are implemented and understood:
* Separation of concerns
* Clean code structure
* Database integration with Java
* Real-time form handling
* Structured enterprise application design
---
<img width="530" height="121" alt="LIB 1" src="https://github.com/user-attachments/assets/af62a101-9abd-4aac-a0f4-87af3b438ba9" />
<img width="561" height="278" alt="LIB 2" src="https://github.com/user-attachments/assets/68e1e886-551f-40cf-a760-d77088ca6d32" />
<img width="528" height="287" alt="LIB 3" src="https://github.com/user-attachments/assets/a692960b-752f-4b13-b866-045c640c1d3a" />
<img width="503" height="144" alt="LIB 4" src="https://github.com/user-attachments/assets/2b72f4fe-f4ba-4275-82c4-2387e86bba98" />
<img width="555" height="145" alt="LIB 5" src="https://github.com/user-attachments/assets/cef047d5-d8e0-4186-98d6-cb839327cf05" />
<img width="619" height="126" alt="LIB 6" src="https://github.com/user-attachments/assets/5f2a3d98-49a4-481f-b764-90005c1d07ba" />
<img width="376" height="513" alt="LIB 7" src="https://github.com/user-attachments/assets/7a8e9a16-2776-40d5-bd05-088189cd3275" />






