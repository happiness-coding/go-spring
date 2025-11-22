# Personal Blog API

Spring Boot 3.2 multi-module project for nvbinhsoft's blog platform. The codebase follows a CQRS split (write-side command API, read-side query API) with a gateway front door and shared domain/infrastructure libraries. Java 17 and Maven are required.

## Modules
- `spring-domain`: core aggregates, value objects, domain events, and repository contracts.
- `spring-infrastructure`: shared config/security helpers (JWT, async, web) and cache abstractions.
- `spring-command-api`: write-side controllers and handlers that accept commands for articles, categories, tags, users, comments, and subscribers.
- `spring-query-api`: read-side service exposing cached/JPA-backed projections and view models.
- `spring-api-gateway`: edge service for routing and JWT-based security (Keycloak-friendly).
- `spring-migration`: Flyway placeholder for future database migrations.
- `spring-api-spec.yaml`: OpenAPI contract; `database-schema.sql` holds a reference schema.

## Prerequisites
- Java 17+ and Maven 3.9+.
- Datastores: default query profile points to MySQL (`jdbc:mysql://localhost:3306/query_db`), while the reference schema uses PostgreSQL syntax—align these with your actual database.
- Optional infra: Keycloak (JWT issuer at `http://localhost:8080/realms/blog`) and Eureka (`http://localhost:8761/eureka/`) as configured in `application.yml`.

## Build & Test
- Full build and tests: `mvn clean verify`
- Module-scoped tests: `mvn -pl spring-command-api test` or `mvn -pl spring-query-api test`
- Faster packaging when tests are green: `mvn -DskipTests package`
- Coverage report after `mvn verify`: `target/site/jacoco/index.html`

## Code Style (Spotless)
- Enforced during the Maven lifecycle via `spotless:check` (runs with `mvn verify`); run `mvn spotless:apply` to auto-fix.
- Java: Google Java Format 1.17.0 + annotation reflow + unused import removal across modules.
- POM files: normalized with Spotless `sortPom`.
- Tip: run Spotless before committing to keep CI green.

## Run Services (local)
- Query API (port 8081 by default): `mvn -pl spring-query-api -am spring-boot:run`
- Gateway (port 8080 by default): `mvn -pl spring-api-gateway -am spring-boot:run`
- Command API uses the same pattern once its application entrypoint is wired: `mvn -pl spring-command-api -am spring-boot:run`

Update `application.yml`/`application-*.yml` files in each module for DB credentials, cache, and security settings before starting services.

## Testing Guidelines
- JUnit 5 with Spring Boot test utilities; web layers prefer `@WebMvcTest` and `MockMvc`.
- Tests sit beside code (e.g., `spring-command-api/src/test/java`); name classes `*Test` and methods `should...`/`test...`.
- Add integration tests with Testcontainers when touching persistence/Redis layers.

## Project Structure
- Overview: `backend-structure.md`
- Domain and API contract: `spring-api-spec.yaml`
- Database reference: `database-schema.sql`
