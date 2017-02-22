FROM java:8-jre
MAINTAINER Alexey Penchukov <alex.pench@gmail.com>
ADD ./target/chat.jar /app/
CMD ["java", "-jar", "/app/chat.jar"]
EXPOSE 8181