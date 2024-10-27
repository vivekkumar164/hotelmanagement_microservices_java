package com.example.ratingservive.services;

import com.example.ratingservive.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getRatingByUserId(String id);
    List<Rating> getAllRatings();
    List<Rating> getRatingByHotelId(String id);

}
