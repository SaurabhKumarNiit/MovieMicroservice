FROM openjdk
WORKDIR usr/lib

ENV MONGO_DATABASE="movie_service"
ENV MONGO_URL="mongodb://localhost:27017/movie_service"

ADD ./target/MongoDbUserData-0.0.1-SNAPSHOT.jar /usr/lib/MongoDbUserData-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","MongoDbUserData-0.0.1-SNAPSHOT.jar"]