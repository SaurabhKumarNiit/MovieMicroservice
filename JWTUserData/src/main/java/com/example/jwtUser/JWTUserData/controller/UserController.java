package com.example.jwtUser.JWTUserData.controller;

import com.example.jwtUser.JWTUserData.domain.User;
import com.example.jwtUser.JWTUserData.exception.UserAlreadyExistException;
import com.example.jwtUser.JWTUserData.exception.UserNotFoundException;
import com.example.jwtUser.JWTUserData.services.SecurityTokenGenerator;
import com.example.jwtUser.JWTUserData.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    ResponseEntity responseEntity;

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService,SecurityTokenGenerator securityTokenGenerator)
    {
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUer(@RequestBody User user) throws UserAlreadyExistException
    {
        try {
            User user1= userService.addUser(user);
            responseEntity = new ResponseEntity<>(user1, HttpStatus.CREATED);
        }catch (UserAlreadyExistException e){

            throw new UserAlreadyExistException();

        }
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {

        Map<String, String> map = null;
        try {
            User userObj = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userObj.getEmail().equals(user.getEmail()) && userObj.getPassword().equals(user.getPassword())) {
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        }
        catch(UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
