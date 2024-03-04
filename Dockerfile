FROM openjdk:17
ADD target/product-rest.jar product-rest.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","product-rest.jar"]