FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} Meter-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Meter-0.0.1-SNAPSHOT.jar"]

EXPOSE 8083