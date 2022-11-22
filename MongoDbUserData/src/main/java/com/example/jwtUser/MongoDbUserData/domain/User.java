package com.example.jwtUser.MongoDbUserData.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    private int userId;
    private List<Movie> movies;
    private String userName;
    @Id
    private String email;
    private long mobileNo;

    public User() {
    }

    public User(int userId, List<Movie> movies, String userName, String email, long mobileNo) {
        this.userId = userId;
        this.movies = movies;
        this.userName = userName;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", movies=" + movies +
                ", userName='" + userName + '\'' +
                ", address='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
