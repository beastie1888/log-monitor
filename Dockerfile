# Stage 1: Build the application using Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the pom.xml and download dependencies (layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the app with a smaller JDK image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the packaged jar from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port (adjust if your app runs on a different one)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]