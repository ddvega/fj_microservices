package com.roboseer.userservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.roboseer.userservice.models.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>
{
    Optional<User> findByUsername(String username);
    User findUserById(String id);
}
