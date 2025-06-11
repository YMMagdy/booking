# ---------- STAGE 1: Build ----------
FROM gradle:8.5-jdk21-alpine AS builder

# Set working directory
WORKDIR /app

# Copy Gradle project files
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src ./src

COPY application.properties application.properties

RUN chmod +x ./gradlew

# Run Gradle build
RUN ./gradlew build --no-daemon

# ---------- STAGE 2: Run ----------
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port your Spring Boot app listens on
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
