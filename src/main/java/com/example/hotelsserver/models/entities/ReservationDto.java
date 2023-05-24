package com.example.hotelsserver.models.entities;

public class ReservationDto {
    private String startDate;
    private String endDate;

    private String roomId;

    public ReservationDto(String startDate, String endDate, String  roomId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
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
}
