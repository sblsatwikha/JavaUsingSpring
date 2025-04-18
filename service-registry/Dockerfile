#BUILDING DOCKER IMAGES
#mvn clean install - to Build jar file

#Create docker file:
FROM openjdk:21

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} serviceregistry.jar

ENTRYPOINT ["java", "-jar", "/serviceregistry.jar"]

EXPOSE 8761

#build docker image
#docker build -t satwikhachilukuri/serviceregistry:0.0.1 .
# ( . represents current directory, t represents tag, 0.0.1-version, serviceregistry-repository)
#docker images
#REPOSITORY         TAG       IMAGE ID       CREATED         SIZE
#serviceregistry    0.0.1     1a103577db3a   3 minutes ago   899MB



#RUN DOCKER IMAGES
#docker run -d -p8761:8761 --name serviceregistry 1a103577db3a
#87e0bfdc24df8835a9eaaba574d71ce3e2d0f8adb4f94aeb9f744873f504260a
#ocker ps
#CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS                    NAMES
#87e0bfdc24df   1a103577db3a   "java -jar /servicer…"   4 seconds ago   Up 3 seconds   0.0.0.0:8761->8761/tcp   serviceregistry
