FROM maven:3-openjdk-17
WORKDIR /transaction-understanding
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run