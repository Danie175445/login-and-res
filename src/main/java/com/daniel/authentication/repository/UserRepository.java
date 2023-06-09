package com.daniel.authentication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.authentication.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
     
    
}
