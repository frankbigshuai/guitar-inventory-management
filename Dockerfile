FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/demo-0.0.1-SNAPSHOT.jar hw6.jar
ENTRYPOINT ["java", "-jar", "hw6.jar"]