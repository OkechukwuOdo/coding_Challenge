FROM maven:3.8.5-openjdk-17 As build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Coding_Challenge-0.0.1-SNAPSHOT.jar Coding_Challenge.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","Coding_Challenge.jar"]