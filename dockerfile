FROM openjdk:1.8
EXPOSE 8085
COPY  target/test-project-0.0.1-SNAPSHOT.jar test-project-0.0.1-SNAPSHOT.jar
CMD java -jar test-project-0.0.1-SNAPSHOT.jar
