package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {
    Amenities findByHotel_Id(Long id);
}
