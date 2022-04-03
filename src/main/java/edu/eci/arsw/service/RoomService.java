package edu.eci.arsw.service;

import edu.eci.arsw.model.Room;

import java.util.ArrayList;

public interface RoomService {

    // $ -> BEFORE
    // public void addRoom(Room room);
    // $ -> AFTER
    public Room addRoom(Room room);

    public ArrayList<Room> getRoomByType(String type, Integer userId);

    public void deleteRoom(Integer roomId); 
}
