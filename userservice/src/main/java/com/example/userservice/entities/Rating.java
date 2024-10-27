package com.example.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rating {
    private String userId;
    private String hotelId;
    private String ratingId;
    private String rating;
    private String feedback;
}
