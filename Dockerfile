FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder


WORKDIR /app


COPY . .


RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine


RUN adduser -h /home/gs -s /bin/sh -D gs


WORKDIR /home/gs


COPY --from=builder /app/target/*.jar app.jar


RUN chown gs:gs app.jar


USER gs


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]