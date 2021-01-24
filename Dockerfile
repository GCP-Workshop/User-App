FROM azul/zulu-openjdk-alpine:11.0.5
WORKDIR /demo

COPY build/libs/demo-0.0.1-SNAPSHOT.jar /demo/
EXPOSE 8080
CMD ["java","-jar","/demo/demo-0.0.1-SNAPSHOT.jar"]