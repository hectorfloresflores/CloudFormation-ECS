FROM openjdk:8
ADD target/java-docker.jar java-docker.jar

CMD ["java", "-jar", "java-docker.jar", "--server.port=${PORT:8080}"]