package com.example.hotelsserver.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    private String startDate;
    private String endDate;
    private String travelers;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    public Reservation(Long id, String startDate, String endDate, String travelers, Room room) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.travelers = travelers;
        this.room = room;
    }

    public Reservation() {}

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTravelers() {
        return travelers;
    }

    public void setTravelers(String travelers) {
        this.travelers = travelers;
    }
}
