package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.Hotel;
import com.example.hotelsserver.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByHotel_Id(Long hotel_id);
}
