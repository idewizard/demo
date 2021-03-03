FROM openjdk:15
WORKDIR /app_gaia
COPY target/gaia-0.0.1-SNAPSHOT.jar /app/app-gaia.jar
ENTRYPOINT ["java", "-jar", "app-gaia.jar"]