# Use the official OpenJDK image as a base image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/spring-boot-minikube-1.0.12.jar /app/spring-boot-minikube.jar

# Specify the command to run your application
CMD ["java", "-jar", "spring-boot-minikube.jar"]