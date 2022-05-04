FROM openjdk:11-jdk
ADD target/ee-employee-portal-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]


