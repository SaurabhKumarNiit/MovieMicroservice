package com.example.jwtUser.JWTUserData.repository;

import com.example.jwtUser.JWTUserData.domain.User;
import com.example.jwtUser.JWTUserData.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email,String password) throws UserNotFoundException;
}
