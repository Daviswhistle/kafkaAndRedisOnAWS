FROM openjdk:21
VOLUME /tmp
COPY build/libs/test-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--DB_HOST=postgres-lb"]