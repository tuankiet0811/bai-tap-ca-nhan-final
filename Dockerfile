FROM maven:3.9.11-eclipse-temurin-25 AS builder
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:25-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENV SERVER_PORT=80
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]