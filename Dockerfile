FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY target/fiapBurgerPedido-0.0.1-SNAPSHOT.jar .

EXPOSE 8989

CMD ["java", "-jar", "fiapBurgerPedido-0.0.1-SNAPSHOT.jar"]
