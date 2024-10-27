package com.example.userservice.controller;

import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired

    private  UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveduser = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {

        User user = userService.getUserById(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
