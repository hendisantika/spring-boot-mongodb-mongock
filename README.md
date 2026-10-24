# Spring Boot with MongoDB and Mongock

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-mongodb-mongock/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-mongodb-mongock/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-8.0-47A248?logo=mongodb)

A simple Expense Tracker REST API built with Spring Boot and MongoDB. It uses [Mongock](https://www.mongock.io/) to run
database migrations (seed data) at startup.

### Tech Stack

| Component        | Version                                    |
|------------------|--------------------------------------------|
| Java             | 25 (Temurin)                               |
| Spring Boot      | 4.1.1                                      |
| Mongock          | 4.3.8 (`mongock-spring-v5`, Spring Data driver) |
| springdoc-openapi| 3.1.1                                      |
| Testcontainers   | 2.0.5                                      |
| MongoDB          | 8.0.4 (Docker Compose / Testcontainers)    |

### Prerequisites

- JDK 25
- Docker (used by Spring Boot Docker Compose support and by Testcontainers in tests)
- Maven 3.9+ (or use the bundled Maven Wrapper `./mvnw`)

### Things to do list:

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-mongodb-mongock.git`
2. Go to the folder: `cd spring-boot-mongodb-mongock`
3. Run the application: `./mvnw clean spring-boot:run` (MongoDB is started automatically from `compose.yaml`)
4. Open your favorite browser: http://localhost:8080/api/expenses
5. Swagger UI: http://localhost:8080/swagger-ui
6. Import POSTMAN Collection: `Expenses Application API.postman_collection.json`
7. Check the console logs
8. Enjoy the result!

### API Endpoints

| Method   | Endpoint               | Description             |
|----------|------------------------|-------------------------|
| `GET`    | `/api/expenses`        | Get all expenses        |
| `GET`    | `/api/expenses/{name}` | Get an expense by name  |
| `POST`   | `/api/expenses`        | Create a new expense    |
| `PUT`    | `/api/expenses`        | Update an expense       |
| `DELETE` | `/api/expenses/{id}`   | Delete an expense by id |

### Configuration

Spring Boot 4 uses the `spring.mongodb.*` prefix (previously `spring.data.mongodb.*`):

```properties
spring.mongodb.uri=mongodb://localhost:27017/expense-tracker
mongock.change-logs-scan-package=id.my.hendisantika.mongock.config
```

### Running Tests

Integration tests start a real MongoDB using Testcontainers, so Docker must be running:

```shell
./mvnw clean verify
```

### CI/CD & Dependency Updates

- **GitHub Actions** (`.github/workflows/maven.yml`) builds and tests the project on JDK 25 for every push and pull
  request to `main`; Testcontainers runs on the runner's Docker engine.
- **Dependabot** (`.github/dependabot.yml`) keeps Maven dependencies, GitHub Actions and Docker Compose images up to
  date, with grouped PRs (Spring Boot, springdoc, Mongock, Testcontainers, Maven plugins, minor/patch) and conventional
  commit prefixes.

### Console Logs

```shell
2025-01-07T10:47:49.702+07:00  INFO 44992 --- [spring-boot-mongock-demo] [127.0.0.1:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=127.0.0.1:27017, type=STANDALONE, cryptd=false, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=25, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=8522958, minRoundTripTimeNanos=0}
2025-01-07T10:47:49.754+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2025-01-07T10:47:50.050+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-01-07T10:47:50.054+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] i.m.h.m.SpringBootMongockDemoApplication : Started SpringBootMongockDemoApplication in 3.307 seconds (process running for 3.604)
2025-01-07T10:47:50.087+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.r.c.executor.MigrationExecutor   : Mongock skipping the data migration. All change set items are already executed or there is no change set item.
2025-01-07T10:47:50.087+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.d.core.lock.DefaultLockManager   : Mongock releasing the lock
2025-01-07T10:47:50.094+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.d.core.lock.DefaultLockManager   : Mongock released the lock
2025-01-07T10:47:50.094+07:00  INFO 44992 --- [spring-boot-mongock-demo] [  restartedMain] c.g.c.m.r.c.executor.MigrationExecutor   : Mongock has finished

```
