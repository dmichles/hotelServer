package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
