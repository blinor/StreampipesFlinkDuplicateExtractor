FROM anapsix/alpine-java

EXPOSE 8086
ENV CONSUL_LOCATION consul

ADD ./target/weather-0.0.1-SNAPSHOT.jar  /dextractor.jar

ENTRYPOINT ["java", "-jar", "/dextractor.jar"]
