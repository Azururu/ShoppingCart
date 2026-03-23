FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/ShoppingCart-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]