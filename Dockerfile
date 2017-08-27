FROM anapsix/alpine-java

EXPOSE 8090

ENV CONSUL_LOCATION consul

ADD ./target/weather-0.0.1-SNAPSHOT.jar  /weather.jar

ENTRYPOINT ["java", "-jar", "/weather.jar"]
