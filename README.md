# Go-Spring Project

A comprehensive Java Spring Boot application with Angular frontend for managing happiness and productivity.

## Table of Contents

- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
  - [Backend Architecture](#backend-architecture)
  - [Frontend Architecture](#frontend-architecture)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Development Guidelines](#development-guidelines)
- [Project Structure](#project-structure)
  - [Backend Structure](#backend-structure)
  - [Frontend Structure](#frontend-structure)
- [API Documentation](#api-documentation)
- [Contribution Guidelines](#contribution-guidelines)

## Project Overview

Go-Spring is a Java-based application designed to provide a robust platform using Spring Boot backend and Angular frontend. The project implements a clean architecture with separation of concerns between the backend and frontend.

### Business Logic

The application handles various business domains including:
- User management and authentication
- Data processing and persistence
- RESTful API services
- Cross-domain integration

## Technology Stack

### Backend
- Java 17
- Spring Boot 3.x
- Spring Security for authentication and authorization
- Spring Data JPA for data persistence
- Hibernate as ORM
- MySQL/PostgreSQL database
- Maven for dependency management

### Frontend
- Angular 15+
- TypeScript
- SCSS for styling
- NgRx for state management
- Angular Material UI components
- RxJS for reactive programming

## Architecture

### Backend Architecture

The backend follows a layered architecture pattern with clear separation of concerns:

1. **Controller Layer** - Handles HTTP requests and responses
2. **Service Layer** - Contains business logic
3. **Repository Layer** - Manages data access
4. **Domain Layer** - Defines the business entities and value objects

The application is structured around DDD (Domain-Driven Design) principles, organizing code by business domains rather than technical concerns.

### Frontend Architecture

The frontend follows Angular's component-based architecture:

1. **Modules** - Feature-based organization
2. **Components** - UI elements with their own logic
3. **Services** - Handles data fetching and business logic
4. **Store** - NgRx state management
5. **Models** - TypeScript interfaces for type safety

## Getting Started

### Prerequisites

- JDK 17 or higher
- Node.js 14.x or higher
- npm 6.x or higher
- Maven 3.6.x or higher
- MySQL/PostgreSQL instance

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/happiness-coding/go-spring.git
   cd go-spring
   ```

2. Configure database connection in `src/main/resources/application.properties` or `application.yml`

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the JAR file:
   ```bash
   java -jar target/go-spring-0.0.1-SNAPSHOT.jar
   ```

5. The backend server will be available at `http://localhost:8080`

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Run the development server:
   ```bash
   ng serve
   ```

4. The frontend will be available at `http://localhost:4200`

## Development Guidelines

### Backend Best Practices

1. **Follow Clean Code principles**
   - Write meaningful variable and method names
   - Keep methods small and focused on a single responsibility
   - Use proper exception handling

2. **Use DTOs for API contracts**
   - Separate domain models from API contracts
   - Use mappers to convert between DTOs and domain models

3. **Write comprehensive unit and integration tests**
   - Aim for high test coverage for service and repository layers
   - Use JUnit 5 and Mockito for testing

4. **Document APIs properly**
   - Use Swagger/OpenAPI for API documentation
   - Include examples and response types

5. **Properly handle transactions**
   - Use @Transactional annotation appropriately
   - Consider isolation levels for concurrent operations

### Frontend Best Practices

1. **Component Organization**
   - Follow the smart/dumb component pattern
   - Keep components small and focused

2. **State Management**
   - Use NgRx for complex state management
   - Follow the Redux pattern (actions, reducers, selectors, effects)

3. **Styling Guidelines**
   - Use SCSS for styling
   - Follow BEM methodology for CSS naming
   - Use Angular Material theming system

4. **Performance Optimization**
   - Implement lazy loading for modules
   - Use OnPush change detection strategy
   - Optimize bundle size

5. **Testing**
   - Write unit tests for services and components
   - Use Jest or Jasmine for testing
   - Write E2E tests with Cypress

## Project Structure

### Backend Structure

```
src/main/java/com/happiness/coding/
├── config/             # Configuration classes
├── controller/         # REST controllers
├── dto/                # Data Transfer Objects
├── exception/          # Custom exceptions and global exception handler
├── mapper/             # Object mappers (DTO <-> Entity)
├── model/              # Domain models/entities
├── repository/         # Data access layer
├── security/           # Security configuration and components
├── service/            # Business logic
│   ├── impl/           # Service implementations
│   └── interfaces/     # Service interfaces
├── util/               # Utility classes
└── GoSpringApplication.java  # Main application class
```

### Frontend Structure

```
frontend/
├── src/
│   ├── app/
│   │   ├── core/              # Core functionality (guards, interceptors)
│   │   │   ├── auth/          # Authentication services
│   │   │   ├── guards/        # Route guards
│   │   │   ├── interceptors/  # HTTP interceptors
│   │   │   └── services/      # Core services
│   │   ├── features/          # Feature modules
│   │   │   ├── feature1/      # Specific feature module
│   │   │   └── feature2/      # Another feature module
│   │   ├── shared/            # Shared components, directives, and pipes
│   │   │   ├── components/    # Reusable components
│   │   │   ├── directives/    # Custom directives
│   │   │   ├── models/        # Shared interfaces and models
│   │   │   ├── pipes/         # Custom pipes
│   │   │   └── utils/         # Utility functions
│   │   ├── store/             # NgRx store
│   │   │   ├── actions/       # Store actions
│   │   │   ├── effects/       # Store effects
│   │   │   ├── reducers/      # Store reducers
│   │   │   └── selectors/     # Store selectors
│   │   ├── app-routing.module.ts
│   │   └── app.module.ts
│   ├── assets/                # Static assets
│   ├── environments/          # Environment configuration
│   ├── styles/                # Global styles
│   ├── index.html
│   └── main.ts
├── angular.json
├── package.json
└── tsconfig.json
```

## API Documentation

The API documentation is available at `http://localhost:8080/swagger-ui.html` when the backend server is running.

## Contribution Guidelines

1. **Branch Naming Convention**
   - Feature branches: `feature/description-of-feature`
   - Bug fixes: `fix/description-of-fix`
   - Releases: `release/version-number`

2. **Commit Messages**
   - Follow conventional commits format: `type(scope): description`
   - E.g., `feat(auth): implement JWT authentication`

3. **Pull Request Process**
   - Create a PR against the main branch
   - Ensure all tests pass
   - Get at least one code review
   - Update documentation if necessary

4. **Code Review Checklist**
   - Code follows project style guidelines
   - Appropriate test coverage
   - No security vulnerabilities
   - Performance considerations addressed

---

© 2025 Happiness Coding Team
