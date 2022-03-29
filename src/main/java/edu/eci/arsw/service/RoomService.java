package edu.eci.arsw.service;

import edu.eci.arsw.model.Room;

import java.util.ArrayList;

public interface RoomService {

    public void addRoom(Room room);

    public ArrayList<Room> getRoomByType(String type, Integer userId);

    public void deleteRoom(Integer roomId); 
}
