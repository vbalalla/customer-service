FROM amazoncorretto:23
WORKDIR /app
COPY target/customer-service-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]