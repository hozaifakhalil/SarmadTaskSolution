# Use a base image with Alpine Linux and Java 17 installed
FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Copy the source code to the working directory
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Create a new image with only the JAR file
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/sarmadTask-0.0.1-SNAPSHOT.jar .

# Set the entry point to run the application
CMD ["java", "-jar", "sarmadTask-0.0.1-SNAPSHOT.jar"]
