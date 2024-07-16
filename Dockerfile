FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY target/pedido-0.0.1-SNAPSHOT.jar .

EXPOSE 8989

CMD ["java", "-jar", "pedido-0.0.1-SNAPSHOT.jar"]
