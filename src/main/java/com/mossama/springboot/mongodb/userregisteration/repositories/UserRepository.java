package com.mossama.springboot.mongodb.userregisteration.repositories;

import java.time.LocalDateTime;
import java.util.List;


import com.mossama.springboot.mongodb.userregisteration.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * MongoRepo
 */
@Repository
public interface UserRepository extends CrudRepository<User,String>{
    
       User findByUsername(String username);
       List<User> findByStatusAndDateTimeGreaterThan(String status,LocalDateTime dateTime);
       List<User> findByDateTimeGreaterThan(LocalDateTime dateTime);
    }