package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    public Hotel findHotelByName(String name);
}
