FROM openjdk:17-alpine
COPY target/demo1-0.0.1-SNAPSHOT.jar demo1-test.jar

ENTRYPOINT ["java", "-jar", "demo1-test.jar"]