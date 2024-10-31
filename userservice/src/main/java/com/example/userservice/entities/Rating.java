package com.example.userservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private String userId;
    private String hotelId;
    private String ratingId;
    private int rating;
    private String feedback;

    private Hotel hotel;
}
