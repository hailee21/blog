FROM openjdk:8
ADD build/libs/users-mysql.jar users-mysql.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "users-mysql.jar"]