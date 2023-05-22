package com.example.hotelsserver.generator;

import com.example.hotelsserver.models.entities.Hotel;
import com.example.hotelsserver.models.entities.Room;
import com.example.hotelsserver.models.repository.HotelRepository;
import com.example.hotelsserver.models.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataGenerator {

    @Bean
    public CommandLineRunner commandLineRunner(HotelRepository hotelRepository, RoomRepository roomRepository) {
        return args -> {
            if (hotelRepository.count() != 0) {
                return;
            }
            Hotel hotel1 = new Hotel();
            hotel1.setName("Intercontinental");
            hotel1.setPicUrl("https://cf.bstatic.com/xdata/images/hotel/max1024x768/341439879.jpg?k=09c6d0d3e13cf0de16e49245a3fd3389bd6ca4b010a05ce7c15929001f221a88&o=&hp=1");
            hotel1.setTo("/Intercontinental");
            hotelRepository.save(hotel1);

            Room room1 = new Room();
            room1.setType("Queen");
            room1.setPrice(new BigDecimal(250));
            room1.setHotel(hotel1);
            roomRepository.save(room1);

            Room room2 = new Room();
            room2.setType("Suite");
            room2.setPrice(new BigDecimal(500));
            room2.setHotel(hotel1);
            roomRepository.save(room2);

            Hotel hotel2 = new Hotel();
            hotel2.setName("Mandarin Oriental");
            hotel2.setPicUrl("https://photos.mandarinoriental.com/is/image/MandarinOriental/new-york-exterior-time-warner-center-at-night?wid=800&fmt=jpeg&op_usm=1,1,5,0&resMode=sharp2&fit=crop&qlt=75,0");
            hotel2.setTo("/MandarinOriental");
            hotelRepository.save(hotel2);

            Room room3 = new Room();
            room3.setType("Queen");
            room3.setPrice(new BigDecimal(350));
            room3.setHotel(hotel2);
            roomRepository.save(room3);

            Room room4 = new Room();
            room4.setType("Suite");
            room4.setPrice(new BigDecimal(600));
            room4.setHotel(hotel2);
            roomRepository.save(room4);

            Hotel hotel3 = new Hotel();
            hotel3.setName("Sofitel");
            hotel3.setPicUrl("https://s3.amazonaws.com/static-webstudio-accorhotels-usa-1.wp-ha.fastbooking.com/wp-content/uploads/sites/6/2016/11/07073007/Building-Exterior-Night-Sky-270x270.jpg");
            hotel3.setTo("/Sofitel");
            hotelRepository.save(hotel3);

            Room room5 = new Room();
            room5.setType("Queen");
            room5.setPrice(new BigDecimal(300));
            room5.setHotel(hotel3);
            room5.setPicUrl("https://www.ahstatic.com/photos/2185_roqed_00_p_2048x1536.jpg");
            room5.setArea("320");
            room5.setPeople("2");
            room5.setBed("Queen");
            roomRepository.save(room5);

            Room room6 = new Room();
            room6.setType("Suite");
            room6.setPrice(new BigDecimal(500));
            room6.setHotel(hotel3);
            room6.setPicUrl("https://www.ahstatic.com/photos/2185_rosqd_00_p_2048x1536.jpg");
            room6.setArea("720");
            room6.setPeople("4");
            room6.setBed("King");
            roomRepository.save(room6);

        };
    }
}
