FROM maven:3-openjdk-17 AS maven_build
WORKDIR /transaction-understanding

COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -Dmaven.test.skip

ENTRYPOINT [ "mvn", "spring-boot:run" ]