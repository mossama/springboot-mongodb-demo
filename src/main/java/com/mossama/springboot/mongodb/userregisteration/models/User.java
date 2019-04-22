package com.mossama.springboot.mongodb.userregisteration.models;

import java.lang.reflect.Constructor;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Hello
 */
@Document("USERS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    
    @Indexed(unique = true)
    private String username;

    private LocalDateTime dateTime;

    private String status;
}