# Use the official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY src ./src  
RUN mvn package -Dmaven.test.skip=true 

# Use a slim JDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/*.jar ./myapp.jar  

# Expose the application port
EXPOSE 8080

# Define the entrypoint command to run the application
ENTRYPOINT ["java", "-jar", "./myapp.jar"]
