FROM  openjdk:11-ea-jre

EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#docker build -t brainupgrade/github-copilot-demo:1.0 .