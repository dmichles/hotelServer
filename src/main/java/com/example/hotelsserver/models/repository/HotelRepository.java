package com.example.hotelsserver.models.repository;

import com.example.hotelsserver.models.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findHotelByName(String name);
    Hotel findHotelByTo(String to);
    Hotel findHotelById(Long id);

    List<Hotel> findHotelsByLocation(String location);

    @Query(nativeQuery = true, value = "SELECT DISTINCT Hotel.location FROM Hotel WHERE Hotel.location LIKE lower(:str) ")
    List<String> getLocation(@Param("str") String str);


}
