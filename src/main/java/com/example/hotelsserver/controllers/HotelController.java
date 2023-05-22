package com.example.hotelsserver.controllers;

import com.example.hotelsserver.models.entities.Hotel;
import com.example.hotelsserver.models.entities.Room;
import com.example.hotelsserver.models.repository.HotelRepository;
import com.example.hotelsserver.models.repository.RoomRepository;
import com.example.hotelsserver.utilities.SortRoomsByPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class HotelController {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public HotelController(HotelRepository hotelRepository,
                           RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/hotels")
    public ResponseEntity<?> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/getRooms")
    public ResponseEntity<?> getRooms(@RequestParam String name){
        Hotel hotel = hotelRepository.findHotelByName(name);
        List<Room> rooms = roomRepository.findAllByHotel_Id(hotel.getId());
        Collections.sort(rooms, new SortRoomsByPrice());
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/getHotel")
    public ResponseEntity<?> getHotel(@RequestParam String name) {
        Hotel hotel = hotelRepository.findHotelByName(name);
        return ResponseEntity.ok(hotel);
    }
}
