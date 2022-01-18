# Sample REST API with Postgres DB

- Interacting with Postgres DB using Spring JPA.
- Unit Testing with mocking and assertions.
- Integration test with Testcontainers and RestAssured.

## Start Docker

- Start docker using `docker-compose up`. This will start the PostgreSQL docker and pgAdmin4 docker.
- pgAdmin4 will be available at `http://localhost:5050/`.

## Observability

- Health check `curl --location --request GET 'localhost:4004/actuator/health'`
- Discovery endpoint `curl --location --request GET 'localhost:4004/actuator/'`
- Prometheus endpoint `curl --location --request GET 'localhost:4004/actuator/prometheus'`
- Metrics endpoint `curl --location --request GET 'http://localhost:4004/actuator/metrics'`
- Readiness probe endpoint `curl --location --request GET 'localhost:4004/actuator/health/readiness'`

