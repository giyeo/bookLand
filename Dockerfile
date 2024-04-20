FROM eclipse-temurin:21.0.2_13-jre-alpine

WORKDIR /home/

COPY target/bookland-1.0.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/bookland-1.0.jar"]
