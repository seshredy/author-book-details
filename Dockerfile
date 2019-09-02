FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar book-details.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/book-details.jar"]


# docker build -t author-book-details .
#docker run -p 8080:8080 author-book-details
# Git push test
# Git push test2
