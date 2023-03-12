package com.example.hotelsserver.generator;

import com.example.hotelsserver.models.entities.Hotel;
import com.example.hotelsserver.models.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator {

    @Bean
    public CommandLineRunner commandLineRunner(HotelRepository hotelRepository) {
        return args-> {
            if (hotelRepository.count() != 0) {
                return;
            }

            hotelRepository.save(new Hotel("Intercontinental"));
            hotelRepository.save(new Hotel("Mandarin Oriental"));
            hotelRepository.save(new Hotel("Fairmont"));
        };
    }
}
