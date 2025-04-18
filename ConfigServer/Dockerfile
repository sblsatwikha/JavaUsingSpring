#BUILDING DOCKER IMAGES
#mvn clean install - to Build jar file

#Create docker file:
FROM openjdk:21

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} configserver.jar

ENTRYPOINT ["java", "-jar", "/configserver.jar"]

EXPOSE 9296

#build docker image
#docker build -t satwikhachilukuri/configserver:0.0.1 .
# ( . represents current directory, t represents tag, 0.0.1-version, serviceregistry-repository)
#(base) satwika@Satwikas-MacBook-Pro ~ % docker images
#REPOSITORY        TAG       IMAGE ID       CREATED          SIZE
#configserver      0.0.1     77ea29c4dc56   7 minutes ago    888MB
#cloudgateway      0.0.1     a6db1b24314b   12 minutes ago   885MB
#serviceregistry   0.0.1     1a103577db3a   41 minutes ago   899MB
#mysql             8.0       59cc3d706de7   2 months ago     1.04GB

#RUN DOCKER IMAGES
#docker run -d -p9296:9296 -e EUREKA_SERVER_ADDRESS=http://host.docker.internal:8761/eureka --name configserver 77ea29c4dc56
#24fa24ae018ebd0eddc866504508dd7cc8efc8ece38c58fd8124efe378ac542f
#docker ps
#CONTAINER ID   IMAGE          COMMAND                  CREATED          STATUS         PORTS                    NAMES
#24fa24ae018e   77ea29c4dc56   "java -jar /configse…"   6 seconds ago    Up 5 seconds   0.0.0.0:9296->9296/tcp   configserver
#87e0bfdc24df   1a103577db3a   "java -jar /servicer…"   28 minutes ago   Up 7 minutes   0.0.0.0:8761->8761/tcp   serviceregistry
