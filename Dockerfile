FROM openjdk:17-jdk
COPY target/mimo-*.jar app.jar
VOLUME /app/videos
VOLUME /app/thumbnails
ENTRYPOINT [ "java", "-jar","app.jar" ]