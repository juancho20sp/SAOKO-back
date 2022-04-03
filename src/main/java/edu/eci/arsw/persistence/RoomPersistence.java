package edu.eci.arsw.persistence;

import edu.eci.arsw.model.Room;

import java.util.ArrayList;

public interface RoomPersistence {
    // $ -> BEFORE
    // public void addRoom(Room room);
    // $ -> AFTER
    public Room addRoom(Room room);

    public Room getRoomByCode(String roomCode);

    public ArrayList<Room> getRoomByType(String type, Integer userId);

    public void deleteRoom(Integer roomId);
}
