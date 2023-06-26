package com.example.hotelsserver.models.entities;

public class ReservationDto {
    private String id;
    private String startDate;
    private String endDate;

    private String travelers;

    private String roomId;

    public ReservationDto(String id, String startDate, String endDate, String travelers, String  roomId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
        this.travelers = travelers;
        this.id = id;
    }

    public ReservationDto() {}

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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getTravelers() {
        return travelers;
    }

    public void setTravelers(String travelers) {
        this.travelers = travelers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
