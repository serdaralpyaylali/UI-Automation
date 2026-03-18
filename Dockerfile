FROM maven:3.9.11-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

COPY src ./src
COPY testng.xml ./testng.xml

CMD ["mvn", "clean", "test", "-Dsurefire.suiteXmlFiles=testng.xml"]