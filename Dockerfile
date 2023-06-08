# Use a base image with Alpine Linux and Java 17 installed
FROM adoptopenjdk:17-jdk-hotspot as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Copy the source code to the working directory
COPY src ./src

# Build the application using Maven
RUN ./mvnw package

# Create a new image with only the JAR file
FROM adoptopenjdk:17-jre-hotspot-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/sarmadTask-0.0.1-SNAPSHOT.jar .

# Set the entry point to run the application
CMD ["java", "-jar", "sarmadTask-0.0.1-SNAPSHOT.jar"]
