#official maven/Java 8 image to create build artifact
FROM maven:3.8-jdk-11 as builder

#Copy local code to container image
WORKDIR /app
COPY pom.xml .
COPY src ./src

#Build a release artifact
RUN mvn package -DskipTests

#Use AdoptOpenjdk for the base image
FROM adoptopenjdk/openjdk11:alpine-jre

#COPY jar to the production image from the builder stage
COPY --from=builder /app/target/restaurant-*.jar /restaurant.jar

#Run the Webservice whenever container starts
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/restaurants.jar"]
