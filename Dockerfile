FROM openjdk:8
COPY target/performance-1.0-SNAPSHOT.jar rmq-perf-app.jar
#CMD ["java", "-version"]
CMD ["java", "-jar", "rmq-perf-app.jar"]
