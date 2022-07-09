FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
#ARG JAR_FILE=target/employees-0.0.1-SNAPSHOT.jar
COPY target/employees-0.0.1-SNAPSHOT.jar employee-be.jar
ENTRYPOINT ["java","-jar","employee-be.jar"]