package com.example.userservice.services;

import com.example.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
//    void deleteUserById(String userId);
//    User updateUser(User user);

}
