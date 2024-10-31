package com.example.userservice;

import com.example.userservice.entities.Rating;
import com.example.userservice.external.service.HotelService;
import com.example.userservice.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserserviceApplicationTests {

	@Autowired
	private RatingService ratingService;
    @Autowired
    private HotelService hotelService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void craeteRating(){
//		Rating rating = Rating.builder()
//				.rating(10)
//				.userId("")
//				.hotelId("")
//				.feedback("test feedback userAppliacdtiontest using feign client")
//				.build();
//		ResponseEntity<Rating> savedRatingEntity = 	ratingService.createRating(rating);
//		System.out.println("savedRating"+savedRatingEntity.getBody());
//	}

}
