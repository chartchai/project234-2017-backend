FROM openjdk:8-jdk-alpine
RUN mkdir /data
VOLUME /data
COPY ./target/project.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar","--imageServer=http://localhost:8081/images/"]