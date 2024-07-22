FROM openjdk:17-jdk
COPY target/mimo-*.jar app.jar
COPY /home/ubuntu/video /video
COPY /home/ubuntu/thumbnail /thumbnail
ENTRYPOINT [ "java", "-jar","app.jar" ]