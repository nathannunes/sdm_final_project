FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/sdm_final_project.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]