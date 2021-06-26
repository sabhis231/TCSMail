# FROM maven:3.6.0-jdk-11-slim AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
# FROM openjdk:11-jre-slim
#COPY --from=build ./target/TcsMail_v2-0.0.1-SNAPSHOT.jar /usr/app
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/TcsMail_v2.jar"]


FROM openjdk:8-jre-alpine
# copy application WAR (with libraries inside)
COPY target/TcsMail_v2-0.0.1-SNAPSHOT.war /TcsMail_v2-0.0.1-SNAPSHOT.war
# specify default command
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.war"]
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/TcsMail_v2-0.0.1-SNAPSHOT.war"]
#ENTRYPOINT ["java","-jar","/usr/local/lib/TcsMail_v2.war"]
