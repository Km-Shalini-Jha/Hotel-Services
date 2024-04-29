FROM openjdk:11-jre
EXPOSE 9090
ADD target/HotelServices-0.0.1-SNAPSHOT.jar HotelServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/HotelServices-0.0.1-SNAPSHOT.jar"]