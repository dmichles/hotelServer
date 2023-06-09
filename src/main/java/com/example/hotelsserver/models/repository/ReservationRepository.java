package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.QueryDto;
import com.example.hotelsserver.models.entities.Reservation;
import com.example.hotelsserver.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT e.room FROM Reservation e")
    List<Room> findRooms();

    @Query(value = "SELECT Reservation.id, Reservation.start_date, Reservation.end_date, Room.type, Hotel.name FROM Reservation INNER JOIN Room ON Reservation.room_id = Room.id INNER JOIN Hotel ON Room.hotel_id = Hotel.id",nativeQuery = true)
    List<Object[]> returnObject();

}
