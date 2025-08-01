# Step 1: Use an official OpenJDK base image for the build stage
FROM openjdk:17-jdk-slim as build

# Install Maven in the build stage
RUN apt-get update && apt-get install -y maven

# Step 2: Set the working directory inside the container to where the pom.xml is located
WORKDIR /app

# Step 3: Copy the pom.xml and source code into the container
# Copy pom.xml first to leverage Docker cache for dependencies
COPY pom.xml ./pom.xml
COPY src ./src

# Step 4: Run Maven to build the project (without running tests)
# Enable annotation processing by adding the necessary arguments to the Maven command
RUN mvn clean install -DskipTests -f ./pom.xml

# Step 5: Use another OpenJDK image for the runtime environment (final image)
FROM openjdk:17-jdk-slim

# Set the working directory in the final container
WORKDIR /app

# Copy the built (repackaged) JAR file from the previous stage to the final container
COPY --from=build /app/target/mfd.jar /app/mfd.jar

# Expose the port the application will run on (default for Spring Boot is 8080)
EXPOSE 8080

# Step 6: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "mfd.jar"]
