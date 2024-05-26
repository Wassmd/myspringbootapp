# Start with a base image containing Java runtime
FROM eclipse-temurin:21

# Add Maintainer Info
LABEL authors="wassmd@gmail.com"

COPY build/libs/myspringboot.jar opt/paxier/app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar","opt/paxier/app.jar"]



