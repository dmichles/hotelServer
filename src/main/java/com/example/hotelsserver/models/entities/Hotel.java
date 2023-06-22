package com.example.hotelsserver.models.entities;


import jakarta.persistence.*;

import java.util.List;



@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String picUrl;
    private String to;

    private String stars;

    @OneToMany(mappedBy = "hotel")

    private List<Room> rooms;

    @ElementCollection
    private List<String> amenities;

    private String rating;


    public Hotel(String name, String picUrl, String to, List<Room> rooms,
                 String stars, List<String> amenities, String rating) {
        this.name = name;
        this.picUrl = picUrl;
        this.to = to;
        this.rooms = rooms;
        this.stars = stars;
        this.amenities = amenities;
        this.rating = rating;
    }

    public Hotel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
