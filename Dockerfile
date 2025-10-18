FROM eclipse-temurin:21-jre-alpine
MAINTAINER lumium.co
COPY target/light-0.0.1.jar light-0.0.1.jar
ENTRYPOINT ["java","-jar","light-0.0.1.jar"]