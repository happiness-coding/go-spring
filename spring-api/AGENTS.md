# Repository Guidelines

## Project Structure & Module Organization
- Maven multi-module root (`pom.xml`) targeting Java 17.
- `spring-domain`: core models and value objects. `spring-infrastructure`: shared persistence/config utilities. `spring-command-api`: write-side controllers, DTOs, and command handlers. `spring-query-api`: read-side service with JPA/Redis (`BlogQueryApplication`). `spring-api-gateway`: edge routing/security (`BlogGatewayApplication`). `spring-migration`: Flyway migrations placeholder. Contract in `spring-api-spec.yaml`; reference schema in `database-schema.sql`.
- Tests live beside code (`spring-command-api/src/test/java`, `spring-query-api/src/test/java`).

## Build, Test, and Development Commands
- Ensure Java 17 and Maven are available.
- `mvn clean verify`: build all modules, run unit tests, generate JaCoCo reports.
- `mvn -pl spring-query-api -am spring-boot:run` and `mvn -pl spring-api-gateway -am spring-boot:run`: start individual services after building dependencies.
- `mvn -pl spring-command-api test` (or `spring-query-api test`): module-scoped tests. `mvn -DskipTests package`: faster packaging when tests are already green.

## Coding Style & Naming Conventions
- 4-space indentation; organize imports. Prefer Lombok (`@Getter`, `@Builder`) and MapStruct for DTO/domain mapping.
- Package path `com.nvbinhsoft.blog.<module>`; controllers end with `Controller`, handlers with `Handler`, DTOs with `Request`/`Response`, commands with `Command`.
- REST paths use kebab-case slugs (e.g., `/articles/{slug}`); align with `spring-api-spec.yaml` routes and status codes. Keep configs in `src/main/resources/application*.yml`; never commit secrets.

## Testing Guidelines
- JUnit 5 + Spring Boot test utilities; web layers rely on `@WebMvcTest` and `MockMvc`. Add integration tests with Testcontainers when touching persistence/Redis.
- Name test classes `*Test` and methods `should...`/`test...`; mirror main package structure under `src/test/java`.
- After `mvn verify`, review coverage at `target/site/jacoco/index.html`; add missing cases for controllers, handlers, and mappers.

## Commit & Pull Request Guidelines
- Use present-tense, imperative summaries (e.g., `Add article update flow`); keep commits scoped to a single concern.
- PRs: describe motivation, modules touched, new config/env vars, and how to run/verify (`mvn verify` command). Attach screenshots or OpenAPI diffs when altering endpoints.
- Link issues, call out breaking changes, and ensure branch builds stay green before requesting review.
