# BookLand
- A Simple implementation of an Online Library.
- You may find the swagger definition at http://localhost:8080/swagger-ui/index.html
- I have decided to use an in-memory database H2 with some starting data. http://localhost:8080/h2-console/
- Health can be checked at http://localhost:8080/actuator/health
- Metrics with http://localhost:8080/actuator/metrics
- Prometheus Compatible metrics at http://localhost:8080/actuator/prometheus

## TODO
- Throw errors for the client, not just return;
- Everything else