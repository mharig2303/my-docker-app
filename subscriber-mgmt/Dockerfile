FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} subscriber-mgmt-api.jar
ENTRYPOINT [ "java","-jar","subscriber-mgmt-api.jar" ]
EXPOSE 8090