package com.example.jwtUser.JWTUserData.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Already Exists Please Check !!!")
public class UserAlreadyExistException extends Exception{
}
