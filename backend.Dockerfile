FROM openjdk:17 AS backend-server
COPY /app/backend /app
EXPOSE 8080

CMD ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]