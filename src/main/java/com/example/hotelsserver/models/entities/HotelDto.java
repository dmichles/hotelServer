package com.example.hotelsserver.models.entities;

public class HotelDto {
    private String name;

    public HotelDto() {}
    public HotelDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
