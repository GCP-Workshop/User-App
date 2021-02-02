FROM azul/zulu-openjdk-alpine:11.0.5 AS intermediate
COPY src /demo/src
COPY gradle /demo/gradle
COPY gradlew build.gradle settings.gradle /demo/
RUN ls /demo
RUN cd /demo && ./gradlew build
RUN ls /demo/build/libs

FROM azul/zulu-openjdk-alpine:11.0.5
WORKDIR /app
COPY --from=intermediate /demo/build/libs/demo-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]