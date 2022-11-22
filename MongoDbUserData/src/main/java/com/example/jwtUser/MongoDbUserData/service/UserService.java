package com.example.jwtUser.MongoDbUserData.service;

import com.example.jwtUser.MongoDbUserData.domain.Movie;
import com.example.jwtUser.MongoDbUserData.domain.User;
import com.example.jwtUser.MongoDbUserData.exception.UserAlreadyExistException;
import com.example.jwtUser.MongoDbUserData.exception.UserNotFoundException;

public interface UserService {
    User addUser(User user) throws UserAlreadyExistException;

    User addMovieForUser(String email, Movie movie) throws UserNotFoundException;

}
