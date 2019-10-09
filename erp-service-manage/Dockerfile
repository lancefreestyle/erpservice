FROM java:8
COPY ./target/cpm-basic-erp-service.jar /app.jar
COPY ./cpm-logback-config.xml /
RUN bash -c 'touch /app.jar'
EXPOSE 10100
ENTRYPOINT ["java","-Dspring.profiles.active=${profile}","-Dlogging.config=/cpm-logback-config.xml","-Deureka.client.service-url.defaultZone=${eureka}","-Dspring.zipkin.base-url=${zipkin}","-jar","/app.jar"]