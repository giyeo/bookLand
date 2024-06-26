# BookLand
- A Simple implementation of an Online Library.

# Setup
- Just "docker-compose up --build" (it can take a while due required dependencies, have a coffee ☕)

# Implementation Choices
- I've decided to proceed with a simple MVC implementation, that easy to code, test and run in any machine with no worries.
- An in-memory database H2 was the main choice because of its simplicity (resources/data.sql setup test environment automatically)
- Swagger-UI make it easy to find and test API endpoints, path can be found bellow.
- For Metrics, good old Spring Actuator with Prometheus and Grafana for high level analysis.
- Multiple containers with docker-compose in order to make it pretty
- Junit for some standard testing, Mockito is nice, but the H2 in-memory database get rid of the mocks
- Unit Tests for the code that run the business logic
- My @Entity classes are my schema, yes, that is my excuse.

- Swagger http://localhost:8080/swagger-ui/index.html
- H2 Console http://localhost:8080/h2-console/
- Actuator http://localhost:8080/actuator/
- Prometheus http://localhost:9090/
- Grafana http://localhost:3000/

# Grafana
- When entering grafana the first time, use "admin" as username and password, then, setup a new secret.
- Click in the "Add" button in the top right corner, then, "Visualization".
- In the Bottom right corner, you will notice a "Metric" drop down, select something cool, like "CPU" something.

## Things that dreamed with
- Throw errors for the client, not just "return" the functions, does not matter what, is a 200 OK, that no good. 
- Create more endpoints
- Create more tests (end-to-end, controller testing)
- Java 21, to be honest, I could not find an exclusive feature that helped my with this MVP.
- Migrations, I just forgot about this one 〜(￣▽￣〜), (any way, I would mess up in this one)
- Everything else