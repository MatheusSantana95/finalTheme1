FROM openjdk:8
COPY build/libs/tema-1.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
