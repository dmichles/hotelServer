package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findHotelByName(String name);
    Hotel findHotelByTo(String to);
}
