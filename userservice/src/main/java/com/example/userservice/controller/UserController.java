package com.example.userservice.controller;

import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
        //test
        User saveduser = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {

        User user = userService.getUserById(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //creating fallback method for circuitbreaker

    public ResponseEntity<User> ratingHotelFallback(@PathVariable String userId,Exception ex) {
        System.out.println("fallback executed beacuse service is down "+ ex.getMessage());
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("test")
                .about("service is down")
                .userId("007")
                .build();
        return new   ResponseEntity<>(user,HttpStatus.OK);
    }
}
