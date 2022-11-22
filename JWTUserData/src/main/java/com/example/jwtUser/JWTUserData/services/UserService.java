package com.example.jwtUser.JWTUserData.services;

import com.example.jwtUser.JWTUserData.domain.User;
import com.example.jwtUser.JWTUserData.exception.UserAlreadyExistException;
import com.example.jwtUser.JWTUserData.exception.UserNotFoundException;

public interface UserService {

    User addUser(User user) throws UserAlreadyExistException;
    User findByEmailAndPassword(String email,String password) throws UserNotFoundException;

}
