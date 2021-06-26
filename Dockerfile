 FROM maven:3.6.0-jdk-11-slim AS build
 COPY src /home/app/src
 COPY pom.xml /home/app
 RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
# FROM openjdk:11-jre-slim
#COPY --from=build ./target/TcsMail_v2-0.0.1-SNAPSHOT.jar /usr/app

#ENTRYPOINT ["java","-jar","/usr/local/lib/TcsMail_v2.jar"]


FROM andreptb/tomcat

# Delete existing ROOT folder
RUN rm -rf /usr/local/tomcat/webapps/ROOT
#EXPOSE 8080
# Copy to images tomcat path
COPY ./target/*.war /usr/local/tomcat/webapps/ROOT.war


