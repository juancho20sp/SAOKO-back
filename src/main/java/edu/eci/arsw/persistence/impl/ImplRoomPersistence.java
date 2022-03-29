package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.conectdb.CConexion;
import edu.eci.arsw.model.Room;
import edu.eci.arsw.model.Task;
import edu.eci.arsw.persistence.RoomPersistence;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class ImplRoomPersistence implements RoomPersistence {

    private CConexion cConexion = new CConexion();
    private Connection connection = null;

    @Override
    public void addRoom(Room room) {
        System.out.println("roomPersistence.addRoom");
        generateConnection();

        try {
            java.sql.Statement  date = connection.createStatement();
            String sql = "INSERT INTO DB_ROOM (roomName, roomType, userId, roomCode) VALUES ('"+ room.getRoomName() + "','"+ room.getRoomType() + "','" + room.getUserId() + "','" + room.getRoomCode()+ "');";
            date.execute(sql);
            date.close();
            System.out.println("Se creo la sala");
        } catch (SQLException e) {
            System.out.println("No se logro añadir la sala: "+ e);
        }
        disconnectConnection();
    }

    @Override
    public ArrayList<Room> getRoomByType(String type, Integer userId) {
        System.out.println("roomPersistence.getRoomByType");
        generateConnection();

        try {
            ArrayList<Room> finalList = new ArrayList<>();
            java.sql.Statement  date = connection.createStatement();
            ResultSet rs = date.executeQuery("SELECT * FROM DB_ROOM WHERE userId = '" + userId+ "' AND roomType = '" + type + "' ;");
            while (rs.next()) {
                int roomId = rs.getInt("roomId");
                String roomName = rs.getString("roomName");
                String roomType = rs.getString("roomType");
                int roomUserId = rs.getInt("userId");
                int roomCode = rs.getInt("roomCode");

//                System.out.println("ID: " + roomId + "\n" +
//                        "Name: " + roomName + "\n" +
//                        "Type: " + roomType + "\n" +
//                        "User ID: " + roomUserId + "\n" +
//                        "RoomCode: " + roomCode);

                finalList.add(new Room(roomId, roomName, roomType, roomUserId, roomCode));
            }

            date.close();

            return finalList;
        } catch (SQLException e) {
            System.out.println("No se encuentran salas: "+ e);
        }
        disconnectConnection();

        return null;
    }

    @Override
    public void deleteRoom(Integer roomId) {

    }

    private void generateConnection() {
        connection = cConexion.conecDB();
    }

    private void disconnectConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion con la db: "+e);
        }
    }
}
