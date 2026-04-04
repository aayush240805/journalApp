#
# Build stage
#
FROM maven:3.8.6-amazoncorretto-8 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM amazoncorretto:8-al2-native-jre
WORKDIR /app
RUN adduser appuser
COPY --from=builder /app/target/*.jar app.jar
USER appuser
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", ...]