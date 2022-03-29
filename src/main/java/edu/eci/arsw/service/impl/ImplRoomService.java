package edu.eci.arsw.service.impl;

import edu.eci.arsw.model.Room;
import edu.eci.arsw.persistence.RoomPersistence;
import edu.eci.arsw.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImplRoomService implements RoomService {

    @Autowired
    RoomPersistence roomp = null;

    @Override
    public void addRoom(Room room) {roomp.addRoom(room);}

    @Override
    public ArrayList<Room> getRoomByType(String type, Integer userId) {return roomp.getRoomByType(type, userId);}

    @Override
    public void deleteRoom(Integer roomId) {roomp.deleteRoom(roomId); }
}
