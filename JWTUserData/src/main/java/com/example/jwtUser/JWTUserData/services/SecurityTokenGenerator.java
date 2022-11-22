package com.example.jwtUser.JWTUserData.services;

import com.example.jwtUser.JWTUserData.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
