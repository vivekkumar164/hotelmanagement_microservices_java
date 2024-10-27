package com.example.hotelservice.services;

import com.example.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
     Hotel getHotelById(String id);
     List<Hotel> getAllHotels();
     Hotel createHotel(Hotel hotel);
}
