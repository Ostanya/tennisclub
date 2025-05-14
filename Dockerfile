# Use a base image with Java
# Use OpenJDK 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file (after you've built it with Maven or Gradle)
COPY target/tennisclub.jar app.jar

# Expose the app port (optional, for clarity)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

