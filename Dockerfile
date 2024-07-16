FROM openjdk:17-jdk
COPY target/mimo-*.jar app.jar
ENTRYPOINT [ "java", "-jar","app.jar" ]