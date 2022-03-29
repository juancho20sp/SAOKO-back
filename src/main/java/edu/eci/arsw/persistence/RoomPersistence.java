package edu.eci.arsw.persistence;

import edu.eci.arsw.model.Room;

import java.util.ArrayList;

public interface RoomPersistence {
    public void addRoom(Room room);

    public ArrayList<Room> getRoomByType(String type, Integer userId);

    public void deleteRoom(Integer roomId);
}
