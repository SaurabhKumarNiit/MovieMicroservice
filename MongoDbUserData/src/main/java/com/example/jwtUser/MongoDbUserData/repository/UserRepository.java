package com.example.jwtUser.MongoDbUserData.repository;
import com.example.jwtUser.MongoDbUserData.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {

    User findByEmail(String email);

}
