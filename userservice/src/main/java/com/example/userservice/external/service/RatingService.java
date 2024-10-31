package com.example.userservice.external.service;

import com.example.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;
@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating values);
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> UpdateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);

}
