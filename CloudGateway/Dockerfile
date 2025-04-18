#BUILDING DOCKER IMAGES
#mvn clean install - to Build jar file

#Create docker file:
FROM openjdk:21

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} cloudgateway.jar

ENTRYPOINT ["java", "-jar", "/cloudgateway.jar"]

EXPOSE 9090

#build docker image
#docker build -t satwikhachilukuri/cloudgateway:0.0.1 .
# ( . represents current directory, t represents tag, 0.0.1-version, serviceregistry-repository)
#docker images
#REPOSITORY        TAG       IMAGE ID       CREATED          SIZE
#cloudgateway      0.0.1     e2d419e6c01f   29 seconds ago   885MB
#configserver      0.0.1     d9b74f6701dd   4 minutes ago    888MB
#serviceregistry   0.0.1     1a103577db3a   59 minutes ago   899MB
#mysql             8.0       59cc3d706de7   2 months ago     1.04GB


#RUN DOCKER IMAGES
#docker run -d -p9090:9090 -e CONFIG_SERVER_URL=host.docker.internal -e EUREKA_SERVER_ADDRESS=http://host.docker.internal:8761/eureka --name  cloudgateway e2d419e6c01f
#9d9bd90e9b5f3f721e641e6cc03bb029b29805d66ca1cfcfd85ba0737bbd2ef5
#docker ps
#CONTAINER ID   IMAGE          COMMAND                  CREATED          STATUS          PORTS                    NAMES
#9d9bd90e9b5f   e2d419e6c01f   "java -jar /cloudgat…"   53 seconds ago   Up 52 seconds   0.0.0.0:9090->9090/tcp   cloudgateway
#e7c361334fc4   d9b74f6701dd   "java -jar /configse…"   9 minutes ago    Up 9 minutes    0.0.0.0:9296->9296/tcp   configserver
#87e0bfdc24df   1a103577db3a   "java -jar /servicer…"   48 minutes ago   Up 27 minutes   0.0.0.0:8761->8761/tcp   serviceregistry

#PUSH
#docker push satwikhachilukuri/cloudgateway:0.0.1   