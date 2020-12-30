FROM openjdk:11-jre-slim

RUN mkdir /app

COPY build/libs/*.jar /app/producer-event-sample.jar

ENTRYPOINT ["java", "-jar", "/app/producer-event-sample.jar"]
