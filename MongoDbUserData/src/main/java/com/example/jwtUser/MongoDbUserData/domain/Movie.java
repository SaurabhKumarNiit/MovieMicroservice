package com.example.jwtUser.MongoDbUserData.domain;

import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private int movieId;
    private String movieName;
    private int yearOfRelease;
    private String actorName;

    public Movie() {
    }

    public Movie(int movieId, String movieName, int yearOfRelease, String actorName) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.yearOfRelease = yearOfRelease;
        this.actorName = actorName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
