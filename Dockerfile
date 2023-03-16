FROM openjdk:8
ADD target/HelloWorld-0.1.jar  /app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
