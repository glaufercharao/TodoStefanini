FROM openjdk:21 as builder

WORKDIR /app

COPY ./pom.xml /app
COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:21

WORKDIR /app

RUN mkdir ./logs

ARG TARGET_FOLDER=/app/target
COPY --from=builder $TARGET_FOLDER/TodoStefanini-0.0.1-SNAPSHOT.jar .
ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT
#CMD sleep 20 && java -jar TodoStefanini-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "TodoStefanini-0.0.1-SNAPSHOT.jar"]