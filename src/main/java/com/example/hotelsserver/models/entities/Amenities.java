package com.example.hotelsserver.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Amenities {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String am1;
    private String am2;
    private String am3;
    private String am4;
    private String am5;
    private String am6;

    @OneToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    public Amenities(Long id, String am1, String am2, String am3, String am4, String am5, String am6, Hotel hotel) {
        this.id = id;
        this.am1 = am1;
        this.am2 = am2;
        this.am3 = am3;
        this.am4 = am4;
        this.am5 = am5;
        this.am6 = am6;
        this.hotel = hotel;
    }

    public Amenities() {}

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAm1() {
        return am1;
    }

    public void setAm1(String am1) {
        this.am1 = am1;
    }

    public String getAm2() {
        return am2;
    }

    public void setAm2(String am2) {
        this.am2 = am2;
    }

    public String getAm3() {
        return am3;
    }

    public void setAm3(String am3) {
        this.am3 = am3;
    }

    public String getAm4() {
        return am4;
    }

    public void setAm4(String am4) {
        this.am4 = am4;
    }

    public String getAm5() {
        return am5;
    }

    public void setAm5(String am5) {
        this.am5 = am5;
    }

    public String getAm6() {
        return am6;
    }

    public void setAm6(String am6) {
        this.am6 = am6;
    }
}
