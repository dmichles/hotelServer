package com.example.hotelsserver.models.entities;

public class LocationDto {
    String location;

    public LocationDto(String location) {
        this.location = location;
    }

    public LocationDto() {}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
