#Use Java 8 for the project
FROM openjdk:jdk-alpine
#Create a new app directory
RUN mkdir /deployments
#Copy the app file from host machine to image file system
COPY target/demoUnitTest-0.0.1-SNAPSHOT.jar /deployments
#Set the directory to excute future commands
WORKDIR /deployments
#Run the Main Class
CMD java -jar demoUnitTest-0.0.1-SNAPSHOT.jar