package com.example.jwtUser.MongoDbUserData.service;

import com.example.jwtUser.MongoDbUserData.domain.Movie;
import com.example.jwtUser.MongoDbUserData.domain.User;
import com.example.jwtUser.MongoDbUserData.exception.UserAlreadyExistException;
import com.example.jwtUser.MongoDbUserData.exception.UserNotFoundException;
import com.example.jwtUser.MongoDbUserData.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if(userRepository.findById(user.getEmail()).isPresent()){

            throw new UserAlreadyExistException ();
        }
        return userRepository.insert(user);
    }

    @Override
    public User addMovieForUser(String email, Movie movie) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
            User user = userRepository.findByEmail(email);

        if(user.getMovies()==null){
            user.setMovies(Arrays.asList(movie));
        }else{
            List<Movie> movies=user.getMovies();
            movies.add(movie);
            user.setMovies(movies);
        }
            return userRepository.save(user);
    }
}
