FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/IntervjuPiO-0.0.1-SNAPSHOT.jar IntervjuPiO.jar
ENTRYPOINT ["java","-jar","/IntervjuPiO.jar"]
EXPOSE 8080