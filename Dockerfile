 FROM maven:3.6.0-jdk-11-slim AS build
 COPY src /home/app/src
 COPY pom.xml /home/app
 RUN mvn -f /home/app/pom.xml clean package

FROM andreptb/tomcat

# Delete existing ROOT folder
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy to images tomcat path
COPY ./target/TcsMail_v2-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

