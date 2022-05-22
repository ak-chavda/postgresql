#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dskiptests=true

#
# Package stage
#
FROM openjdk:8-jdk-alpine
RUN CREATE DATABASE "postgrestest"
COPY --from=build /home/app/target/springboot-postgresql-jpa-hibernate-crud.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]