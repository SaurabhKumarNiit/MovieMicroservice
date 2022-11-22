package com.example.jwtUser.JWTUserData.services;

import com.example.jwtUser.JWTUserData.domain.User;
import com.example.jwtUser.JWTUserData.exception.UserAlreadyExistException;
import com.example.jwtUser.JWTUserData.exception.UserNotFoundException;
import com.example.jwtUser.JWTUserData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User addUser(User user)throws UserAlreadyExistException {
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException();
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user=userRepository.findByEmailAndPassword(email,password);
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
