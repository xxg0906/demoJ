FROM adoptopenjdk:8-jdk-openj9
#FROM openjdk:8-jdk-alpine
#FROM adoptopenjdk:8-jdk-hotspot

ARG JAR_FILE

COPY /target/service-b-0.1.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
