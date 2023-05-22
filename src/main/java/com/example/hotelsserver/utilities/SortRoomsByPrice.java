package com.example.hotelsserver.utilities;

import com.example.hotelsserver.models.entities.Room;

import java.util.Comparator;

public class SortRoomsByPrice implements Comparator<Room> {
    @Override
    public int compare(Room a, Room b) {
        return a.getPrice().compareTo(b.getPrice());
    }
}
