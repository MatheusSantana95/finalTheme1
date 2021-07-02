FROM openjdk:8
COPY build/libs/tema-1.jar /app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
