FROM openjdk:17-jdk-slim-buster

WORKDIR /app
COPY ./target/mvcThJpa-0.0.2.jar /app

EXPOSE 8083

CMD ["java", "-jar", "mvcThJpa-0.0.2.jar"]