package com.example.userservice.services.impl;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import com.example.userservice.entities.User;
import com.example.userservice.exceptions.ResourceNotFoundException;
import com.example.userservice.external.service.HotelService;
import com.example.userservice.repositoriers.UserRepository;
import com.example.userservice.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

   // private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
      String randomUserId =   UUID.randomUUID().toString();
      user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with id " + userId + " not found"));
        //restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
        Rating[] userRating=  restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(),Rating[].class);

        List<Rating> ratings = Arrays.stream(userRating).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/1519b043-ad13-4841-89ef-89f1d4cb4b16
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            //Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //set the hotel rating
            rating.setHotel(hotel);
            //return rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
