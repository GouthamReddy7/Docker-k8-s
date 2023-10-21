FROM openjdk:11 as build

EXPOSE 8080
ADD target/kaibur-0.0.1-SNAPSHOT.jar kaibur-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "kaibur-0.0.1-SNAPSHOT.jar" ]