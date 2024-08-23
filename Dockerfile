# Use a base image with the Java runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file from the target directory to the container
COPY target/AdvanceLibraryManagementSystem-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
