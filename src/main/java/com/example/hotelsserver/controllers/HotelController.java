package com.example.hotelsserver.controllers;

import com.example.hotelsserver.models.entities.*;
import com.example.hotelsserver.models.repository.AmenitiesRepository;
import com.example.hotelsserver.models.repository.HotelRepository;
import com.example.hotelsserver.models.repository.ReservationRepository;
import com.example.hotelsserver.models.repository.RoomRepository;
import com.example.hotelsserver.utilities.SortRoomsByPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class HotelController {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    private final AmenitiesRepository amenitiesRepository;

    public HotelController(HotelRepository hotelRepository,
                           RoomRepository roomRepository,
                           ReservationRepository reservationRepository,
                           AmenitiesRepository amenitiesRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.amenitiesRepository = amenitiesRepository;
    }

    @GetMapping("/hotels")
    public ResponseEntity<?> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/getRooms")
    public ResponseEntity<?> getRooms(@RequestParam String to){
        Hotel hotel = hotelRepository.findHotelByTo(to);
        List<Room> rooms = roomRepository.findAllByHotel_Id(hotel.getId());
        Collections.sort(rooms, new SortRoomsByPrice());
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/getHotel")
    public ResponseEntity<?> getHotel(@RequestParam String to) {
        Hotel hotel = hotelRepository.findHotelByTo(to);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/getAmenities")
    public ResponseEntity<?> getAmenities(@RequestParam String to) {
        Hotel hotel = hotelRepository.findHotelByTo(to);
        Amenities amenities = amenitiesRepository.findByHotel_Id(hotel.getId());
        return ResponseEntity.ok(amenities);
    }

    @PostMapping("/addReservation")
    public ResponseEntity<?> addReservation(@RequestBody ReservationDto reservationDto) {

        Reservation reservation = new Reservation();
        reservation.setStartDate(reservationDto.getStartDate());
        reservation.setEndDate(reservationDto.getEndDate());
        Room room = roomRepository.findRoomById(Long.parseLong(reservationDto.getRoomId()));
        reservation.setRoom(room);
        reservationRepository.save(reservation);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/getReservations")
    public ResponseEntity<?> findRooms() {
        List<Object[]> query = reservationRepository.returnObject();
        List<QueryDto> rooms = new ArrayList<>();

        for (Object[] obj: query) {
            QueryDto room = new QueryDto();
            room.setId((Long) obj[0]);
            room.setStartDate((String) obj[1]);
            room.setEndDate((String) obj[2]);
            room.setType((String) obj[3]);
            room.setName((String) obj[4]);
            rooms.add(room);
        }
        return  ResponseEntity.ok(rooms);
    }
}
