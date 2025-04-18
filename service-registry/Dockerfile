#BUILDING DOCKER IMAGES
#mvn clean install - to Build jar file

#Create docker file:
FROM openjdk:21

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} serviceregistry.jar

ENTRYPOINT ["java", "-jar", "/serviceregistry.jar"]

EXPOSE 8761

#build docker image
#docker build -t serviceregistry:0.0.1 .
# ( . represents current directory, t represents tag, 0.0.1-version, serviceregistry-repository)
#(base) satwika@Satwikas-MacBook-Pro ~ % docker images
#REPOSITORY         TAG       IMAGE ID       CREATED         SIZE
#serviceregistry    0.0.1     1a103577db3a   3 minutes ago   899MB
