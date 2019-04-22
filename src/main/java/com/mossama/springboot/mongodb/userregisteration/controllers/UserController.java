package com.mossama.springboot.mongodb.userregisteration.controllers;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;


import com.mossama.springboot.mongodb.userregisteration.models.User;
import com.mossama.springboot.mongodb.userregisteration.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PayController
 */
@RestController
public class UserController {

    @Autowired
    UserRepository mongo;

    @Value("${added.hours.to.mongodb.utc}")
    private long addedHoursToMongo;

    @PostMapping("/users/{user}")
    public void addUser(@PathVariable("user") String userName) {
        User user = new User();
        user.setUsername(userName);
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("GMT+5"));
        user.setStatus("1");
        user.setDateTime(date);

        mongo.save(user);

        User user1 = mongo.findByUsername(userName);


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        
            String formatDateTime = user1.getDateTime().format(formatter);
            System.out.println(formatDateTime);
            date = LocalDateTime.of(2019, 4, 20,18,0);
            List<User> users = mongo.findByDateTimeGreaterThan(date);
            for (User u : users){
                System.out.println(u.getUsername()+"===="+u.getStatus()+"============"+u.getDateTime());
            }
    }
    
}