package com.example.ratingservive.services.impl;

import com.example.ratingservive.entities.Rating;
import com.example.ratingservive.repositories.RatingRepo;
import com.example.ratingservive.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        return ratingRepo.findByUserId(id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepo.findByHotelId(id);
    }
}
