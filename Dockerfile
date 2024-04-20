# Build Stage
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the project files
COPY . .

# Download dependencies and build application
RUN mvn -B dependency:go-offline
RUN mvn -B clean package

# Final Stage
FROM eclipse-temurin:21-jre

WORKDIR /home/

# Copy the compiled application from the build stage
COPY --from=build /app/target/bookland-1.0.jar /home/bookland-1.0.jar

# Expose port 8080
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/home/bookland-1.0.jar"]
