#FROM alpine/java:21-jdk
#EXPOSE 8080
#ARG JAR_FILE=build/libs/api-task-management-0.0.1-SNAPSHOT.jar
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

# Start with a base image containing Java runtime
FROM alpine/java:21-jdk as builder
WORKDIR /app
COPY gradlew build.gradle ./
COPY gradle gradle

COPY src src
# Make the Gradle wrapper executable
RUN chmod +x ./gradlew
RUN ./gradlew build -x test
FROM alpine/java:21-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# Set environment variable
ENV SPRING_DATA_MONGODB_URI=mongodb://mongodb:27017/taskmanagement
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]