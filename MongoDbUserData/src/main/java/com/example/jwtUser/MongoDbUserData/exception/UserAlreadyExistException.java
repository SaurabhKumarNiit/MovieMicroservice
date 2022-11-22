package com.example.jwtUser.MongoDbUserData.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Not Found")
public class UserAlreadyExistException extends Exception{
}
