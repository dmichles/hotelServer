package com.example.hotelsserver.controllers;

import com.example.hotelsserver.models.entities.Hotel;
import com.example.hotelsserver.models.entities.HotelDto;
import com.example.hotelsserver.models.repository.HotelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/hotels")
    public ResponseEntity<?> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping("/addHotel")
    public ResponseEntity<?> addHotel(@RequestBody HotelDto hotelDto) {
        Hotel hotel = new Hotel(hotelDto.getName());
        System.out.println(hotelDto.getName());
        hotelRepository.save(hotel);
        List<Hotel> hotels = hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }

    @DeleteMapping("/deleteHotel")
    public ResponseEntity<?> deleteHotel(@RequestBody HotelDto hotelDto) {
        System.out.println(hotelDto.getName());
        Hotel hotel = hotelRepository.findHotelByName(hotelDto.getName());
        if (hotel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hotelRepository.delete(hotel);
        List<Hotel> hotels = hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }
}
