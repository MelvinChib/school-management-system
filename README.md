# School Management System

A comprehensive Spring Boot application for managing students, teachers, courses, and enrollments in an educational institution.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Database Schema](#database-schema)
- [Contributing](#contributing)

## Overview

The School Management System is a RESTful web application built with Spring Boot that provides comprehensive functionality for managing educational institutions. It follows a layered architecture pattern with clear separation of concerns between presentation, business logic, and data access layers.

## Features

### Core Functionality
- **Student Management**: Create, read, update, and delete student records
- **Teacher Management**: Manage teacher information and assignments
- **Course Management**: Handle course creation and teacher assignments
- **Enrollment System**: Track student enrollments in courses
- **Data Validation**: Comprehensive input validation using Bean Validation
- **Object Mapping**: Automatic entity-DTO mapping using MapStruct

### Technical Features
- RESTful API design
- JPA/Hibernate for data persistence
- Automatic database schema generation
- Comprehensive error handling
- Layered architecture pattern
- Dependency injection with Spring

## Architecture

The application follows a standard layered architecture:

```
┌─────────────────┐
│   Controllers   │  ← REST API endpoints
├─────────────────┤
│    Services     │  ← Business logic layer
├─────────────────┤
│   Repositories  │  ← Data access layer
├─────────────────┤
│    Entities     │  ← JPA entities
└─────────────────┘
```

### Key Components

- **Controllers**: Handle HTTP requests and responses
- **Services**: Implement business logic and orchestrate operations
- **Repositories**: Provide data access using Spring Data JPA
- **DTOs**: Data Transfer Objects for API communication
- **Mappers**: Convert between entities and DTOs using MapStruct
- **Entities**: JPA entities representing database tables

## Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **MapStruct** - Object mapping
- **Lombok** - Reduce boilerplate code
- **Bean Validation** - Input validation
- **Maven** - Build and dependency management
- **H2/MySQL/PostgreSQL** - Database support

## Project Structure

```
src/
├── main/
│   ├── java/com/melvin/School/Management/System/
│   │   ├── Controller/          # REST controllers
│   │   ├── Service/             # Business logic services
│   │   │   ├── TeacherService.java
│   │   │   └── TeacherServiceImpl.java
│   │   ├── Repository/          # Data access repositories
│   │   │   ├── StudentRepository.java
│   │   │   ├── TeacherRepository.java
│   │   │   ├── CourseRepository.java
│   │   │   └── EnrollmentRepository.java
│   │   ├── Model/               # JPA entities
│   │   │   ├── Student.java
│   │   │   ├── Teacher.java
│   │   │   ├── Course.java
│   │   │   └── Enrollment.java
│   │   ├── Dto/                 # Data Transfer Objects
│   │   │   ├── StudentDTO.java
│   │   │   ├── TeacherDTO.java
│   │   │   └── CourseDTO.java
│   │   ├── Mapper/              # MapStruct mappers
│   │   │   ├── StudentMapper.java
│   │   │   ├── TeacherMapper.java
│   │   │   └── CourseMapper.java
│   │   ├── Configuration/       # Spring configuration
│   │   ├── Security/            # Security configuration
│   │   ├── Utility/             # Utility classes
│   │   └── SchoolManagementSystemApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/              # Static web resources
│       └── templates/           # Thymeleaf templates
└── test/                        # Test classes
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Database (H2 for development, MySQL/PostgreSQL for production)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd School-Management-System
   ```

2. **Configure the database**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   # H2 Database (Development)
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driver-class-name=org.h2.Driver
   spring.h2.console.enabled=true
   
   # MySQL (Production)
   # spring.datasource.url=jdbc:mysql://localhost:3306/school_management
   # spring.datasource.username=your_username
   # spring.datasource.password=your_password
   # spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
   # JPA Configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

3. **Build the project**
   ```bash
   mvn clean compile
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   - Application: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

## API Documentation

### Teacher Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/teachers` | Create a new teacher |
| GET | `/api/teachers/{id}` | Get teacher by ID |
| GET | `/api/teachers` | Get all teachers |
| PUT | `/api/teachers/{id}` | Update teacher |
| DELETE | `/api/teachers/{id}` | Delete teacher |

### Student Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/students` | Create a new student |
| GET | `/api/students/{id}` | Get student by ID |
| GET | `/api/students` | Get all students |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

### Course Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/courses` | Create a new course |
| GET | `/api/courses/{id}` | Get course by ID |
| GET | `/api/courses` | Get all courses |
| PUT | `/api/courses/{id}` | Update course |
| DELETE | `/api/courses/{id}` | Delete course |

### Example Request/Response

**Create Teacher Request:**
```json
POST /api/teachers
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@school.edu"
}
```

**Response:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@school.edu",
  "courseIds": []
}
```

## Database Schema

### Tables

1. **students**
   - id (Primary Key)
   - first_name
   - last_name
   - email (Unique)

2. **teachers**
   - id (Primary Key)
   - first_name
   - last_name
   - email (Unique)

3. **courses**
   - id (Primary Key)
   - name
   - description
   - teacher_id (Foreign Key)

4. **enrollments**
   - id (Primary Key)
   - student_id (Foreign Key)
   - course_id (Foreign Key)
   - enrollment_date

5. **student_courses** (Join Table)
   - student_id (Foreign Key)
   - course_id (Foreign Key)

### Relationships

- **Teacher ↔ Course**: One-to-Many (One teacher can teach multiple courses)
- **Student ↔ Course**: Many-to-Many (Students can enroll in multiple courses)
- **Student ↔ Enrollment**: One-to-Many (Track enrollment history)
- **Course ↔ Enrollment**: One-to-Many (Track course enrollments)

## Development Guidelines

### Code Style
- Follow Java naming conventions
- Use meaningful variable and method names
- Add comprehensive JavaDoc documentation
- Implement proper error handling
- Write unit tests for business logic

### Adding New Features

1. **Create Entity** (if needed)
   - Add JPA annotations
   - Define relationships
   - Include validation constraints

2. **Create DTO**
   - Add validation annotations
   - Include only necessary fields

3. **Create Mapper**
   - Use MapStruct annotations
   - Handle complex mappings

4. **Create Repository**
   - Extend JpaRepository
   - Add custom query methods if needed

5. **Create Service**
   - Define interface
   - Implement business logic
   - Add error handling

6. **Create Controller**
   - Define REST endpoints
   - Add request/response handling
   - Include validation

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**Melvin Chibanda**
- Version: 1.0
- Year: 2024

## Support

For support and questions, please create an issue in the repository or contact the development team.