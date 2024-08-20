# 1. Builder
FROM eclipse-temurin:21 as builder

WORKDIR /app
ADD . /app

RUN ./gradlew build


# 2. Spring Container
FROM eclipse-temurin:21

EXPOSE 8080

COPY --from=builder /app/build/libs/order-0.0.1-SNAPSHOT.jar /app/order.jar

ENTRYPOINT ["java", "-jar", "/app/order.jar"]