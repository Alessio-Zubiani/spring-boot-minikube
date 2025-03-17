# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/spring-boot-minikube-${project.version}.jar /app/spring-boot-minikube.jar

# Specify the command to run your application
CMD ["java", "-jar", "spring-boot-minikube.jar"]