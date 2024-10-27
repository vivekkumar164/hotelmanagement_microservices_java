package com.example.hotelservice.services.Impl;

import com.example.hotelservice.entities.Hotel;
import com.example.hotelservice.exceptions.ResourceNotFoundException;
import com.example.hotelservice.repositories.HotelRepo;
import com.example.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }
}
