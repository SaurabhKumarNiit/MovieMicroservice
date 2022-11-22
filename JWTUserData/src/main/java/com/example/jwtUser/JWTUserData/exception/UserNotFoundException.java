package com.example.jwtUser.JWTUserData.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found Please check data !!!!!!!!!!")
public class UserNotFoundException extends Exception{
}
