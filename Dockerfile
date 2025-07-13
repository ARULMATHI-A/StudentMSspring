# Use base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR into container
COPY target/student-management-0.0.1-SNAPSHOT.war app.war
COPY src/main/webapp /app/src/main/webapp

# Expose port (same as Spring Boot port)
EXPOSE 8093

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.war"]


