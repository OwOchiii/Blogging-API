# Agent Guide

## Project snapshot
- Single-module Spring Boot app in the root package `orochi.blogging`.
- Current codebase is a starter skeleton: `src/main/java/orochi/blogging/BloggingApiApplication.java` boots the app, and `src/test/java/orochi/blogging/BloggingApiApplicationTests.java` only verifies the context loads.
- `src/main/resources/application.properties` currently sets `spring.application.name=Blogging API`.

## Read first
- `pom.xml` for the supported Java/Spring versions and dependencies.
- `HELP.md` for the only repo-local reference documentation.
- `src/main/java/orochi/blogging/BloggingApiApplication.java` and the matching test package for naming/layout.

## Architecture and conventions
- Keep new code under `orochi.blogging...` so component scanning stays aligned with `@SpringBootApplication`.
- Mirror production and test packages; the current convention is `src/main/java/orochi/blogging/...` with tests in `src/test/java/orochi/blogging/...`.
- Use Spring Boot annotations and standard package-based wiring; there are no controllers/services/repos/entities yet.
- Lombok is available, but only through Maven compiler annotation processing in `pom.xml`.
- PostgreSQL is included as a runtime dependency only, so DB features need explicit datasource/configuration work.

## Build and test workflow
- Use the Maven Wrapper, not a locally installed Maven.
- Windows: `.\mvnw.cmd test`, `.\mvnw.cmd package`, `.\mvnw.cmd spring-boot:run`.
- Unix/macOS equivalent: `./mvnw test`, `./mvnw package`, `./mvnw spring-boot:run`.
- The wrapper is pinned to Maven `3.9.15` in `.mvn/wrapper/maven-wrapper.properties`.

## Guardrails
- Keep Java at `17` and Spring Boot at `4.0.6` unless the change explicitly updates the build.
- Preserve the bootstrap/test naming pattern (`BloggingApiApplication`, `BloggingApiApplicationTests`) when adding related classes.
- `target/`, IDE folders, and the wrapper JAR are ignored in `.gitignore`; do not commit generated build output.
- If you add behavior, add or update tests alongside it; the current baseline test is `@SpringBootTest` with `contextLoads()`.


