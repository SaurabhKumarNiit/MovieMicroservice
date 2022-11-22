package com.example.jwtUser.MongoDbUserData.controller;

import com.example.jwtUser.MongoDbUserData.domain.Movie;
import com.example.jwtUser.MongoDbUserData.domain.User;
import com.example.jwtUser.MongoDbUserData.exception.UserAlreadyExistException;
import com.example.jwtUser.MongoDbUserData.exception.UserNotFoundException;
import com.example.jwtUser.MongoDbUserData.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usermovieapp/user")
public class UserController {

    ResponseEntity responseEntity;

    @Autowired
    private UserService userService;


    @PostMapping("/register/")
    public ResponseEntity<?> insertUser(@RequestBody User user) throws UserAlreadyExistException{
        try {
            user.setMovies(new ArrayList<>());
            User user1 = userService.addUser(user);
            responseEntity = new ResponseEntity<>(user1, HttpStatus.OK);
        }catch (UserAlreadyExistException e){
            throw new UserAlreadyExistException();
        }
        return responseEntity;
    }

    @PutMapping("/addMovie/{email}")
    public ResponseEntity<?> findByUserNameAndPassword(@PathVariable String email, @RequestBody Movie movie) throws UserNotFoundException{

        try{
            User user1=userService.addMovieForUser(email, movie);
            responseEntity=new ResponseEntity<>(user1,HttpStatus.OK);

        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }

        return responseEntity;
    }
}
