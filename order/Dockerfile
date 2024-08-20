# 1. Builder
FROM eclipse-temurin:21 AS builder

WORKDIR /app
ADD . /app

RUN ./gradlew build


# 2. Spring Container
FROM eclipse-temurin:21

# Install Dockerize
ENV DOCKERIZE_VERSION v0.7.0
RUN apt-get update \
    && apt-get install -y wget \
    && wget -O - https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz | tar xzf - -C /usr/local/bin \
    && apt-get autoremove -yqq --purge wget && rm -rf /var/lib/apt/lists/*

EXPOSE 8060

COPY --from=builder /app/build/libs/order-0.0.1-SNAPSHOT.jar /app/order.jar

#ENTRYPOINT ["java", "-jar", "/app/order.jar"]